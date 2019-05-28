package com.uncle.components.monitor.message.consumer;


import com.alibaba.fastjson.JSON;
import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.api.enums.NotifyTypeEnum;
import com.uncle.components.monitor.message.bo.MonitorMessageLogBoWithBLOBs;
import com.uncle.components.monitor.message.dao.MonitorMessageLogMapper;
import com.uncle.components.monitor.message.processor.AbstractNotifyProcessor;
import com.uncle.components.monitor.message.processor.impl.MonitorMessageMailProcessorAbstract;
import com.uncle.components.monitor.message.processor.impl.MonitorMessageSmsProcessorAbstract;
import com.uncle.components.monitor.message.processor.impl.MonitorMessageXTeamProcessorAbstract;
import com.uncle.components.monitor.message.service.NotifyService;
import com.uncle.core.DelStateEnum;
import com.uncle.core.ReturnCode;
import com.uncle.core.SysCode;
import com.uncle.message.api.dto.ReceiveMessageDTO;
import com.uncle.plugin.mq.rocketmq.annotation.RocketMQMessageListener;
import com.uncle.plugin.mq.rocketmq.core.RocketMQListener;
import com.uncle.plugin.mybatis.transaction.OutstandingTransactionCallback;
import com.uncle.plugin.mybatis.transaction.OutstandingTransactionTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 消费消息日志消息
 *
 * @author 杨戬
 * @email yangbo@email.com
 */
@Slf4j
@RocketMQMessageListener(topic = "${check.rocketmq.consumerMonitorLogTopic}", consumerGroup = "${rocketmq.consumer.group}")
@Service
public class MonitorMessageLogConsumer implements RocketMQListener<ReceiveMessageDTO> {


    @Resource
    private NotifyService notifyMailService;
    @Resource
    private NotifyService notifySmsService;
    @Resource
    private NotifyService notifyXTeamService;
    @Resource
    private MonitorMessageLogMapper messageLogMapper;
    @Resource
    private OutstandingTransactionTemplate forceTransactionTemplate;

    @Override
    public void onMessage(ReceiveMessageDTO receiveMessageDTO, MessageExt messageExt) {

        if (receiveMessageDTO != null && !StringUtils.isBlank(receiveMessageDTO.getMessageBody())) {

            MonitorMessageLogDto monitorMessageLogDto = JSON.parseObject(receiveMessageDTO.getMessageBody(), MonitorMessageLogDto.class);


            forceTransactionTemplate.execute((OutstandingTransactionCallback<ReturnCode>) status -> {
                //执行入库操作
                messageLogMapper.insert(this.buildMessageLog(monitorMessageLogDto));

                return SysCode.SUCCESS;
            });

            //从判断是否需要投送
            if (monitorMessageLogDto.isPost()) {
                this.notifyRouting(monitorMessageLogDto);
            }
        }
    }


    private void notifyRouting(MonitorMessageLogDto monitorMessageLogDto) {

        int initialCapacity = 3;

        Map<NotifyTypeEnum, AbstractNotifyProcessor> map = new HashMap<>(initialCapacity);
        map.put(NotifyTypeEnum.EMAIL, new MonitorMessageMailProcessorAbstract(notifyMailService));
        map.put(NotifyTypeEnum.SMS, new MonitorMessageSmsProcessorAbstract(notifySmsService));
        map.put(NotifyTypeEnum.XTEAM, new MonitorMessageXTeamProcessorAbstract(notifyXTeamService));

        Set<NotifyTypeEnum> notifyTypeEnums = map.keySet();
        for (NotifyTypeEnum key : notifyTypeEnums) {
            if (monitorMessageLogDto.getNotifyType().equals(key)) {
                //路由
                map.get(key).process(monitorMessageLogDto);
            }
        }
    }

    private MonitorMessageLogBoWithBLOBs buildMessageLog(MonitorMessageLogDto monitorMessageLogDto) {

        MonitorMessageLogBoWithBLOBs clone = monitorMessageLogDto.clone(MonitorMessageLogBoWithBLOBs.class);

        if (!StringUtils.isBlank(monitorMessageLogDto.getExceptionInfo())) {
            clone.setExceptionInfo(monitorMessageLogDto.getExceptionInfo().getBytes(StandardCharsets.UTF_8));
        }
        clone.setMessageBody(monitorMessageLogDto.getMessageBody().getBytes(StandardCharsets.UTF_8));

        clone.setCreateTime(new Date());
        clone.setUpdateTime(new Date());
        clone.setDelState(DelStateEnum.NORMAL);
        clone.setVersion(1L);

        return clone;
    }

}

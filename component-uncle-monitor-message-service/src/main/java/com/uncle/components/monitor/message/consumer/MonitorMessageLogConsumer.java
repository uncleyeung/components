package com.uncle.components.monitor.message.consumer;


import com.alibaba.fastjson.JSON;
import com.outstanding.framework.core.DelStateEnum;
import com.outstanding.framework.core.ReturnCode;
import com.outstanding.framework.core.SysCode;
import com.outstanding.framework.plugin.mq.rocketmq.annotation.RocketMQMessageListener;
import com.outstanding.framework.plugin.mq.rocketmq.core.RocketMQListener;
import com.outstanding.framework.plugin.mybatis.transaction.OutstandingTransactionCallback;
import com.outstanding.framework.plugin.mybatis.transaction.OutstandingTransactionTemplate;
import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.api.enums.NotifyTypeEnum;
import com.uncle.components.monitor.message.bo.MonitorMessageLogBoWithBLOBs;
import com.uncle.components.monitor.message.dao.MonitorMessageLogMapper;
import com.uncle.components.monitor.message.eo.MailRecordTemplateEo;
import com.uncle.components.monitor.message.eo.SmsRecordTemplateEo;
import com.uncle.components.monitor.message.eo.XTeamRecordTemplateEo;
import com.uncle.components.monitor.message.processor.NotifyProcessor;
import com.uncle.components.monitor.message.processor.impl.MonitorMessageMailProcessor;
import com.uncle.components.monitor.message.processor.impl.MonitorMessageSmsProcessor;
import com.uncle.components.monitor.message.processor.impl.MonitorMessageXTeamProcessor;
import com.uncle.components.monitor.message.service.NotifyService;
import com.uncle.message.api.dto.ReceiveMessageDTO;
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
    private NotifyService<MailRecordTemplateEo> notifyMailService;
    @Resource
    private NotifyService<SmsRecordTemplateEo> notifySmsService;
    @Resource
    private NotifyService<XTeamRecordTemplateEo> notifyXTeamService;
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

        Map<NotifyTypeEnum, NotifyProcessor> map = new HashMap<>();
        map.put(NotifyTypeEnum.EMAIL, new MonitorMessageMailProcessor(notifyMailService));
        map.put(NotifyTypeEnum.SMS, new MonitorMessageSmsProcessor(notifySmsService));
        map.put(NotifyTypeEnum.XTEAM, new MonitorMessageXTeamProcessor(notifyXTeamService));

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

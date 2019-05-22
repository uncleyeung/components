package com.uncle.components.monitor.message.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.service.MonitorMessageLogService;
import com.uncle.message.api.MessageFacade;
import com.uncle.message.api.dto.SendMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 14:04
 */
@Service("messageMonitorLogService")
@Slf4j
public class MonitorMessageLogServiceImpl implements MonitorMessageLogService {

    private static final String CHAOS_MONITOR_MESSAGE_LOG_TOPIC = "UNCLE_MONITOR_MESSAGE_LOG_TOPIC";

    @Reference(version = "1.0.0")
    private MessageFacade componentVipayMessageFacade;

    @Override
    public void sendLogInfoMessage(MonitorMessageLogDto dto) {
        SendMessageDTO sendMessageDTO = new SendMessageDTO();
        sendMessageDTO.setMessageBody(JSON.toJSONString(dto));
        sendMessageDTO.setConsumerQueue(CHAOS_MONITOR_MESSAGE_LOG_TOPIC);
        sendMessageDTO.setBusinessUnique(dto.getBusinessId());
        componentVipayMessageFacade.saveAndSendMessage(sendMessageDTO);
        log.info(CHAOS_MONITOR_MESSAGE_LOG_TOPIC + " | 消息发送成功消息体:[{}]", dto);
    }
}

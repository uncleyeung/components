package com.uncle.components.monitor.message.processor.impl;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.eo.SmsRecordTemplateEo;
import com.uncle.components.monitor.message.processor.NotifyProcessor;
import com.uncle.components.monitor.message.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 杨戬
 * @className MonitorMessageLogConsumerImpl
 * @email yangbo@email.com
 * @date 2019/3/22 15:25
 */
@Slf4j
@Service("monitorMessageSmsProcessor")
public class MonitorMessageSmsProcessor implements NotifyProcessor<SmsRecordTemplateEo> {


    private NotifyService<SmsRecordTemplateEo> notifySmsService;

    public MonitorMessageSmsProcessor(NotifyService<SmsRecordTemplateEo> notifySmsService) {
        this.notifySmsService = notifySmsService;
    }

    @Override
    public void process(MonitorMessageLogDto monitorMessageLogDto) {
        //todo
        //失败到阈值要调用发送预警信息
        notifySmsService.notifyAsync(new SmsRecordTemplateEo());
    }
}

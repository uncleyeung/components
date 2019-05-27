package com.uncle.components.monitor.message.processor.impl;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.eo.SmsRecordTemplateEo;
import com.uncle.components.monitor.message.processor.AbstractNotifyProcessor;
import com.uncle.components.monitor.message.service.NotifyService;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
public class MonitorMessageSmsProcessorAbstract extends AbstractNotifyProcessor<SmsRecordTemplateEo> {

    public MonitorMessageSmsProcessorAbstract(NotifyService<SmsRecordTemplateEo> service) {
        super(service);
    }

    @Override
    public void process(MonitorMessageLogDto monitorMessageLogDto) {
        //todo
        //失败到阈值要调用发送预警信息
        service.notifyAsync(new SmsRecordTemplateEo());
    }
}

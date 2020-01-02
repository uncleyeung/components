package com.uncle.components.monitor.message.processor.impl;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.eo.XTeamRecordTemplateEo;
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
@Service("monitorMessageXTeamProcessor")
@NoArgsConstructor
public class MonitorMessageXTeamProcessorAbstract extends AbstractNotifyProcessor<XTeamRecordTemplateEo> {


    public MonitorMessageXTeamProcessorAbstract(NotifyService<XTeamRecordTemplateEo> service) {
        super(service);
    }

    @Override
    public void process(MonitorMessageLogDto monitorMessageLogDto) {
        //失败到阈值要调用发送预警信息
        service.notifyAsync(new XTeamRecordTemplateEo());
    }
}

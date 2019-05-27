package com.uncle.components.monitor.message.processor;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.service.NotifyService;
import lombok.NoArgsConstructor;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 15:34
 */
@NoArgsConstructor
public abstract class AbstractNotifyProcessor<T> {

    protected NotifyService<T> service;


    protected AbstractNotifyProcessor(NotifyService<T> service) {
        this.service = service;
    }

    /**
     * 通知处理器
     *
     * @param monitorMessageLogDto 通知内容
     */
    public abstract void process(MonitorMessageLogDto monitorMessageLogDto);
}

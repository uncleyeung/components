package com.uncle.components.monitor.message.processor;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;

/**
 * @author 杨戬
 * @className NotifyProcessor
 * @email yangb@chaosource.com
 * @date 2019/3/22 15:34
 */
public interface NotifyProcessor<T> {


    /**
     * 通知处理器
     *
     * @param monitorMessageLogDto 通知内容
     */
    void process(MonitorMessageLogDto monitorMessageLogDto);
}

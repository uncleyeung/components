package com.uncle.components.monitor.message.api.facade;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 2019/3/22 11:18
 */
public interface MonitorMessageFacade {

    /**
     * 消息监控方法
     *
     * @param dto 监控体
     */
    void logInfo(MonitorMessageLogDto dto);
}

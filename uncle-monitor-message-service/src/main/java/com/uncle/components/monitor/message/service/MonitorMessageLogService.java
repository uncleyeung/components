package com.uncle.components.monitor.message.service;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 2019/3/22 14:01
 */
public interface MonitorMessageLogService {
    /**
     * 发送日志保存消息
     *
     * @param dto 消息内容
     */
    void sendLogInfoMessage(MonitorMessageLogDto dto);
}

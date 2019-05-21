package com.uncle.components.monitor.message.facade.impl;

import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.api.facade.MonitorMessageFacade;
import com.uncle.components.monitor.message.service.MonitorMessageLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 11:41
 */
@Service("monitorMessageFacade")
public class MonitorMessageFacadeImpl implements MonitorMessageFacade {

    @Resource
    private MonitorMessageLogService logService;

    @Override
    public void logInfo(MonitorMessageLogDto dto) {
        logService.sendLogInfoMessage(dto);
    }
}

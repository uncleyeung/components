package com.uncle.components.monitor.message.service.impl;

import com.uncle.components.monitor.message.eo.XTeamRecordTemplateEo;
import com.uncle.components.monitor.message.service.NotifyService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 14:50
 */
@Service("notifyXTeamService")
public class NotifyXTeamServiceImpl implements NotifyService<XTeamRecordTemplateEo> {
    @Override
    public boolean notify(XTeamRecordTemplateEo template) {
        //todo
        return false;
    }

    @Override
    @Async
    public Future<Boolean> notifyAsync(XTeamRecordTemplateEo template) {
        return new AsyncResult<>(this.notify(template));
    }
}

package com.uncle.components.monitor.message.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.uncle.components.monitor.message.eo.SmsRecordTemplateEo;
import com.uncle.components.monitor.message.service.NotifyService;
import com.uncle.sms.api.SmsSendRecordFacade;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 14:50
 */
@Service("notifySmsService")
public class NotifySmsServiceImpl implements NotifyService<SmsRecordTemplateEo> {
    @Reference(version = "1.0.0", registry = {"${vipay.dubbo.registry}"})
    private SmsSendRecordFacade smsSendRecordFacade;

    @Override
    public boolean notify(SmsRecordTemplateEo template) {
        //todo
        return false;
    }

    @Override
    @Async
    public Future<Boolean> notifyAsync(SmsRecordTemplateEo template) {
        return new AsyncResult<>(this.notify(template));
    }
}

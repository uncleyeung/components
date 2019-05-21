package com.uncle.components.monitor.message.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.uncle.components.monitor.message.eo.MailRecordTemplateEo;
import com.uncle.components.monitor.message.service.NotifyService;
import com.chaos.mail.api.MailSendFacade;
import com.outstanding.framework.core.PendingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 14:50
 */
@Slf4j
@Service("notifyMailService")
public class NotifyMailServiceImpl implements NotifyService<MailRecordTemplateEo> {
    @Reference(version = "1.0.0", registry = {"${vipay.dubbo.registry}"})
    private MailSendFacade mailSendFacade;

    @Override
    public boolean notify(MailRecordTemplateEo template) {
        try {
            mailSendFacade.sendSimpleMail(template.getRecord());
            log.info("异常信息推送邮件成功:{}", JSON.toJSONString(template));
            return true;
        } catch (PendingException e) {
            //todo
            e.printStackTrace();
            return false;
        }
    }

    @Override
    @Async
    public Future<Boolean> notifyAsync(MailRecordTemplateEo template) {
        return new AsyncResult<>(this.notify(template));
    }
}

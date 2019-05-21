package com.uncle.components.monitor.message.processor.impl;

import com.alibaba.fastjson.JSON;
import com.uncle.components.monitor.message.api.dto.MonitorMessageLogDto;
import com.uncle.components.monitor.message.api.utils.SplitUtil;
import com.uncle.components.monitor.message.eo.MailRecordTemplateEo;
import com.uncle.components.monitor.message.processor.NotifyProcessor;
import com.uncle.components.monitor.message.service.NotifyService;
import com.chaos.mail.api.bo.SimpleMailBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author 杨戬
 * @className MonitorMessageLogConsumerImpl
 * @email yangbo@email.com
 * @date 2019/3/22 15:25
 */
@Slf4j
@Service("monitorMessageMailProcessor")
public class MonitorMessageMailProcessor implements NotifyProcessor<MailRecordTemplateEo> {


    private NotifyService<MailRecordTemplateEo> notifyMailService;

    public MonitorMessageMailProcessor(NotifyService<MailRecordTemplateEo> notifyMailService) {
        this.notifyMailService = notifyMailService;
    }

    @Override
    public void process(MonitorMessageLogDto monitorMessageLogDto) {
        //失败到阈值要调用发送预警信息
        if (monitorMessageLogDto != null) {
            MailRecordTemplateEo mailRecordTemplateEo = new MailRecordTemplateEo();

            SimpleMailBo simpleMailBo = new SimpleMailBo();

            simpleMailBo.setFrom("china.zhao.gfw@outlook.com");
            simpleMailBo.setSubject("《test》消费Topic:{" + monitorMessageLogDto.getMessageTopic() + "} messageId:{" + monitorMessageLogDto.getMessageId() + "}!!!出现异常!!!");
            simpleMailBo.setTextContent("消息内容:\n{" + monitorMessageLogDto.getMessageBody() + "\n} \n\n\n\n异常信息:\n{" + (monitorMessageLogDto.getExceptionInfo() == null ? "无" : SplitUtil.substringByBytes(monitorMessageLogDto.getExceptionInfo(), 5000)[0]) + "}\n");
            simpleMailBo.setAddress(monitorMessageLogDto.getTarget());

            mailRecordTemplateEo.setRecord(simpleMailBo);
            log.info("开始异常信息邮件推送:{} | 异常Topic:{} ｜messageId:{}", JSON.toJSONString(mailRecordTemplateEo), monitorMessageLogDto.getMessageTopic(), monitorMessageLogDto.getMessageId());
            Future<Boolean> booleanFuture = notifyMailService.notifyAsync(mailRecordTemplateEo);
            booleanFuture.isDone();
        }
    }
}

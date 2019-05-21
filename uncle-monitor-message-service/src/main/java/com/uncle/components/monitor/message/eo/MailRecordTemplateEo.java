package com.uncle.components.monitor.message.eo;

import com.chaos.mail.api.bo.SimpleMailBo;
import com.chaos.sms.api.bo.SmsGatewayBO;
import com.chaos.sms.api.bo.SmsRecordBO;
import com.chaos.sms.api.bo.SmsTemplateBO;

/**
 * @author 杨戬
 * @email yangbo@email.com
 * @date 2019/3/22 14:58
 */
public class MailRecordTemplateEo {
    private SimpleMailBo record;

    public SimpleMailBo getRecord() {
        return record;
    }

    public void setRecord(SimpleMailBo record) {
        this.record = record;
    }
}

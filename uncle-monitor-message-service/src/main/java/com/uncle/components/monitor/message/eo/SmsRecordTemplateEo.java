package com.uncle.components.monitor.message.eo;

import com.chaos.sms.api.bo.SmsGatewayBO;
import com.chaos.sms.api.bo.SmsRecordBO;
import com.chaos.sms.api.bo.SmsTemplateBO;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 2019/3/22 14:58
 */
public class SmsRecordTemplateEo {
    private SmsRecordBO record;
    private SmsTemplateBO template;
    private SmsGatewayBO gateway;

    public SmsRecordBO getRecord() {
        return record;
    }

    public void setRecord(SmsRecordBO record) {
        this.record = record;
    }

    public SmsTemplateBO getTemplate() {
        return template;
    }

    public void setTemplate(SmsTemplateBO template) {
        this.template = template;
    }

    public SmsGatewayBO getGateway() {
        return gateway;
    }

    public void setGateway(SmsGatewayBO gateway) {
        this.gateway = gateway;
    }
}

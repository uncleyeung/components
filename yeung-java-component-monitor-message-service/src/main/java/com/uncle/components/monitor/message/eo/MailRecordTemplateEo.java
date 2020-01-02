package com.uncle.components.monitor.message.eo;

import com.uncle.mail.api.bo.SimpleMailBo;

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

package com.uncle.components.monitor.message.bo;

import java.io.Serializable;

public class MonitorMessageLogBoWithBLOBs extends MonitorMessageLogBo implements Serializable {

    /**
     * 业务数据
     */
    private byte[] messageBody;

    /**
     * 异常信息
     */
    private byte[] exceptionInfo;

    private static final long serialVersionUID = 1L;

    public byte[] getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(byte[] messageBody) {
        this.messageBody = messageBody;
    }

    public byte[] getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(byte[] exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
}
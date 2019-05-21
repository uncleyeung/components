package com.uncle.components.monitor.message.bo;

import com.uncle.components.monitor.message.api.enums.MsgStatusEnum;
import com.uncle.components.monitor.message.bo.base.BaseDefBo;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 2019/3/22 16:43
 */
public class MonitorMessageLogBo extends BaseDefBo{
    /**
     * 消息ID
     */
    private String messageId;

    /**
     * 消息BornHost
     */
    private String messageBornHost;

    /**
     * 消息主题
     */
    private String messageTopic;

    /**
     * 消息Tag
     */
    private String messageTag;


    /**
     * 状态
     */
    private MsgStatusEnum status;


    /**
     * 业务数据ID
     */
    private String businessId;

    /**
     * 事件编码
     */
    private String eventCode;


    /**
     * 系统
     */
    private String system;

    /**
     * 模块
     */
    private String module;

    /**
     * 操作
     */
    private String action;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageBornHost() {
        return messageBornHost;
    }

    public void setMessageBornHost(String messageBornHost) {
        this.messageBornHost = messageBornHost;
    }

    public String getMessageTopic() {
        return messageTopic;
    }

    public void setMessageTopic(String messageTopic) {
        this.messageTopic = messageTopic;
    }

    public String getMessageTag() {
        return messageTag;
    }

    public void setMessageTag(String messageTag) {
        this.messageTag = messageTag;
    }

    public MsgStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MsgStatusEnum status) {
        this.status = status;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

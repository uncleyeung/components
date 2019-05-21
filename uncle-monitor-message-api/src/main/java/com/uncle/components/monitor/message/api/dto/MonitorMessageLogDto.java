package com.uncle.components.monitor.message.api.dto;

import com.uncle.components.monitor.message.api.base.MonitorBaseDto;
import com.uncle.components.monitor.message.api.enums.MsgStatusEnum;
import com.uncle.components.monitor.message.api.enums.NotifyTypeEnum;
import com.uncle.components.monitor.message.api.utils.SplitUtil;

import java.util.List;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 2019/3/22 11:16
 */
public class MonitorMessageLogDto extends MonitorBaseDto {
    private static final long serialVersionUID = 222421137011612360L;
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
     * 业务数据
     */
    private String messageBody;

    /**
     * 异常信息
     */
    private String exceptionInfo;

    /**
     * 状态
     */
    private MsgStatusEnum status;

    /**
     * 是否投递
     */
    private boolean isPost;

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

    /**
     * 接收方
     */
    private List<String> target;

    /**
     * 枚举 邮件/短信/xteam
     */
    private NotifyTypeEnum notifyType;


    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
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

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public boolean isPost() {
        return isPost;
    }

    public List<String> getTarget() {
        return target;
    }

    public void setTarget(List<String> target) {
        this.target = target;
    }

    public NotifyTypeEnum getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(NotifyTypeEnum notifyType) {
        this.notifyType = notifyType;
    }

    public void setPost(boolean post) {
        isPost = post;
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

    @Override
    public String toString() {
        return "MonitorMessageLogDto{" +
                "messageId='" + messageId + '\'' +
                ", messageBornHost='" + messageBornHost + '\'' +
                ", messageTopic='" + messageTopic + '\'' +
                ", messageTag='" + messageTag + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", exceptionInfo='" + SplitUtil.substringByBytes(exceptionInfo, 900)[0] + '\'' +
                ", status=" + status +
                ", isPost=" + isPost +
                ", businessId='" + businessId + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", system='" + system + '\'' +
                ", module='" + module + '\'' +
                ", action='" + action + '\'' +
                ", target=" + target +
                ", notifyType=" + notifyType +
                '}';
    }
}

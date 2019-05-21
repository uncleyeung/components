package com.uncle.components.monitor.message.api.enums;

import com.outstanding.framework.core.BaseEnum;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 */
public enum NotifyTypeEnum implements BaseEnum<NotifyTypeEnum, Integer> {
    /**
     * 短信
     */
    SMS(10, "短信"),
    /**
     * 邮件
     */
    EMAIL(11, "邮件"),
    /**
     * XTeam
     */
    XTEAM(12, "XTeam");

    private Integer code;
    private String message;

    private NotifyTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static NotifyTypeEnum getByCode(Integer code) {
        NotifyTypeEnum[] array = NotifyTypeEnum.values();
        for (NotifyTypeEnum s : array) {
            if (s.getCode().equals(code)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.uncle.components.monitor.message.api.enums;

import com.outstanding.framework.core.BaseEnum;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 */
public enum MsgStatusEnum implements BaseEnum<MsgStatusEnum, Integer> {
    /**
     * 成功
     */
    SUCCESS(10, "成功"),
    /**
     * 错误
     */
    ERROR(11, "错误");

    private Integer code;
    private String message;

    private MsgStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static MsgStatusEnum getByCode(Integer code) {
        MsgStatusEnum[] array = MsgStatusEnum.values();
        for (MsgStatusEnum s : array) {
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

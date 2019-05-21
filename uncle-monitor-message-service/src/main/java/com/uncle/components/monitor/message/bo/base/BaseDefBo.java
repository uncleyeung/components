package com.uncle.components.monitor.message.bo.base;

import com.outstanding.framework.core.EntityObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 杨戬
 * @email yangb@chaosource.com
 * @date 16:28 2018/11/13
 */
public class BaseDefBo extends EntityObject {
    /**
     * 扩展字段
     */
    private String def1;
    private String def2;
    private String def3;
    private String def4;
    private String remark;

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

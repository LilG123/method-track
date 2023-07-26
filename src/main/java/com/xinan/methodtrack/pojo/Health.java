package com.xinan.methodtrack.pojo;

/**
 * @author lilg
 * @date 2023/7/25
 */
public class Health {

    private Boolean success;

    private Long lastCallTime;

    public Long getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(Long lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

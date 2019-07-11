package com.itany.vo;

/**
 * Author:wenlixu
 * Date:2019/3/27 14:45
 * Description:
 * Version:1.0
 */
public class AjaxResult {

    private Boolean success;

    private String msg;

    private Object data;



    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

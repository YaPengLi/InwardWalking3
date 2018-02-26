package com.silent.fiveghost.guide.entity;

import java.util.List;

/**
 * Created by  on 2018/1/29.
 */

public class SendEntity {


    /**
     * errcode : -1
     * errmsg : 短信已在1分钟内发出，请耐心等待
     * data : []
     */

    private int errcode;
    private String errmsg;
    private List<?> data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}

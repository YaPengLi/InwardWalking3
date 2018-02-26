package com.silent.fiveghost.guide.entity;

/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/2/24.
 */

public class QiangBean {
    /**
     * errcode : 1
     * errmsg : ok
     * data : {}
     */

    private int errcode;
    private String errmsg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}

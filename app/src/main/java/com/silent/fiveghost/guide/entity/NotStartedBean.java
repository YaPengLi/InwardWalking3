package com.silent.fiveghost.guide.entity;

/**
 * 认真的人到最后都是难过 2018/1/28.
 */

public class NotStartedBean {
    private String city;
    private String time;
    private String num;
    private String like;
    private String leixing;
    private String lv_fengjing;

    @Override
    public String toString() {
        return "NotStartedBean{" +
                "city='" + city + '\'' +
                ", time='" + time + '\'' +
                ", num='" + num + '\'' +
                ", like='" + like + '\'' +
                ", leixing='" + leixing + '\'' +
                '}';
    }

    public String getLv_fengjing() {
        return lv_fengjing;
    }

    public void setLv_fengjing(String lv_fengjing) {
        this.lv_fengjing = lv_fengjing;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public NotStartedBean(String city, String time, String num, String like, String leixing,String lv_fengjing) {

        this.city = city;
        this.time = time;
        this.num = num;
        this.like = like;
        this.leixing = leixing;
        this.lv_fengjing=lv_fengjing;
    }
}

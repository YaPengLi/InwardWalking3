package com.silent.fiveghost.guide.entity;

import java.util.List;

/**
 * Created by 农民伯伯 on 2018/2/23.
 */

public class RouteDetailsEntity {

    /**
     * errcode : 1
     * errmsg : ok
     * data : {"id":"95","name":"旅行测试-20180202","toute_type":"1","order_type":"1","g_uid":"10","t_uid":"0","play_days":"10","start_city":"0","is_recommend":"1","img":"imgtest","price":"0.00","children_price":"0.00","tips":"","notice":"报名须知","attention":"","desc":"","number":"10","age_group":"0","travel_time":"2018-01-07 00:00:00","travel_info":[{"cityId":"1","guide_type":3,"g_uid":10,"play_days":"3","travel_preference":"aa","remarks":"备注"}],"is_template":"1","ctime":"1519306070","utime":"1519306070"}
     */

    private String errcode;
    private String errmsg;
    private DataBean data;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
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
        /**
         * id : 95
         * name : 旅行测试-20180202
         * toute_type : 1
         * order_type : 1
         * g_uid : 10
         * t_uid : 0
         * play_days : 10
         * start_city : 0
         * is_recommend : 1
         * img : imgtest
         * price : 0.00
         * children_price : 0.00
         * tips :
         * notice : 报名须知
         * attention :
         * desc :
         * number : 10
         * age_group : 0
         * travel_time : 2018-01-07 00:00:00
         * travel_info : [{"cityId":"1","guide_type":3,"g_uid":10,"play_days":"3","travel_preference":"aa","remarks":"备注"}]
         * is_template : 1
         * ctime : 1519306070
         * utime : 1519306070
         */

        private String id;
        private String name;
        private String toute_type;
        private String order_type;
        private String g_uid;
        private String t_uid;
        private String play_days;
        private String start_city;
        private String is_recommend;
        private String img;
        private String price;
        private String children_price;
        private String tips;
        private String notice;
        private String attention;
        private String desc;
        private String number;
        private String age_group;
        private String travel_time;
        private String is_template;
        private String ctime;
        private String utime;
        private List<TravelInfoBean> travel_info;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getToute_type() {
            return toute_type;
        }

        public void setToute_type(String toute_type) {
            this.toute_type = toute_type;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public String getG_uid() {
            return g_uid;
        }

        public void setG_uid(String g_uid) {
            this.g_uid = g_uid;
        }

        public String getT_uid() {
            return t_uid;
        }

        public void setT_uid(String t_uid) {
            this.t_uid = t_uid;
        }

        public String getPlay_days() {
            return play_days;
        }

        public void setPlay_days(String play_days) {
            this.play_days = play_days;
        }

        public String getStart_city() {
            return start_city;
        }

        public void setStart_city(String start_city) {
            this.start_city = start_city;
        }

        public String getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(String is_recommend) {
            this.is_recommend = is_recommend;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getChildren_price() {
            return children_price;
        }

        public void setChildren_price(String children_price) {
            this.children_price = children_price;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getAttention() {
            return attention;
        }

        public void setAttention(String attention) {
            this.attention = attention;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getAge_group() {
            return age_group;
        }

        public void setAge_group(String age_group) {
            this.age_group = age_group;
        }

        public String getTravel_time() {
            return travel_time;
        }

        public void setTravel_time(String travel_time) {
            this.travel_time = travel_time;
        }

        public String getIs_template() {
            return is_template;
        }

        public void setIs_template(String is_template) {
            this.is_template = is_template;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getUtime() {
            return utime;
        }

        public void setUtime(String utime) {
            this.utime = utime;
        }

        public List<TravelInfoBean> getTravel_info() {
            return travel_info;
        }

        public void setTravel_info(List<TravelInfoBean> travel_info) {
            this.travel_info = travel_info;
        }

        public static class TravelInfoBean {
            /**
             * cityId : 1
             * guide_type : 3
             * g_uid : 10
             * play_days : 3
             * travel_preference : aa
             * remarks : 备注
             */

            private String cityId;
            private int guide_type;
            private int g_uid;
            private String play_days;
            private String travel_preference;
            private String remarks;

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public int getGuide_type() {
                return guide_type;
            }

            public void setGuide_type(int guide_type) {
                this.guide_type = guide_type;
            }

            public int getG_uid() {
                return g_uid;
            }

            public void setG_uid(int g_uid) {
                this.g_uid = g_uid;
            }

            public String getPlay_days() {
                return play_days;
            }

            public void setPlay_days(String play_days) {
                this.play_days = play_days;
            }

            public String getTravel_preference() {
                return travel_preference;
            }

            public void setTravel_preference(String travel_preference) {
                this.travel_preference = travel_preference;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }
        }
    }
}

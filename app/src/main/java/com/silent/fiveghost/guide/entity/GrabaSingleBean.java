package com.silent.fiveghost.guide.entity;

import java.util.List;

/**
 * 编程就像做爱，你得为一个错误提供一辈子的支持。
 * Created by lenovo on 2018/2/23.
 */

public class GrabaSingleBean {
    /**
     * errcode : 1
     * errmsg : ok
     * data : {"items":[{"grad_id":null,"tid":"148","order_id":"2018022361690235","travel_preference":"aa","number":"10","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","order_type":"一站式","start_time":"2018-01-07 00:00:00","end_time":"2018-01-17 00:00:00","city":"云南"},{"grad_id":null,"tid":"149","order_id":"2018022361697716","travel_preference":"aa","number":"10","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","order_type":"一站式","start_time":"2018-01-07 00:00:00","end_time":"2018-01-17 00:00:00","city":"云南"}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":2}}
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

    @Override
    public String toString() {
        return "GrabaSingleBean{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * items : [{"grad_id":null,"tid":"148","order_id":"2018022361690235","travel_preference":"aa","number":"10","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","order_type":"一站式","start_time":"2018-01-07 00:00:00","end_time":"2018-01-17 00:00:00","city":"云南"},{"grad_id":null,"tid":"149","order_id":"2018022361697716","travel_preference":"aa","number":"10","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","order_type":"一站式","start_time":"2018-01-07 00:00:00","end_time":"2018-01-17 00:00:00","city":"云南"}]
         * pager : {"page":1,"page_count":1,"per_page":20,"total_count":2}
         */

        private PagerBean pager;
        private List<ItemsBean> items;

        public PagerBean getPager() {
            return pager;
        }

        public void setPager(PagerBean pager) {
            this.pager = pager;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "pager=" + pager +
                    ", items=" + items +
                    '}';
        }

        public static class PagerBean {
            @Override
            public String toString() {
                return "PagerBean{" +
                        "page=" + page +
                        ", page_count=" + page_count +
                        ", per_page=" + per_page +
                        ", total_count=" + total_count +
                        '}';
            }

            /**
             * page : 1
             * page_count : 1
             * per_page : 20
             * total_count : 2
             */

            private int page;
            private int page_count;
            private int per_page;
            private int total_count;

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getPage_count() {
                return page_count;
            }

            public void setPage_count(int page_count) {
                this.page_count = page_count;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getTotal_count() {
                return total_count;
            }

            public void setTotal_count(int total_count) {
                this.total_count = total_count;
            }
        }

        public static class ItemsBean {
            /**
             * grad_id : null
             * tid : 148
             * order_id : 2018022361690235
             * travel_preference : aa
             * number : 10
             * img : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png
             * order_type : 一站式
             * start_time : 2018-01-07 00:00:00
             * end_time : 2018-01-17 00:00:00
             * city : 云南
             */

            private Object grad_id;
            private String tid;
            private String order_id;
            private String travel_preference;
            private String number;
            private String img;
            private String order_type;
            private String start_time;
            private String end_time;
            private String city;

            public Object getGrad_id() {
                return grad_id;
            }

            public void setGrad_id(Object grad_id) {
                this.grad_id = grad_id;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getTravel_preference() {
                return travel_preference;
            }

            public void setTravel_preference(String travel_preference) {
                this.travel_preference = travel_preference;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getOrder_type() {
                return order_type;
            }

            public void setOrder_type(String order_type) {
                this.order_type = order_type;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            @Override
            public String toString() {
                return "ItemsBean{" +
                        "grad_id=" + grad_id +
                        ", tid='" + tid + '\'' +
                        ", order_id='" + order_id + '\'' +
                        ", travel_preference='" + travel_preference + '\'' +
                        ", number='" + number + '\'' +
                        ", img='" + img + '\'' +
                        ", order_type='" + order_type + '\'' +
                        ", start_time='" + start_time + '\'' +
                        ", end_time='" + end_time + '\'' +
                        ", city='" + city + '\'' +
                        '}';
            }
        }
    }
}

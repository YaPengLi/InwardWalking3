package com.silent.fiveghost.guide.entity;

import java.util.List;

/**
 * Created by 农民伯伯 on 2018/2/23.
 */

public class RouteTemolateEntity {

    /**
     * errcode : 1
     * errmsg : ok
     * data : {"items":[{"id":"98","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"旅行测试-20180202"},{"id":"99","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"旅行测试-20180202"}],"pager":{"page":1,"page_count":1,"per_page":20,"total_count":2}}
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
        /**
         * items : [{"id":"98","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"旅行测试-20180202"},{"id":"99","img":"https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png","name":"旅行测试-20180202"}]
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

        public static class PagerBean {
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
             * id : 98
             * img : https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png
             * name : 旅行测试-20180202
             */

            private String id;
            private String img;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}

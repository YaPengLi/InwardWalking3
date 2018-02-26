package com.silent.fiveghost.guide.entity;

/**
 * Created by 农民伯伯 on 2018/1/30.
 */

public class LoginEntity
{

    /**
     * errcode : 1
     * errmsg : ok
     * data : {"user":{"id":22,"username":"游客账号","email":"","access_token":"_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-","expired_at":1547388663,"avatar":"http://120.79.137.110:81/api/assets/d41e6fe5/avatar_200x200.png","category":2,"login_at":null,"parent_id":0}}
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
         * user : {"id":22,"username":"游客账号","email":"","access_token":"_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-","expired_at":1547388663,"avatar":"http://120.79.137.110:81/api/assets/d41e6fe5/avatar_200x200.png","category":2,"login_at":null,"parent_id":0}
         */

        private UserBean user;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * id : 22
             * username : 游客账号
             * email :
             * access_token : _za8e8fMg-ueDPbvVeZCBDWrFCrabPa-
             * expired_at : 1547388663
             * avatar : http://120.79.137.110:81/api/assets/d41e6fe5/avatar_200x200.png
             * category : 2
             * login_at : null
             * parent_id : 0
             */

            private int id;
            private String username;
            private String email;
            private String access_token;
            private int expired_at;
            private String avatar;
            private int category;
            private Object login_at;
            private int parent_id;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getAccess_token() {
                return access_token;
            }

            public void setAccess_token(String access_token) {
                this.access_token = access_token;
            }

            public int getExpired_at() {
                return expired_at;
            }

            public void setExpired_at(int expired_at) {
                this.expired_at = expired_at;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getCategory() {
                return category;
            }

            public void setCategory(int category) {
                this.category = category;
            }

            public Object getLogin_at() {
                return login_at;
            }

            public void setLogin_at(Object login_at) {
                this.login_at = login_at;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }
        }
    }
}

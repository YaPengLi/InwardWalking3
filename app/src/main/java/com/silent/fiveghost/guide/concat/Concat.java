package com.silent.fiveghost.guide.concat;

/**
 * Created by 84682 on 2018/1/28.
 */

public interface Concat {
    //BASE_URL
    String BASE_URL ="";



    //通用验证码接口
    String GERYZM_URL="http://120.79.137.110:83/api/v1/sms/send";

    //注册
    String SIGNUP="http://120.79.137.110:83/api/v1/auth/signup";

    //登录接口
    String LOGIN_URL="http://120.79.137.110:83/api/v1/auth/login";

    //找回密码
    String AUTH_RESET_PASSWORD="http://120.79.137.110:83/api/v1/auth/reset-password";

    //用户基本信息接口
    String USERINFO="http://120.79.137.110:83/api/v1/user/info";

    String  FILE_NAME="user";

    //用户图片上传接口
    String IMAGE_UP= "http://120.79.137.110/api/v1/user/image-upload";

    //导游线路列表接口
    String GUIDE_LINE_LIST_INTERFACE="http://120.79.137.110:83/api/v1/route/guide-route-list?access_token="+Concat.ACCESS_TOKEN;
    //路线详情
    String DETAILS_OF_THE_ROUTE= "http://120.79.137.110:83/api/v1/route/route-info?rid=95&access_token="+Concat.ACCESS_TOKEN+"&"+"rid=";

    //导游线路模板列表接口
    String  LINE_TEMPLATE_LIST_INTERFACE= "http://120.79.137.110:83/api/v1/route/guide-route-template-list?access_token="+Concat.ACCESS_TOKEN;
    //token
    String ACCESS_TOKEN = "c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk";
    //抢单列表接口
    String GRABA_SINGLE_LIST="http://120.79.137.110:83/api/v1/order/grab-order-list?access_token=c4lXtk9MXpcX5_7Ud4GMSfT_8M4ulJpk";

}

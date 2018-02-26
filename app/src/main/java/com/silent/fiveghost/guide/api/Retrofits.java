package com.silent.fiveghost.guide.api;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @author 农民伯伯
 * @version 2017/10/31
 *          Retrofit进行网络请求的接口
 */
public interface Retrofits {
    @GET
    Observable<ResponseBody> doGet(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> doPost(@Url String path, @FieldMap Map<String, String> mMap);

    @Multipart
    @POST
    Observable<ResponseBody> updateAvatar (@Url String path,@Query("access_token") String access_token, @Part("uploadFile\"; filename=\"test.jpg\"") RequestBody imgs );

}

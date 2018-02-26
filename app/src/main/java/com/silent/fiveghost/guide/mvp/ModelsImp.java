package com.silent.fiveghost.guide.mvp;

import android.content.Context;

import com.silent.fiveghost.guide.http.HttpCallback;
import com.silent.fiveghost.guide.http.factorys.HttpConCreate;
import com.silent.fiveghost.guide.http.factorys.HttpFactorys;
import com.silent.fiveghost.guide.http.products.HttpRequest;
import com.silent.fiveghost.guide.http.products.RetrofitRequest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;


/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public class ModelsImp implements Models {


    @Override
    public void getRequest(Context context, String url, HttpCallback callback) {
        HttpFactorys factorys = new HttpConCreate();
        HttpRequest request = factorys.conCreate(context, RetrofitRequest.class);
        Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) (genericInterfaces[0])).getActualTypeArguments();
        Type type1 = actualTypeArguments[0];



//       Type type = new TypeToken<TestEntity>(){}.getType();
        request.doGet(context, url, type1, callback);

    }

    @Override
    public void postRequest(Context context, String url, HttpCallback callback, Map<String, String> mParams) {

        HttpFactorys factorys = new HttpConCreate();
        HttpRequest request = factorys.conCreate(context, RetrofitRequest.class);
        Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) (genericInterfaces[0])).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        request.doPost(context, url, type, mParams, callback);

    }

    @Override
    public void upLoadFile(Context context,String url, String access_token, String filename, HttpCallback callback) {
        HttpFactorys factorys = new HttpConCreate();
        HttpRequest request = factorys.conCreate(context, RetrofitRequest.class);
        Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) (genericInterfaces[0])).getActualTypeArguments();
        Type types = actualTypeArguments[0];
        request.uploadFile( url, access_token, filename, types,callback);
    }

}

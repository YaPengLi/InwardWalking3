package com.silent.fiveghost.guide.http.products;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.silent.fiveghost.guide.api.Retrofits;
import com.silent.fiveghost.guide.http.HttpCallback;
import com.silent.fiveghost.guide.http.RetrofitTools;
import com.silent.fiveghost.guide.http.factorys.HttpConCreate;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * @author 农民伯伯
 * @version 2017/10/31
 *          抽象工厂中的具体产品
 */

public class RetrofitRequest<T> implements HttpRequest<T> {

    @Override
    public void doGet(Context context, String path, final Type type, final HttpCallback<T> callback) {
        Retrofits retrofits = RetrofitTools.getInstance().create(Retrofits.class);
        Observable<ResponseBody> doGet = retrofits.doGet(path);
        doGet.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);

                            Gson gson = new Gson();
                            T t = gson.fromJson(string, type);
                            callback.success(t);

                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void doPost(Context context, String url, final Type type, Map<String, String> mParams, final HttpCallback<T> callback) {
        Retrofits retrofits = RetrofitTools.getInstance().create(Retrofits.class);
        Observable<ResponseBody> post = retrofits.doPost(url, mParams);
        post.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);
                            //TODO 注意这个地方：
                            Gson gson = new Gson();
                            if(!(type==String.class)){
                                T t = gson.fromJson(string, type);
                                callback.success(t);
                                return;
                            }else {
                                callback.success((T) string);
                                return;
                            }



                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void uploadFile(String url,String access_token, String filename, final Type type, final HttpCallback<T> callback) {
        Retrofits retrofits = RetrofitTools.getInstance().create(Retrofits.class);
        final File file = new File(filename);
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        Observable<ResponseBody> post = retrofits.updateAvatar(url,access_token,requestBody);
        post.subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Log.e("TAG", string);
                            //TODO 注意这个地方：
                            Gson gson = new Gson();
                            if(!(type==String.class)){
                                T t = gson.fromJson(string, type);
                                callback.success(t);
                                return;
                            }else {
                                callback.success((T) string);
                                return;
                            }



                        } catch (IOException e) {
                            e.printStackTrace();
                            callback.failure(e);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

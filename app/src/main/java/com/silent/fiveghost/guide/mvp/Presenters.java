package com.silent.fiveghost.guide.mvp;

import android.content.Context;

import com.silent.fiveghost.guide.http.HttpCallback;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public class Presenters {
    private Iview iview;
    private Models models;
    private Context context;

    public Presenters(Context context, Iview iview) {
        this.iview = iview;
        models = new ModelsImp();
        this.context=context;
    }

    public void requestNews(String url) {
        models.getRequest(context, url, iview);
    }
    public void requestNews(String url, Map<String,String> mParams) {
        models.postRequest(context,url,iview,mParams);
    }
    public void requestNews(Context context,String url, String access_token, String filename, final HttpCallback callback) {
        models.upLoadFile(context,url,access_token,filename,callback);
    }
}

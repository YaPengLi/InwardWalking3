package com.silent.fiveghost.guide.http.factorys;

import android.content.Context;

import com.silent.fiveghost.guide.http.products.HttpRequest;


/**
 * @author 农民伯伯
 * @version 2017/11/1
 *          抽象工厂中的抽象工厂
 */

public interface HttpFactorys {
    public <T extends HttpRequest> HttpRequest conCreate(Context context, Class<T> clz);


}

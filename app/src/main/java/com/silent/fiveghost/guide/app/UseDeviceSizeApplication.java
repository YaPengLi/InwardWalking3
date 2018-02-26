package com.silent.fiveghost.guide.app;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by 84682 on 2018/1/28.
 */

public class UseDeviceSizeApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}

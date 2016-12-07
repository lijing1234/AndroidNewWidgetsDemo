/*
 *
 *  *
 *  *  *
 *  *  *  * ===================================
 *  *  *  * Copyright (c) 2016.
 *  *  *  * 作者：安卓猴
 *  *  *  * 微博：@安卓猴
 *  *  *  * 博客：http://sunjiajia.com
 *  *  *  * Github：https://github.com/opengit
 *  *  *  *
 *  *  *  * 注意**：如果您使用或者修改该代码，请务必保留此版权信息。
 *  *  *  * ===================================
 *  *  *
 *  *  *
 *  *
 *
 */

package com.sunjiajia.androidnewwidgetsdemo.application;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;

public class MyApplication extends Application {


    private static MyApplication mApplication;
    public static Context ctx;
    String Ip;


    @Override
    public void onCreate() {
        mApplication = this;
        super.onCreate();
        ctx = this;
        /*配置bugly*/
        Context context = getApplicationContext();
        // 获取当前包名
        String packageName = context.getPackageName();


        //初始化
        OkGo.init(this);

        try {
            //全局参数设置
            OkGo.getInstance()
                    //打开调试开关
                    .debug("jtmarket", Level.INFO, true)
                    //如果使用默认的 60秒
                    .setConnectTimeout(10000)
                    .setReadTimeOut(10000)
                    .setWriteTimeOut(10000)
                    .setRetryCount(1)
                    //可以全局统一设置缓存模式,默认是不使用缓存
                    .setCacheMode(CacheMode.NO_CACHE)
                    //可以全局统一设置缓存时间,默认永不过期
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    //单例
    public static synchronized MyApplication getInstance() {
        return mApplication;
    }


}

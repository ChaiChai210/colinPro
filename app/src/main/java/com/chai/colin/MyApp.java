package com.chai.colin;

import android.app.Application;

import com.chai.colin.util.ToastUtil;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.init(this);
    }
}

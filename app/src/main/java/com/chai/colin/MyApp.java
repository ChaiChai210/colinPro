package com.chai.colin;

import android.app.Application;
import android.content.Context;

import com.chai.colin.util.SPUtils;
import com.chai.colin.util.SoundPoolUtil;
import com.chai.colin.util.ToastUtil;

public class MyApp extends Application {
    private static final String TAG = "MyAppcation";
    private static MyApp mInstance;
    boolean accountBalance;
//    private List<Activity> activities = new ArrayList();
    private int appCount;
    double balance;
    private long exitTime = 0L;
    private boolean isRunInBackground;
    String token;

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.init(this);
        mInstance = this;

        SoundPoolUtil.getInstance(this);
//        MediaPlayUtil.getInstance(this);

        SPUtils.getInstance().init(this);

    }

    public static Context getContext() {
        return mInstance;
    }

    public static MyApp getInstance() {
        return mInstance;
    }

    public boolean getAccountBalance() {
        return this.accountBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getToken() {
        return this.token;
    }


    public void setAccountBalance(boolean paramBoolean) {
        this.accountBalance = paramBoolean;
    }

    public void setBalance(double paramDouble) {
        this.balance = paramDouble;
    }

    public void setToken(String paramString) {
        this.token = paramString;
    }

}

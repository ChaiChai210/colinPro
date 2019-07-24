package com.chai.colin.util;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

public class ToastUtil {

    private Context mContext; // 上下文对象

    private ToastUtil(){} // 私有化构造

    private static final class Helper {
        static final ToastUtil INSTANCE = new ToastUtil();
    }

    public static ToastUtil getInstance() { // 获取单例对象
        return Helper.INSTANCE;
    }

    public static void init(@NonNull Context context){ // 初始化Context
        getInstance().mContext = context;
    }

    public void showToast(@StringRes int strResID) { // 根据资源id弹Toast
        if (mContext == null) {
            throw new RuntimeException("Please init the Context before showToast");
        }
        showToast(mContext.getResources().getText(strResID));
    }

    public void showToast(CharSequence str) { // 根据字符串弹Toast
        if (mContext == null) {
            throw new RuntimeException("Please init the Context before showToast");
        }
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
    }
}

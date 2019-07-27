package com.chai.colin.wxapi;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chai.colin.util.UrlHelper;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

public class WXEntryActivity
        extends AppCompatActivity
        implements IWXAPIEventHandler {
    private static final String TAG = "WXEntryActivity";
    private IWXAPI api;

    protected void onCreate(@Nullable Bundle paramBundle) {
        super.onCreate(paramBundle);
        regToWx();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.e("WXEntryActivity", "onDestroy: ");
    }

    protected void onPause() {
        super.onPause();
        Log.e("WXEntryActivity", "onPause: ");
    }


    @Override
    public void onResp(BaseResp baseResp) {
        int i = baseResp.errCode;
        String str;
        if (i != -4) {
            if (i != -2) {
                if (i != 0) {
                    str = "发送失败";
                } else {
                    str = "分享成功";
                }
            } else {
                str = "取消分享";
            }
        } else {
            str = "分享被拒绝";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onResp: result==");
        localStringBuilder.append(str);
        localStringBuilder.append(" code: ");
        localStringBuilder.append(baseResp.errCode);
        Log.d("vxreq", localStringBuilder.toString());
        EventBus.getDefault().post("wxShareComplete");
        finish();
    }


    protected void onResume() {
        super.onResume();
        Log.e("WXEntryActivity", "onResume: ");
    }

    public void regToWx() {
        this.api = WXAPIFactory.createWXAPI(this, UrlHelper.APP_ID, true);
        this.api.registerApp(UrlHelper.APP_ID);
        this.api.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq baseReq) {
        if (baseReq != null) {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" base: ");
            localStringBuilder.append(baseReq.openId);
            Log.d("vxreq", localStringBuilder.toString());
        }

    }
}


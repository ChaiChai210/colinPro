package com.chai.colin;

import android.widget.FrameLayout;

import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebviewGameActivity extends BaseActivity {
    private X5WebView mWebView;
    FrameLayout fl_game_webview;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_webview_game;
    }

    @Override
    protected void initView() {
        mWebView = new X5WebView(this, null);
        fl_game_webview = findViewById(R.id.fl_game_webview);
        fl_game_webview.addView(mWebView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
//         this.mWebView.loadUrl(getIntent().getStringExtra());
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().sync();
//        ((AQuery)this.c.id(2131230785)).clicked(this);
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString) {
//                if (TextUtils.equals(paramString, UrlHelper.BAIDU_URL)) {
//                    Log.e("chai", "shouldInterceptRequest: 百度返回，不跳转");
//                    finish();
//                    return true;
//                }
                paramWebView.loadUrl(paramString);
                return true;
            }
        });
    }
}

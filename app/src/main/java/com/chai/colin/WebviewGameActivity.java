package com.chai.colin;

import android.content.pm.ActivityInfo;
import android.view.View;
import android.widget.FrameLayout;

import com.chai.colin.util.MediaPlayUtil;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.Utils;
import com.chai.colin.widget.DragButton;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class WebviewGameActivity extends BaseActivity {
    private X5WebView mWebView;
    FrameLayout fl_game_webview;
    private DragButton dragButton;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_webview_game;
    }

    @Override
    protected void initView() {
//        Intent intent = getIntent();
//        if(intent != null){
//            String kindId = intent.getStringExtra("webUrl");
//        }
        mWebView = new X5WebView(this, null);
        fl_game_webview = findViewById(R.id.fl_game_webview);
        fl_game_webview.addView(mWebView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        String id = getIntent().getStringExtra("webUrl");
        String url = "http://www.zhmember.f9186.com:8080/zh-member-web/api/game/play?account=zhangsan&liveCode=ky&KindID=" + id;
        mWebView.loadUrl(url);
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

        dragButton = findViewById(R.id.btn_home);
        dragButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showBackDialog();
                ToastUtil.getInstance().showToast("dddd");
            }
        });
    }

//    private void showBackDialog()
//    {
//        if (this.f == null)
//        {
//            this.f = new Dialog(this, 2131558575);
//            this.f.setContentView(2131361851);
//            ((Window) Objects.requireNonNull(this.f.getWindow())).setFlags(1024, 1024);
//            Object localObject = ((Window)Objects.requireNonNull(this.f.getWindow())).getAttributes();
//            ((WindowManager.LayoutParams)localObject).gravity = 17;
//            ((WindowManager.LayoutParams)localObject).width = -1;
//            ((WindowManager.LayoutParams)localObject).height = -1;
//            localObject = (ImageButton)this.f.findViewById(2131230774);
//            ((TextView)this.f.findViewById(2131231409)).setText("返回游戏大厅");
//            ((ImageButton)localObject).setOnClickListener(new View.OnClickListener()
//            {
//                public void onClick(View paramView)
//                {
//                    WebviewGameActivity.this.f.dismiss();
//                }
//            });
//            ((ImageButton)this.f.findViewById(2131230771)).setOnClickListener(new View.OnClickListener()
//            {
//                public void onClick(View paramView)
//                {
//                    WebviewGameActivity.this.f.dismiss();
//                }
//            });
//            ((ImageButton)this.f.findViewById(2131230822)).setOnClickListener(new View.OnClickListener()
//            {
//                public void onClick(View paramView)
//                {
//                    WebviewGameActivity.this.f.dismiss();
//                    EventBus.getDefault().postSticky(new RefreshVipInfo());
//                    WebviewGameActivity.this.finish();
//                }
//            });
//        }
//        this.f.show();
//    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.destroy();
        }
        MediaPlayUtil.resume();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int i;
        if(Utils.isScreenAutoRotate(this) != 1){
            i = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }else {
            i = ActivityInfo.SCREEN_ORIENTATION_USER;
        }
        setRequestedOrientation(i);
    }
}

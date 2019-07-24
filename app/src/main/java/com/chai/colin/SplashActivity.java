package com.chai.colin;


import android.content.Intent;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        gotoMainActivity();

    }

    private void gotoMainActivity() {
//        ARouter.getInstance().build("/user/LoginActivity").navigation();
        this.startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}

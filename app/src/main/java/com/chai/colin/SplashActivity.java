package com.chai.colin;


import android.content.Intent;

import com.chai.colin.util.MediaPlayUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    private void playBgMusic() {
        //開啓後要銷毀
        MediaPlayUtil.playSound(R.raw.music_game, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        playBgMusic();
        gotoMainActivity();

    }

    private void gotoMainActivity() {
//        ARouter.getInstance().build("/user/LoginActivity").navigation();
        this.startActivity(new Intent(this, MainActivity.class));
        finish();
    }


}

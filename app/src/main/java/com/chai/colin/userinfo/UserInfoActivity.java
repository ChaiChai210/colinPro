package com.chai.colin.userinfo;

import android.os.Debug;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;

public class UserInfoActivity
        extends BaseActivity
        implements View.OnClickListener {
    private ImageView img_back_bg;
    private ImageView img_title;


    private RadioButton btn_grxx;
    private RadioButton btn_tzjl;
    private RadioButton btn_zhmx;
    private RadioButton btn_grbb;
    private RadioButton btn_vipxq;
    UserInfoFragment userInfoFrg = new UserInfoFragment();
    UserBetFragment betFrg = new UserBetFragment();
    UserAccountFragment accoutFrg = new UserAccountFragment();
    UserReportFragment reportFrg = new UserReportFragment();
    UserVipFragment vipFrg = new UserVipFragment();
    private Fragment currentFragment = userInfoFrg;

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                break;
            case R.id.img_back_bg:
                finish();
                break;
            case R.id.btn_grxx:
                switchFragment(userInfoFrg);
                break;
            case R.id.btn_tzjl:
                switchFragment(betFrg);
                break;
            case R.id.btn_zhmx:
                switchFragment(accoutFrg);
                break;
            case R.id.btn_grbb:
                switchFragment(reportFrg);
                break;
            case R.id.btn_vipxq:
                switchFragment(vipFrg);
                break;
        }
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView() {
        playMusic(9, volume);
        //加载loading界面。
        img_back_bg = findViewById(R.id.img_back_bg);
        img_title = findViewById(R.id.img_title);
        img_title.setImageResource(R.drawable.ic_recharge_title);

        btn_grxx = findViewById(R.id.btn_grxx);
        btn_tzjl = findViewById(R.id.btn_tzjl);
        btn_zhmx = findViewById(R.id.btn_zhmx);
        btn_grbb = findViewById(R.id.btn_grbb);
        btn_vipxq = findViewById(R.id.btn_vipxq);
        initListener();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_user_info, userInfoFrg).commit();
    }

    private void initListener() {
        Debug.startMethodTracing();
        img_back_bg.setOnClickListener(this);
        btn_grxx.setOnClickListener(this);
        btn_tzjl.setOnClickListener(this);
        btn_zhmx.setOnClickListener(this);
        btn_grbb.setOnClickListener(this);
        btn_vipxq.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic(9);
    }
    private void switchFragment(Fragment targetFragment) {
        if (currentFragment == targetFragment) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction
                    .hide(currentFragment)
                    .add(R.id.fl_user_info, targetFragment)
                    .commit();
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment)
                    .commit();
        }
        currentFragment = targetFragment;
    }
}



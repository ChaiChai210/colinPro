package com.chai.colin.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.aquery.AQuery;
import com.chai.colin.BaseActivity;
import com.chai.colin.R;
import com.chai.colin.fragment.WDBankFragment;
import com.chai.colin.fragment.WDBlanceFragment;
import com.chai.colin.fragment.WDCardFragment;

public class WithDrawActivity
        extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "CustomerServiceActivity";
    WDBankFragment bankFragment = new WDBankFragment();
    WDBlanceFragment e = new WDBlanceFragment();
    WDCardFragment f = new WDCardFragment();
    AQuery aq;

    RadioButton btn_to_bank;

    private Fragment currentFragment = bankFragment;
//    protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {
//        EventBus.getDefault().post(new CustomerEvent(paramInt1, paramIntent));
//    }

    public void onClick(View paramView) {
        switch (paramView.getId()) {
            default:
                break;
            case R.id.img_back_bg:
                finish();
                break;
            case R.id.btn_to_bank:
//                getSupportFragmentManager().beginTransaction().hide(this.c).hide(this.bankFragment).hide(this.e).show(this.f).commitAllowingStateLoss();
                switchFragment(bankFragment);
                break;
            case R.id.btn_blance:
                switchFragment(e);
                break;
            case R.id.btn_card:
                switchFragment(f);
                break;
        }
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_withdraw;
    }

    @Override
    protected void initView() {
//        playMusic(7, volume);
        //加载loading界面。
        aq = new AQuery(this);
        btn_to_bank = findViewById(R.id.btn_to_bank);
        //頭部客服
//        aq.id(R.id.img_title).image(R.drawable.ic_withdraw_title);
        initListener();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_wd_contain, e).commit();
    }

    private void initListener() {
        aq.id(R.id.img_back_bg).click(this);
        btn_to_bank.setOnClickListener(this);
//        btn_to_bank.performClick();

        aq.id(R.id.btn_blance).click(this);
        aq.id(R.id.btn_card).click(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic(7);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            EventBus.getDefault().post(new RefreshBalanceEvent());
            finish();
        }
        return true;
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
                    .add(R.id.fl_wd_contain, targetFragment)
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
package com.chai.colin.activity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;
import com.chai.colin.fragment.WDBankFragment;
import com.chai.colin.fragment.WDBlanceFragment;
import com.chai.colin.fragment.WDCardFragment;

public class NewExtensionActivity
        extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "NewExtensionActivity";
    WDBankFragment bankFragment = new WDBankFragment();
    WDBlanceFragment e = new WDBlanceFragment();
    WDCardFragment f = new WDCardFragment();

    private RadioButton ib_mypromotion;
    private RadioButton ib_memeber;
    private RadioButton ib_performance;
    private RadioButton ib_instruction;
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
            case R.id.ib_mypromotion:
//                getSupportFragmentManager().beginTransaction().hide(this.c).hide(this.bankFragment).hide(this.e).show(this.f).commitAllowingStateLoss();
                switchFragment(bankFragment);
                break;
            case R.id.ib_memeber:
                switchFragment(e);
                break;
            case R.id.ib_performance:
                switchFragment(f);
                break;
            case R.id.ib_instruction:
                switchFragment(f);
                break;
        }
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_new_extension;
    }

    @Override
    protected void initView() {
//        playMusic(3, volume);
        //加载loading界面。

        ib_mypromotion = findViewById(R.id.ib_mypromotion);
        ib_memeber = findViewById(R.id.ib_memeber);
        ib_performance = findViewById(R.id.ib_performance);
        ib_instruction = findViewById(R.id.ib_instruction);
//        //頭部客服
        initListener();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_containner, bankFragment).commitAllowingStateLoss();
    }

    private void initListener() {

        findViewById(R.id.img_back_bg).setOnClickListener(this);

        ib_mypromotion.setOnClickListener(this);
        ib_mypromotion.performClick();
        ib_memeber.setOnClickListener(this);
        ib_performance.setOnClickListener(this);
        ib_instruction.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic(3);
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
                    .add(R.id.fl_containner, targetFragment)
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
package com.chai.colin.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;

import com.aquery.AQuery;
import com.chai.colin.BaseActivity;
import com.chai.colin.MyApp;
import com.chai.colin.R;
import com.chai.colin.util.Utils;

public class RechargeActivity
        extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "CustomerServiceActivity";
    //    OnlineFragment c = new OnlineFragment();
//    QqFragment d = new QqFragment();
//    VxFragment e = new VxFragment();
//    FqcFragment f = new FqcFragment();
    AQuery aq;

    private ImageButton btnRefresh;

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
            case R.id.btn_recharge_jilu:
                //todo 获取充值历史
                break;
            case R.id.btn_refresh:
                refreshBalance();
                break;
            case R.id.btn_vx:
                break;
            case R.id.btn_fqc:
                break;
        }
    }

    private void refreshBalance() {
        Animation localAnimation = AnimationUtils.loadAnimation(this, R.anim.button_fresh_rotate);
        localAnimation.setInterpolator(new LinearInterpolator());
        btnRefresh.clearAnimation();
        btnRefresh.startAnimation(localAnimation);
        aq.id(R.id.tv_golden_account).text("刷新中...");
//        this.f.refreshBalance();

    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recharge;
    }

    @Override
    protected void initView() {
//        playMusic(13, volume);
        //加载loading界面。
        aq = new AQuery(this);
        aq.id(R.id.img_title).image(R.drawable.ic_recharge_title);
        aq.id(R.id.tv_golden_account).text(Utils.double2Decimal(MyApp.getInstance().getBalance()));
        btnRefresh = findViewById(R.id.btn_refresh);
        initListener();
    }

    private void initListener() {

        aq.id(R.id.img_back_bg).click(this);
        aq.id(R.id.btn_recharge_jilu).click(this);
        btnRefresh.setOnClickListener(this);
    }

//    protected void onPause() {
//        super.onPause();
//        stopMusic(12);
//    }
}



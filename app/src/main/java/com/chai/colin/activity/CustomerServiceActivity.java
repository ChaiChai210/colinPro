package com.chai.colin.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;
import com.chai.colin.fragment.QqFragment;

public class CustomerServiceActivity
        extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "CustomerServiceActivity";
    //    OnlineFragment c = new OnlineFragment();
    QqFragment d = new QqFragment();
    //    VxFragment e = new VxFragment();
//    FqcFragment f = new FqcFragment();
    private ImageView img_back_bg;
    private ImageView img_title;
    RadioButton btn_online;
    RadioButton btn_qq;
    RadioButton btn_vx;
    RadioButton btn_fqc;

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
            case R.id.btn_online:
//                getSupportFragmentManager().beginTransaction().hide(this.c).hide(this.d).hide(this.e).show(this.f).commitAllowingStateLoss();
                break;
            case R.id.btn_qq:
                break;
            case R.id.btn_vx:
                break;
            case R.id.btn_fqc:
                break;
        }
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_customer;
    }

    @Override
    protected void initView() {
        playMusic(12, volume);
        //加载loading界面。
        btn_online = findViewById(R.id.btn_online);
        //頭部客服
        img_back_bg = findViewById(R.id.img_back_bg);
        img_title = findViewById(R.id.img_title);
        img_title.setImageResource(R.drawable.ic_cus_title);

        btn_qq = findViewById(R.id.btn_qq);
        btn_vx = findViewById(R.id.btn_vx);
        btn_fqc = findViewById(R.id.btn_fqc);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_wd_contain, d).commit();
        initListener();
    }

    private void initListener() {
        btn_online.setOnClickListener(this);
        btn_online.performClick();

        img_back_bg.setOnClickListener(this);
        btn_qq.setOnClickListener(this);
        btn_vx.setOnClickListener(this);
        btn_fqc.setOnClickListener(this);


//    protected void onPause() {
//        super.onPause();
//        stopMusic(12);
//    }
    }
}



package com.chai.colin;

import android.view.View;
import android.widget.RadioButton;

import com.aquery.AQuery;

public class CustomerServiceActivity
        extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "CustomerServiceActivity";
    //    OnlineFragment c = new OnlineFragment();
//    QqFragment d = new QqFragment();
//    VxFragment e = new VxFragment();
//    FqcFragment f = new FqcFragment();
    AQuery aq;

    RadioButton btn_online;


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
//        playMusic(12, volume);
        //加载loading界面。
        aq = new AQuery(this);
        btn_online = findViewById(R.id.btn_online);
        //頭部客服
        aq.id(R.id.img_title).image(R.drawable.ic_cus_title);
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.fl_wd_contain, c).commit();
        initListener();
    }

    private void initListener() {
        btn_online.setOnClickListener(this);
        btn_online.performClick();

        aq.id(R.id.img_back_bg).click(this);
        aq.id(R.id.btn_qq).click(this);
        aq.id(R.id.btn_vx).click(this);
        aq.id(R.id.btn_fqc).click(this);
    }

//    protected void onPause() {
//        super.onPause();
//        stopMusic(12);
//    }
}



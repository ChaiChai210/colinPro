package com.chai.colin.recharge;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.BaseActivity;
import com.chai.colin.MyApp;
import com.chai.colin.R;
import com.chai.colin.util.Utils;
import com.chai.colin.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

/**
 * 充值界面
 */
public class RechargeActivity
        extends BaseActivity
        implements View.OnClickListener {
    private static final String TAG = "CustomerServiceActivity";
    //    OnlineFragment c = new OnlineFragment();
//    QqFragment d = new QqFragment();
//    VxFragment e = new VxFragment();
//    FqcFragment f = new FqcFragment();

    private ImageButton btnRefresh;
    private ImageView img_back_bg;
    private ImageView img_title;
    private TextView tv_golden_account;
    private ImageButton btn_recharge_jilu;
    //    protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {
//        EventBus.getDefault().post(new CustomerEvent(paramInt1, paramIntent));
//    }
    private LeftMenuAdapter leftMenuAdapter;
    private LeftMenuBean leftMenuBean;
    private List<LeftMenuBean> leftMenuBeans = new ArrayList<>();
    private List list;
    private RecyclerView mRecyclerView;

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
        tv_golden_account.setText("刷新中...");
//        this.f.refreshBalance();

    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recharge;
    }

    @Override
    protected void initView() {
        playMusic(13, volume);
        //加载loading界面。
        img_back_bg = findViewById(R.id.img_back_bg);
        img_title = findViewById(R.id.img_title);
        img_title.setImageResource(R.drawable.ic_recharge_title);

        tv_golden_account = findViewById(R.id.tv_golden_account);
        tv_golden_account.setText(Utils.double2Decimal(MyApp.getInstance().getBalance()));
        btn_recharge_jilu = findViewById(R.id.btn_recharge_jilu);
        btnRefresh = findViewById(R.id.btn_refresh);
        mRecyclerView = findViewById(R.id.leftRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(this, 1));
        leftMenuAdapter = new LeftMenuAdapter(leftMenuBeans);
        mRecyclerView.setAdapter(leftMenuAdapter);
        initListener();
    }

    private void initListener() {
        img_back_bg.setOnClickListener(this);
        btn_recharge_jilu.setOnClickListener(this);
        btnRefresh.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic(13);
    }

}



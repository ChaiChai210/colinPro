package com.chai.colin;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aquery.AQuery;
import com.chai.colin.CustomerService.CustomerServiceActivity;
import com.chai.colin.Withdraw.WithDrawActivity;
import com.chai.colin.activity.HuoDongActivity;
import com.chai.colin.activity.XimaActivity;
import com.chai.colin.adapter.CategoryGameAdapter;
import com.chai.colin.adapter.RightGameAdapter;
import com.chai.colin.dialog.SafePwdDialog;
import com.chai.colin.dialog.SettingDialog;
import com.chai.colin.entity.CategoryBean;
import com.chai.colin.entity.GameList;
import com.chai.colin.login.LoginDialog;
import com.chai.colin.promotion.NewExtensionActivity;
import com.chai.colin.recharge.RechargeActivity;
import com.chai.colin.userinfo.UserInfoActivity;
import com.chai.colin.util.SoundPoolUtil;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.UrlHelper;
import com.chai.colin.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private boolean accountBalance = false;
    private AQuery aq;

    private RecyclerView mLeftRecycler;
    private List<CategoryBean> categoryBeans = new ArrayList<>();
    private CategoryGameAdapter categoryGameAdapter;
    private RecyclerView mRightRecycler;
    private List<GameList> contentList = new ArrayList();
    private RightGameAdapter mRightGameAdapter;

    private int clickPos = 0;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        aq = new AQuery(this);
        aq.id(R.id.btn_login).click(this);
        aq.id(R.id.btn_customer).click(this);
        aq.id(R.id.btn_setting).click(this);
        aq.id(R.id.btn_register).click(this);
        aq.id(R.id.btn_copy).click(this);
        aq.id(R.id.btn_activity).click(this);
        aq.id(R.id.btn_withdrawal).click(this);
        aq.id(R.id.btn_recharge).click(this);
        aq.id(R.id.btn_promotion).click(this);
        aq.id(R.id.btn_shuffle).click(this);
        aq.id(R.id.btn_safe_box).click(this);
        playMusic(5, volume);
//        showLoading();
        initLeftMenu();
        initRightContent(1);
    }

    private void initRightContent(int clickPos) {
        mRightRecycler = findViewById(R.id.recyclerViewContent);
        mRightRecycler.setLayoutManager(getLayoutManager(clickPos));
        initRightContentData(clickPos);
        mRightGameAdapter = new RightGameAdapter(contentList, clickPos);
        mRightRecycler.setAdapter(mRightGameAdapter);
        mRightGameAdapter.setOnItemClickListener((adapter, view, position) -> {
//            IntentUtil.startActivity(MainActivity.this,WebviewGameActivity.class);
            Intent intent = new Intent(MainActivity.this,WebviewGameActivity.class);
            intent.putExtra("webUrl","220");
            MainActivity.this.startActivity(intent);
        });
    }

    private void initRightContentData(int clickPos) {
        contentList.clear();
        contentList.add(new GameList("https://0.rc.xiniu.com/g2/M00/44/D3/CgAGfFox62CAW8mTAASuu22SB0U246.png"));
        contentList.add(new GameList("http://online.sccnn.com/icon/818/fresh_2_0004.png"));
        contentList.add(new GameList("https://0.rc.xiniu.com/g2/M00/44/D3/CgAGfFox62CAW8mTAASuu22SB0U246.png"));
        contentList.add(new GameList("https://0.rc.xiniu.com/g2/M00/44/D3/CgAGfFox62CAW8mTAASuu22SB0U246.png"));
        contentList.add(new GameList("https://0.rc.xiniu.com/g2/M00/44/D3/CgAGfFox62CAW8mTAASuu22SB0U246.png"));
        contentList.add(new GameList("https://0.rc.xiniu.com/g2/M00/44/D3/CgAGfFox62CAW8mTAASuu22SB0U246.png"));
    }

    private RecyclerView.LayoutManager getLayoutManager(int pos) {

        if (pos == 0) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    if (position == 0) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            });
            return gridLayoutManager;
        } else if (pos == 1) {
            return new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        }
        return new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
    }

    private void initLeftMenu() {
        mLeftRecycler = findViewById(R.id.recyclerViewLeft);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mLeftRecycler.setLayoutManager(linearLayoutManager);
        initLeftMenuData();
        categoryGameAdapter = new CategoryGameAdapter(categoryBeans);
        categoryGameAdapter.setOnItemClickListener((adapter, view, position) -> {
            int size = categoryBeans.size();
            if (!(Boolean) view.getTag()) {
                for (int i = 0; i < size; i++) {
                    if (i == position) {
                        categoryBeans.get(i).setSelected(true);
                    } else {
                        categoryBeans.get(i).setSelected(false);
                    }
                }
                adapter.notifyDataSetChanged();
                initRightContent(position);
            }
        });
        mLeftRecycler.setAdapter(categoryGameAdapter);

    }

    private void initLeftMenuData() {
        categoryBeans.clear();
        categoryBeans.add(new CategoryBean("1", true, true));
        categoryBeans.add(new CategoryBean("2", true, false));
        categoryBeans.add(new CategoryBean("3", true, false));
        categoryBeans.add(new CategoryBean("4", true, false));
        categoryBeans.add(new CategoryBean("5", true, false));
        categoryBeans.add(new CategoryBean("6", true, false));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SoundPoolUtil.stop(SoundPoolUtil.mStreamId);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        hideLoading();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
//                LoginDialog fm1 = LoginDialog.newInstance("", "");
//                fm1.show(getSupportFragmentManager(), "login");
//                showLoginDialog();
                showFragment(LoginDialog.newInstance("", ""));
                break;
            case R.id.btn_register:
//                RegisterDialog registerDialog =  new RegisterDialog();
//                registerDialog.setRegisterLiner(new RegisterDialog.onRegisterSuccess() {
//                    @Override
//                    public void onRegisterSuccess(String account, String pwd) {
//
//                    }
//                });
//                showFragment(registerDialog);
                if (clickGapFilter()) {
                    startActivity(new Intent(this, UserInfoActivity.class));
                }

//                RegisterDialog fm3 = new RegisterDialog();
//                fm3.show(getSupportFragmentManager(), "register");
                break;
            case R.id.btn_setting:
//                showSettingDialog();
                SettingDialog fm2 = new SettingDialog();
                fm2.show(getSupportFragmentManager(), "setting");
                break;
            case R.id.btn_customer:
                startActivity(new Intent(this, CustomerServiceActivity.class));
                break;
            case R.id.btn_activity:
                startActivity(new Intent(this, HuoDongActivity.class));
                break;
            case R.id.btn_withdrawal:
                startActivity(new Intent(this, WithDrawActivity.class));
                break;
            case R.id.btn_recharge:
                startActivity(new Intent(this, RechargeActivity.class));
//                if (accountBalance) {
//                    startActivity(new Intent(this, RechargeActivity.class));
//                }

                break;
            case R.id.btn_promotion:
                if (clickGapFilter()) {
                    startActivity(new Intent(this, NewExtensionActivity.class));
                }


//                if (accountBalance) {
//                    startActivity(new Intent(this, RechargeActivity.class));
//                }


                break;
            case R.id.btn_shuffle:
                startActivity(new Intent(this, XimaActivity.class));
//                if (accountBalance) {
//                    startActivity(new Intent(this, XimaActivity.class));
//                }
                break;
            case R.id.btn_copy:
                Utils.copyToClipboard(this.mContext, UrlHelper.OFFICIAL_URL);
                ToastUtil.getInstance().showToast("复制成功");
                break;
            case R.id.btn_safe_box:
//                  if (paramInt == 901) {
//      showPwdDialog();
//    } else if (paramInt == 902) {
//      showPwdInputDialog();
                showFragment(SafePwdDialog.newInstance());
                break;
        }
    }


}

package com.chai.colin;

import android.content.Intent;
import android.view.View;

import com.aquery.AQuery;
import com.chai.colin.dialog.LoginDialog;
import com.chai.colin.dialog.RegisterDialog;
import com.chai.colin.dialog.SettingDialog;
import com.chai.colin.util.SoundPoolUtil;
import com.chai.colin.util.ToastUtil;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private boolean accountBalance = false;
    private AQuery aq;

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
        playMusic(5, volume);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SoundPoolUtil.stop(SoundPoolUtil.mStreamId);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                LoginDialog fm1 = LoginDialog.newInstance("", "");
                fm1.show(getSupportFragmentManager(), "login");
//                showLoginDialog();

                break;
            case R.id.btn_register:
                RegisterDialog fm3 = new RegisterDialog();
                fm3.show(getSupportFragmentManager(), "register");
                break;
            case R.id.btn_setting:
//                showSettingDialog();
                SettingDialog fm2 = new SettingDialog();
                fm2.show(getSupportFragmentManager(), "setting");
                break;
            case R.id.btn_customer:
                startActivity(new Intent(this, CustomerServiceActivity.class));
                break;
            case R.id.btn_shuffle:
                if (accountBalance) {
                    startActivity(new Intent(this, XimaActivity.class));
                }
                break;
            case R.id.btn_copy:
//                Utils.copyToClipboard(this.mContext, UrlHelper.OFFICIAL_URL);
                ToastUtil.getInstance().showToast("复制成功");
                break;
        }
    }


}

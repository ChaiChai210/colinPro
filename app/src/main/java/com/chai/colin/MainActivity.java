package com.chai.colin;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.aquery.AQuery;
import com.chai.colin.dialog.LoginDialog;
import com.chai.colin.dialog.RegisterDialog;
import com.chai.colin.dialog.SettingDialog;
import com.chai.colin.util.SPUtils;
import com.chai.colin.util.SoundPoolUtil;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.Utils;
import com.chai.colin.widget.CustomDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    CustomDialog loginDialog;
    EditText et_account;
    CustomDialog registerDialog;

    private boolean accountBalance = false;
    AQuery aq;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        aq = new AQuery(this);
        aq.id(R.id.btn_login).click(this);
        aq.id(R.id.btn_customer).click(this::onClick);
        aq.id(R.id.btn_setting).click(this::onClick);
        aq.id(R.id.btn_register).click(this::onClick);
        aq.id(R.id.btn_copy).click(this::onClick);
        playMusic(5, volume);
//        btn_login = findViewById(R.id.btn_login);
//        btn_login.setOnClickListener(this);
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

    private void showLoginDialog() {
        if (loginDialog == null) {
            loginDialog = new CustomDialog(this, R.style.MobileDialog);
            loginDialog.setContentView(R.layout.dialog_login);
            dialogSet(loginDialog);
            loginDialog.findViewById(R.id.btn_close).setOnClickListener(view -> loginDialog.dismiss()
            );
            loginClickEvent(loginDialog);
        } else {
            EditText editText = loginDialog.findViewById(R.id.et_pwd);
            editText.setText("");
        }

        if (!loginDialog.isShowing())
            loginDialog.show();
    }

    private void dialogSet(Dialog dialog) {
        Window win = dialog.getWindow();
        if (win != null) {
            android.view.WindowManager.LayoutParams layoutparams = win.getAttributes();
            layoutparams.gravity = 17;
            layoutparams.width = -1;
            layoutparams.height = -2;
            win.getDecorView().setPadding(0, 0, 0, 0);
            win.setAttributes(layoutparams);
        }
    }

    private void loginClickEvent(final Dialog dialog) {
        et_account = (EditText) dialog.findViewById(R.id.et_account);
        final EditText et_pwd = (EditText) dialog.findViewById(R.id.et_pwd);
        final CheckBox checkbox = (CheckBox) dialog.findViewById(R.id.cb_account);
        TextView textview = (TextView) dialog.findViewById(R.id.tv_forget_pwd);
        TextView textview1 = (TextView) dialog.findViewById(R.id.tv_go_register);
        ImageButton imagebutton = (ImageButton) dialog.findViewById(R.id.btn_login);
//        final String account = SPUtils.getInstance().getUserAccount();
//        if (!TextUtils.isEmpty(account)) {
//            et_account.setText(account);
//            et_account.setSelection(et_account.getText().length());
//        }
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
//                UIHelper.goCustomerServiceActivity(MainActivity.this);
            }
        });

        textview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
//               registerDialog.(MainActivity.this).registerEnter();
            }
        });
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    String accountStr = et_account.getText().toString().trim();
                    String pwd = et_pwd.getText().toString().trim();
                    SPUtils.getInstance().setAccount(accountStr);
                    SPUtils.getInstance().setPwd(pwd);
                } else {
                    SPUtils.getInstance().setAccount("");
                    SPUtils.getInstance().setPwd("");
                }
            }
        });
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_account.getText().toString().trim();
                String password = et_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(str)) {
//                    UIHelper.errorToastString("请输入您的账号");
                    return;
                }
                if (!Utils.isAccount(str)) {
//                    UIHelper.errorToastString("您输入的账号有误");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
//                    UIHelper.errorToastString("请输入您的密码");
                    return;
                }
                if (!Utils.isPwd(password)) {
//                    UIHelper.errorToastString("您输入的密码有误");
                    return;
                }
                if (checkbox.isChecked()) {
                    SPUtils.getInstance().setAccount(str);
                    SPUtils.getInstance().setPwd(password);
                }
                //todo 登录逻辑
//                view = ApiMapUtils.loginMap(view, Utils.pwdMD5(password), VersionHelper.instance().getPackageName(), Utils.appMD5(view.toLowerCase()));
//                MainActivity.e(MainActivity.this).login(view);
            }
        });

    }

}

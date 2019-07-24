package com.chai.colin.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.chai.colin.R;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.Utils;
import com.chai.colin.widget.CheckView;

public class RegisterDialog extends DialogFragment {
//    public static RegisterDialog newInstance(String account, String password) {
//        RegisterDialog frag = new RegisterDialog();
//        Bundle args = new Bundle();
//        args.putString("account", account);
//        args.putString("password", password);
//        frag.setArguments(args);
//        return frag;
//    }

    private TextView accountReg;
    private TextView aphoneReg;
    private ImageView ivAccount;
    private ImageView ivPhone;
    private LinearLayout llaccountRegister;
    private LinearLayout llphoneRegister;
    private LinearLayout ll_verify1;
    private LinearLayout ll_verify2;
    private CheckView mCheckView;

    private boolean isPageOne = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_register, container);
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.btn_close).setOnClickListener(view1 -> dismiss()
        );

        accountReg = view.findViewById(R.id.tv_user_bg);
        aphoneReg = view.findViewById(R.id.tv_phone_bg);
        ivAccount = view.findViewById(R.id.iv_user_bg);
        ivPhone = view.findViewById(R.id.iv_phone_bg);
        llaccountRegister = view.findViewById(R.id.ll_account);
        llphoneRegister = view.findViewById(R.id.ll_phone);
        ll_verify1 = view.findViewById(R.id.ll_verify1);
        ll_verify2 = view.findViewById(R.id.ll_verify2);

        mCheckView = view.findViewById(R.id.checkView);
        final EditText et_account = view.findViewById(R.id.et_account);
        final EditText et_phone_num = view.findViewById(R.id.et_phone_second);
        final EditText pwd = view.findViewById(R.id.et_pwd);
        final EditText pwd_again = view.findViewById(R.id.et_pwd_again);
        final EditText et_verify_code = view.findViewById(R.id.et_verify_code);
        final EditText et_phone_verify = view.findViewById(R.id.et_phone_verify);
        ImageButton imagebutton = view.findViewById(R.id.btn_register_user);

        accountReg.setOnClickListener(view12 -> {
            isPageOne = true;
            ivAccount.setVisibility(View.VISIBLE);
            ivPhone.setVisibility(View.GONE);
            accountReg.setTextColor(getResources().getColor(R.color.pc_dark_yellow));
            aphoneReg.setTextColor(getResources().getColor(R.color.white_color));
            llaccountRegister.setVisibility(View.VISIBLE);
            llphoneRegister.setVisibility(View.GONE);
            ll_verify1.setVisibility(View.VISIBLE);
            ll_verify2.setVisibility(View.GONE);
        });

        aphoneReg.setOnClickListener(view13 -> {
            ivAccount.setVisibility(View.GONE);
            ivPhone.setVisibility(View.VISIBLE);
            accountReg.setTextColor(getResources().getColor(R.color.white_color));
            aphoneReg.setTextColor(getResources().getColor(R.color.pc_dark_yellow));
            isPageOne = false;
            llaccountRegister.setVisibility(View.GONE);
            llphoneRegister.setVisibility(View.VISIBLE);
            ll_verify1.setVisibility(View.GONE);
            ll_verify2.setVisibility(View.VISIBLE);
        });
        imagebutton.setOnClickListener(view14 -> {
            String password = pwd.getText().toString().trim();
            String rePassword = pwd_again.getText().toString().trim();

            if (TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)) {
                ToastUtil.getInstance().showToast("请输入您的密码");
                return;
            }
            if (!Utils.isPwd(password) || !Utils.isPwd(rePassword)) {
                ToastUtil.getInstance().showToast("您输入的密码有误");
                return;
            }

            if (!password.equals(rePassword)) {
                ToastUtil.getInstance().showToast("俩次密码不一样");
                return;
            }
            if (isPageOne) {
                String account = et_account.getText().toString().trim();
                if (TextUtils.isEmpty(account)) {
                    ToastUtil.getInstance().showToast("请输入您的账号");
                    return;
                }
                if (!Utils.isAccount(account)) {
                    ToastUtil.getInstance().showToast("您输入的账号有误");
                    return;
                }
                String verifyCode = et_verify_code.getText().toString().trim();
                if (TextUtils.isEmpty(verifyCode)) {
                    ToastUtil.getInstance().showToast("请输入您的验证码");
                    return;
                }
                if (!verifyCode.equals(mCheckView.getCheckCode())) {
                    ToastUtil.getInstance().showToast("验证码不对！");
                    return;
                }
                //todo 注册逻辑
            } else {
                String phoneNum = et_phone_num.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
                    ToastUtil.getInstance().showToast("请输入您的手机号");
                    return;
                }
                if (!Utils.isPhone(phoneNum)) {
                    ToastUtil.getInstance().showToast("您输入的手机有误");
                    return;
                }
                String verifyCode = et_phone_verify.getText().toString().trim();
                if (TextUtils.isEmpty(verifyCode)) {
                    ToastUtil.getInstance().showToast("请输入您的验证码");
                    return;
                }
                //todo 注册逻辑
            }


        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MobileDialog);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.height = -2;
        attributes.width = -1;
        getDialog().getWindow().setAttributes(attributes);
    }


}

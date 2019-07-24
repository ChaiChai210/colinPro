package com.chai.colin.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chai.colin.R;
import com.chai.colin.util.SPUtils;
import com.chai.colin.util.Utils;

public class LoginDialog extends BaseDialogFragment {
    public static LoginDialog newInstance(String account, String password) {
        LoginDialog frag = new LoginDialog();
        Bundle args = new Bundle();
        args.putString("account", account);
        args.putString("password", password);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String account = getArguments().getString("account");
        String password = getArguments().getString("password");
        View view = inflater.inflate(R.layout.dialog_login, container);
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.btn_close).setOnClickListener(view1 -> dismiss()
        );

        final EditText et_account = view.findViewById(R.id.et_account);
        final EditText et_pwd = view.findViewById(R.id.et_pwd);
        final CheckBox checkbox = view.findViewById(R.id.cb_account);
        TextView textview = view.findViewById(R.id.tv_forget_pwd);
        TextView textview1 = view.findViewById(R.id.tv_go_register);
        ImageButton imagebutton = view.findViewById(R.id.btn_login);
        textview.setOnClickListener(view12 -> {
            dismiss();
//                UIHelper.goCustomerServiceActivity(MainActivity.this);
        });

        textview1.setOnClickListener(view13 -> {
            dismiss();
            mContext.showFragment(new RegisterDialog());
//               registerDialog.(MainActivity.this).registerEnter();
        });
        imagebutton.setOnClickListener(view14 -> {
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
        });
    }


}

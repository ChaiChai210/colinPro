package com.chai.colin.userinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chai.colin.R;

public class UserAccountFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_account, container, false);
        initView(view);
        initData();
        initLisner();
        return view;
    }

    private void initData() {
    }


    private void initLisner() {
    }

    private void initView(View view) {
//        View loading  = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
//        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
//        this.loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
//        tv_leftAmount = view.findViewById(R.id.tv_leftAmount);
//        tv_leftAmount.setText(Utils.double2Decimal(MyApp.getInstance().getBalance()));
//        ed_input_money = view.findViewById(R.id.ed_input_money);
//        Utils.setEditTextHintSize(this.ed_input_money, "请输入您的提现金额", 10);
//        ib_clear = view.findViewById(R.id.ib_clear);
//        ib_bind_bank = view.findViewById(R.id.ib_bind_bank);
//        tv_tixiam_history = view.findViewById(R.id.tv_tixiam_history);
//        ib_ok = view.findViewById(R.id.ib_ok);
//        rl_unbind = view.findViewById(R.id.rl_unbind);
//        rl_bind = view.findViewById(R.id.rl_bind);
    }
}

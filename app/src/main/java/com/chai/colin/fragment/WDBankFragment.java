package com.chai.colin.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chai.colin.MyApp;
import com.chai.colin.R;
import com.chai.colin.entity.BankCardResult;
import com.chai.colin.entity.WithdrawalRange;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.Utils;
import com.chai.colin.widget.LoadingDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WDBankFragment extends Fragment {
    private static final String TAG = "WDBankFragment";
//    private DrawHistoryAdapter adapter;
    int minNum = 0;
    int maxNum = 0;
//    private BankAdapter bankAdapter;
    private int bankPostion = -1;
    private int bankcardId = -1;
    Dialog d;
    private List<BankCardResult> dataBeans = new ArrayList();
    Dialog e;
    private EditText ed_input_money;
    Dialog f;
//    private List<DrawingHistoryData> historyDataList = new ArrayList();
    private BankCardResult itemData;
    private Context mContext;
    private int pageNum = 1;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    private int totalPage;
    private ImageButton ib_clear;
    private TextView tv_tixiam_history;
    private ImageButton ib_ok;
    private ImageButton ib_bind_bank;
    private RelativeLayout rl_bind;
    private RelativeLayout rl_unbind;
    private TextView tv_leftAmount;
    private LoadingDialog loadingDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wd_bank, container, false);
        initView(view);
        initData();
        initLisner();
        return view;
    }

    private void initData() {
        getRange();
        getBankCardList();
    }

    private void getBankCardList() {
        if (dataBeans.isEmpty()) {
            rl_bind.setVisibility(View.GONE);
            rl_unbind.setVisibility(View.VISIBLE);
        }else {
            rl_bind.setVisibility(View.VISIBLE);
            rl_unbind.setVisibility(View.GONE);
        }
    }

    private void getRange() {
        //todo 请求
        WithdrawalRange range = null;
        if (null != range) {
            minNum = range.getMinWithdraw();
            maxNum = range.getMaxWithdraw();
        }
        String paramWithdrawalRange;
        if (maxNum == 0) {
            paramWithdrawalRange = String.format("请输入您的提现金额 单笔最低%1$s", new Object[]{Integer.valueOf(minNum)});
        } else {
            paramWithdrawalRange = String.format("请输入您的提现金额 单笔最低%1$s 最高%2$d", new Object[]{Integer.valueOf(minNum), Integer.valueOf(maxNum)});
        }
        Utils.setEditTextHintSize(this.ed_input_money, paramWithdrawalRange, 10);
    }

    private void initLisner() {
        ib_clear.setOnClickListener(view1 -> ed_input_money.getText().clear());
        tv_tixiam_history.setOnClickListener(view -> {
            //todo 查看体现记录
        });
        ib_ok.setOnClickListener(view -> {
            String str = ed_input_money.getText().toString().trim();
//            if (WDBankFragment.f(WDBankFragment.this) == -1) {
//                ToastUtil.getInstance().showToast("请绑定银行卡！");
//                return;
//            }
            if (TextUtils.isEmpty(str)) {
                ToastUtil.getInstance().showToast("请输入提现金额！");
                return;
            }
            double d2 = Double.parseDouble(str);
            double d1 = MyApp.getInstance().getBalance();
            if (d2 > d1) {
                ToastUtil.getInstance().showToast("账户余额不足！");
                return;
            }
            if (d2 < minNum) {
                ToastUtil.getInstance().showToast(String.format("提现金额必须大于%s元！", new Object[]{Integer.valueOf(minNum)}));
                return;
            }
            if (d2 > maxNum) {
                ToastUtil.getInstance().showToast(String.format("提现金额必须小于%s元！", new Object[]{Integer.valueOf(maxNum)}));
                return;
            }
            if (d1 - d2 < 1.0D) {
                ToastUtil.getInstance().showToast("提现时余额至少必须留1元");
                return;
            }
            ed_input_money.getText().clear();
            //todo 提现
//            paramAnonymousView = new HashMap();
//            paramAnonymousView.put("bankcardId", Integer.valueOf(WDBankFragment.f(WDBankFragment.this)));
//            paramAnonymousView.put("withdrawAmount", str);
//            WDBankFragment.c(WDBankFragment.this).loginOutGame(MyApp.getInstance().getToken(), paramAnonymousView);
        });
    }

    private void initView(View view) {
//        View loading  = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
//        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
//        this.loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
        tv_leftAmount = view.findViewById(R.id.tv_leftAmount);
        tv_leftAmount.setText(Utils.double2Decimal(MyApp.getInstance().getBalance()));
        ed_input_money = view.findViewById(R.id.ed_input_money);
        Utils.setEditTextHintSize(this.ed_input_money, "请输入您的提现金额", 10);
        ib_clear = view.findViewById(R.id.ib_clear);
        ib_bind_bank = view.findViewById(R.id.ib_bind_bank);
        tv_tixiam_history = view.findViewById(R.id.tv_tixiam_history);
        ib_ok = view.findViewById(R.id.ib_ok);
        rl_unbind = view.findViewById(R.id.rl_unbind);
        rl_bind = view.findViewById(R.id.rl_bind);
    }
}

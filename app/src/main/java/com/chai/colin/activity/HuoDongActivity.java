package com.chai.colin.activity;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;
import com.chai.colin.adapter.ActAdapter;
import com.chai.colin.entity.ActionItemData;
import com.chai.colin.widget.MultipleStatusView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//showRedOpen()弹出领红包界面
public class HuoDongActivity extends BaseActivity {
    private static final String TAG = "HuoDongActivity";
    private ActAdapter actAdapter;
    private List<Boolean> booleanList = new ArrayList();
    private RadioButton btnZonghe;
    //    private List<BankCardResult> cardList = new ArrayList();
    private boolean currentClick = true;
    private List<ActionItemData> dataList = new ArrayList<>();
    private Context mContext = this;
    private int marketingType;
    private int plaformId;
    private MultipleStatusView multipleStatusView;
    private Map<String, Integer> paramas;
    private RecyclerView recyclerView;

    private RadioGroup rg_huodong;

    private MultipleStatusView defaultView;
//    private void isCountBind() {
//        final CustomDialog localCustomDialog = new CustomDialog(this, 2131558575);
//        localCustomDialog.setContentView(2131361844);
//        ((Window) Objects.requireNonNull(localCustomDialog.getWindow())).setFlags(1024, 1024);
//        Object localObject = ((Window) Objects.requireNonNull(localCustomDialog.getWindow())).getAttributes();
//        ((WindowManager.LayoutParams) localObject).gravity = 17;
//        ((WindowManager.LayoutParams) localObject).width = -1;
//        ((WindowManager.LayoutParams) localObject).height = -1;
//        localObject = (ImageView) localCustomDialog.findViewById(2131230786);
//        ImageView localImageView = (ImageView) localCustomDialog.findViewById(2131230787);
//        ((ImageView) localObject).setOnClickListener(new OnClickListener() {
//            public void onClick(View paramAnonymousView) {
//                localCustomDialog.dismiss();
//            }
//        });
//        localImageView.setOnClickListener(new OnClickListener() {
//            public void onClick(View paramAnonymousView) {
//                paramAnonymousView = new Intent(HuoDongActivity.this, WithDrawActivity.class);
//                paramAnonymousView.putExtra("type", "huodong");
//                HuoDongActivity.this.startActivity(paramAnonymousView);
//                localCustomDialog.dismiss();
//            }
//        });
//        dialogSet(localCustomDialog);
//        if (!localCustomDialog.isShowing()) {
//            localCustomDialog.show();
//        }
//    }


//    public void expireToken() {
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void getActionBankCard(ActionEvent paramActionEvent) {
//        paramActionEvent = MyAppcation.getInstance().getToken();
//        if (!TextUtils.isEmpty(paramActionEvent)) {
//            this.actionPresenter.getBankCard(paramActionEvent);
//        }
//    }
//
//
//    public void getBankCard(List<BankCardResult> paramList) {
//        this.cardList.clear();
//        this.cardList.addAll(paramList);
//        if ((paramList != null) && (paramList.size() > 0)) {
//            SPUtils.getInstance().setBankUserName(((BankCardResult) paramList.get(0)).getUserBankName());
//            getHuoDongData(this.marketingType, this.plaformId);
//        } else {
//            isCountBind();
//        }
//    }


    public void hideProgress() {
    }


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_huo_dong;
    }

    @Override
    protected void initView() {
//        playMusic(2, volume);
        defaultView = findViewById(R.id.multipleStatusView_default);
        ImageView imageView = findViewById(R.id.img_back_bg);
        imageView.setOnClickListener(v -> finish());
        rg_huodong = findViewById(R.id.rg_huodong);
        rg_huodong.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.btn_zonghe:
                    getActivityList(2, 1);
                    break;
                case R.id.btn_qipai:
                    getActivityList(1, 2);
                    break;
                case R.id.btn_buyu:
                    getActivityList(1, 2);
                    break;
                case R.id.btn_dianzi:
                    getActivityList(1, 2);
                    break;
                case R.id.btn_shixun:
                    getActivityList(1, 2);
                    break;
                case R.id.btn_sports:
                    getActivityList(1, 2);
                    break;

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
//        this.recyclerView.addItemDecoration(new RecycleViewDivider(this.mContext, 1, 20, 2131034153));
        actAdapter = new ActAdapter(R.layout.item_activity, dataList);
        if (dataList.isEmpty()) {
        }
        recyclerView.setAdapter(actAdapter);
    }

    protected void onPause() {
        super.onPause();
        stopMusic(2);
    }

    protected void onResume() {
        super.onResume();
    }

    public void showProgress() {
    }

    private List<ActionItemData> getActivityList(int marketingType, int plaformId) {
        return null;
    }
}




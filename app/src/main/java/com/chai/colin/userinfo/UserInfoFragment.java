package com.chai.colin.userinfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class UserInfoFragment extends Fragment implements View.OnClickListener {

    public static final int MONTH = 2;
    private static final String TAG = "UserInfoFragment";
    public static final int WEEK = 1;
    SimpleDateFormat A = new SimpleDateFormat("MM-dd", Locale.getDefault());
    SimpleDateFormat B = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    Map<String, Object> C = new HashMap();
    String[] D = {"男", "女"};

    boolean flag = true;
    private int pos;
    private Map<String, Integer> headIcons = new HashMap<>();
    private Map<String, Integer> nextIcons = new HashMap<>();
    private List<String> nextIndex = new ArrayList<>();
    private Map<String, Integer> upperIcons = new HashMap<>();
    private List<String> upperIndex = new ArrayList<>();

    private UserInfoActivity activity;

    private ImageView iv_head_vip;
    private TextView tv_level;
    private ImageView iv_level_start;
    private ImageView iv_level_end;

    private ImageView iv_up_vip;
    private ImageView iv_next_vip;
    private TextView tv_vip_title;

    private TextView tv_edit_base;
    private TextView tv_edit_contact;

    private RecyclerView recyclerView;
    private RightsAdapter rightsAdapter;
    private List<RightsBean> rightsBeanList = new ArrayList<>();

    private EditText ed_edit_mail;
    private EditText ed_edit_qq;
    private EditText ed_edit_phone;
    private EditText ed_edit_wechat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_info, container, false);
        initView(view);
        loadIcons();
        initData();
        initLisner();
        return view;
    }

    private void initData() {
    }


    private void initLisner() {
        iv_up_vip.setOnClickListener(this);
        iv_next_vip.setOnClickListener(this);
        tv_edit_base.setOnClickListener(this);
        tv_edit_contact.setOnClickListener(this);
    }

    private void initView(View view) {
//        View loading  = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
//        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
//        this.loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
        iv_head_vip = view.findViewById(R.id.iv_head_vip);
        tv_level = view.findViewById(R.id.tv_level);
        iv_level_start = view.findViewById(R.id.iv_level_start);
        iv_level_end = view.findViewById(R.id.iv_level_end);

        iv_up_vip = view.findViewById(R.id.iv_up_vip);
        iv_next_vip = view.findViewById(R.id.iv_next_vip);
        tv_edit_base = view.findViewById(R.id.tv_edit_base);
        tv_edit_contact = view.findViewById(R.id.tv_edit_contact);

        this.recyclerView = view.findViewById(R.id.recyclerView);
        rightsAdapter = new RightsAdapter(rightsBeanList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAdapter(this.rightsAdapter);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);


    }


    private void loadIcons() {
        int i2;
        for (int i = 1; i <= 10; i++) {
            int i3 = getResources().getIdentifier("ic_pc_vip" + i, "drawable", activity.getPackageName());
            i2 = getResources().getIdentifier("ic_up_vip" + i, "drawable", activity.getPackageName());
            this.headIcons.put("VIP" + i, i3);
            this.upperIndex.add("VIP" + i);
            this.upperIcons.put("VIP" + i, i2);
        }
        for (int j = 2; j <= 10; j++) {
            i2 = getResources().getIdentifier("ic_next_vip" + j, "drawable", activity.getPackageName());
            this.nextIcons.put("VIP" + j, i2);
//            this.nextIndex.add("VIP" + i);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (UserInfoActivity) context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_up_vip:
                break;
            case R.id.iv_next_vip:
                break;
            case R.id.tv_edit_base:
                break;
            case R.id.tv_edit_contact:
                break;
        }
    }


    public void getVipLevelInfo(VIPLevelInfoBean vipLeverInfo) {
        if (vipLeverInfo != null) {
            rightsBeanList.clear();
            VIPLevelInfoBean.SalaryStatusBean localSalaryStatusBean = vipLeverInfo.getSalaryStatus();
            if (localSalaryStatusBean != null) {
                List<VIPLevelInfoBean.GoldListBean> goldList = vipLeverInfo.getGoldList();
                Iterator<VIPLevelInfoBean.LevelListBean> levelListBeanIterator = vipLeverInfo.getLevelList().iterator();
                while (levelListBeanIterator.hasNext()) {
                    VIPLevelInfoBean.LevelListBean localLevelListBean = levelListBeanIterator.next();
                    RightsBean localRightsBean = new RightsBean();
                    localRightsBean.setMonthAmount(localLevelListBean.getMonthAmount());
                    localRightsBean.setPromotionGold(localLevelListBean.getPromotionGold());
                    localRightsBean.setWeekAmount(localLevelListBean.getWeekAmount());
                    localRightsBean.setXima((float) localLevelListBean.getXima());
                    localRightsBean.setLevelName(localLevelListBean.getLevelName());
                    for (VIPLevelInfoBean.GoldListBean localGoldListBean : goldList) {
                        if (localGoldListBean.getNewLevel().equals(localLevelListBean.getLevelName())) {
                            localRightsBean.setStatus(localGoldListBean.getStatus());
                        }
                    }
                    if (localLevelListBean.getLevelName().equals(localSalaryStatusBean.getLevelName())) {
                        localRightsBean.setWeekStatus(localSalaryStatusBean.getWeekStatus());
                        localRightsBean.setMonthStatus(localSalaryStatusBean.getMonthStatus());
                        localRightsBean.setCanXima(true);
                    }
                    this.rightsBeanList.add(localRightsBean);
                }
                flag = false;
                recyclerView.scrollToPosition(pos);
            }
        }
        rightsAdapter.notifyDataSetChanged();
    }
}

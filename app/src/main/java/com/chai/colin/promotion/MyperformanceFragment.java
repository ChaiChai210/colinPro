package com.chai.colin.promotion;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.R;
import com.chai.colin.util.DensityUtil;
import com.chai.colin.util.SPUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

public class MyperformanceFragment extends Fragment implements View.OnClickListener {
    private TextView tv_personnalmoney;
    private EditText et_id;
    private ImageView iv_search;
    private ImageView iv_reset;
    LinearLayout llPerformancehead;
    private LinearLayout ll_showformula;
    RecyclerView rvPerformancecontent;
    SmartRefreshLayout smartRefreshLayout;
    private MyPerformanceAdapter myPerformanceAdapter;
    private int pageNum = 1;
    private int pageSize = 10;
    private String id;
    private int totalPage;
    List<MyPerformanceBean.ResultBean> paramList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myperformancement, container, false);
        initView(view);
        initData();
        initLisner();
        return view;
    }

    private void initData() {
        int userId = SPUtils.getInstance().getUserId();
//        getPerfomanceData(String.valueOf(userId), pageNum, pageSize);
    }


    private void initLisner() {
        tv_personnalmoney.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        iv_reset.setOnClickListener(this);
    }

    private void initView(View view) {
        et_id = view.findViewById(R.id.et_id);
        iv_search = view.findViewById(R.id.iv_search);
        iv_reset = view.findViewById(R.id.iv_reset);

        tv_personnalmoney = view.findViewById(R.id.tv_personnalmoney);
        smartRefreshLayout = view.findViewById(R.id.smart_refresh_layout);
        rvPerformancecontent = view.findViewById(R.id.rv_performancecontent);
//        llShowformula = view.findViewById(R.id.ll_showformula);
        llPerformancehead = view.findViewById(R.id.ll_performancehead);
        initRecyclerView();
//        View loading  = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
//        loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
//        loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
//        tv_leftAmount = view.findViewById(R.id.tv_leftAmount);
//        tv_leftAmount.setText(Utils.double2Decimal(MyApp.getInstance().getBalance()));
//        ed_input_money = view.findViewById(R.id.ed_input_money);
//        Utils.setEditTextHintSize(ed_input_money, "请输入您的提现金额", 10);
//        ib_clear = view.findViewById(R.id.ib_clear);
//        ib_bind_bank = view.findViewById(R.id.ib_bind_bank);
//        tv_tixiam_history = view.findViewById(R.id.tv_tixiam_history);
//        ib_ok = view.findViewById(R.id.ib_ok);
//        rl_unbind = view.findViewById(R.id.rl_unbind);
//        rl_bind = view.findViewById(R.id.rl_bind);
    }

    private void showPerformanceResource(int i, String s) {
//        (new PerformanceResourceDialog(getActivity(), i, s)).show();
    }


    private void initRecyclerView() {

        rvPerformancecontent.setLayoutManager(new LinearLayoutManager(getActivity()));
        myPerformanceAdapter = new MyPerformanceAdapter(null);
        rvPerformancecontent.setAdapter(myPerformanceAdapter);
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(getActivity()));
        smartRefreshLayout.setRefreshHeader(new ClassicsHeader(getActivity()));
        smartRefreshLayout.setEnableRefresh(true);
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.setEnableAutoLoadMore(true);
        View localView = View.inflate(getActivity(), R.layout.view_empty, null);
        myPerformanceAdapter.setEmptyView(localView);
        myPerformanceAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            int i = paramList.get(position).getUserId();
            String batch = paramList.get(position).getBatch();
            if ((i == 0) || (TextUtils.isEmpty(batch)))
                return;
            showPerformanceResource(i, batch);
        });

        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            public void onLoadMore(@NonNull RefreshLayout paramRefreshLayout) {
                if (pageNum >= totalPage) {
                    paramRefreshLayout.finishLoadMoreWithNoMoreData();
                    return;
                }
                pageNum += 1;
//                getPerfomanceData(id, pageNum, pageSize);
                paramRefreshLayout.finishLoadMore();
            }
        });
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(@NonNull RefreshLayout paramRefreshLayout) {
                pageNum = 1;
                myPerformanceAdapter.getData().clear();
//                getPerfomanceData(id,pageNum,pageSize);
                paramRefreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_personnalmoney:
                showPop();
                break;
            case R.id.iv_reset:
                et_id.setText("");
//                paramList = myPerformanceAdapter.getData();
//                paramList.clear();
                break;
            case R.id.iv_search:
                id = et_id.getText().toString();
                if (!TextUtils.isEmpty(id)) {
//                    getPerfomanceData(id,pageNum,pageSize);
                }
                break;
        }
    }

    private void showPop() {
        PopupWindow paramView = new PopupWindow(getActivity());
        View content = View.inflate(getActivity(), R.layout.performance_formula, null);
        paramView.setContentView(content);
        paramView.setBackgroundDrawable(new ColorDrawable(0));
        paramView.setFocusable(true);
        paramView.setOutsideTouchable(false);
        int i = tv_personnalmoney.getWidth();
//        StringBuilder localStringBuilder = new StringBuilder();
//        localStringBuilder.append("结果");
//        localStringBuilder.append(DensityUtil.dip2px(getActivity(), 40.0F));
//        LogUtils.e(localStringBuilder.toString());
        int k = DensityUtil.dp2px(getActivity(), 30.0F);
        paramView.showAsDropDown(tv_personnalmoney, -i - k, -DensityUtil.dp2px(getActivity(), 5.0F));
//        PopupWindowCompat.showAsDropDown(paramView,tv_personnalmoney,-i,0, Gravity.START);
    }
}

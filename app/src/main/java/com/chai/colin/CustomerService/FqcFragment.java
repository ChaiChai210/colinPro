package com.chai.colin.CustomerService;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.R;
import com.chai.colin.widget.MultipleStatusView;
import com.chai.colin.widget.RecycleViewDivider;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class FqcFragment extends Fragment {
    private static final String TAG = "QqFragment";
    RecyclerView mRecyclerView;
    FqcAdapter mAdapter;
    List<FqcBean> mDatas = new ArrayList<>();
    private Context mContext;
    private MultipleStatusView mulstatus_view;
    private SmartRefreshLayout sm_refresh;

    private void initView(View view) {
        mulstatus_view = view.findViewById(R.id.mulstatus_view);
        sm_refresh = view.findViewById(R.id.sm_refresh);
        sm_refresh.setRefreshHeader(new ClassicsHeader(this.mContext));
        sm_refresh.setEnableLoadMore(false);
        sm_refresh.setEnableOverScrollBounce(true);
        sm_refresh.setEnableOverScrollDrag(true);
        sm_refresh.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishRefresh();
                initData();
            }
        });
        mRecyclerView = view.findViewById(R.id.fqc_rv);

        mAdapter = new FqcAdapter(R.layout.item_cus_fqc, mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, 1,
                (int) mContext.getResources().getDimension(R.dimen.dp_12), ContextCompat.getColor(mContext, R.color.transparent)));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));


    }


    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = inflater.inflate(R.layout.fragment_cus_fqc, paramViewGroup, false);
        mContext = inflater.getContext();
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        mDatas.clear();
        FqcBean kefu1 = new FqcBean();
        kefu1.setProblemName("4907455754");
        kefu1.setProblemConcent("客服专员");
        FqcBean kefu2 = new FqcBean();
        kefu2.setProblemName("4907455754");
        kefu2.setProblemConcent("客服专员");
        FqcBean kefu3 = new FqcBean();
        kefu3.setProblemName("4907455754");
        kefu3.setProblemConcent("客服专员");
        mDatas.add(kefu1);
        mDatas.add(kefu2);
        mDatas.add(kefu3);

//        if (mDatas.isEmpty()) {
//            mulstatus_view.showEmpty();
//        } else {
//
//        }
    }

}

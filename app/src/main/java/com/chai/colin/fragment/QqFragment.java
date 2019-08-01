package com.chai.colin.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.R;
import com.chai.colin.adapter.QQAdapter;
import com.chai.colin.entity.QQKefu;
import com.chai.colin.widget.RecycleViewDivider;

import java.util.ArrayList;
import java.util.List;

public class QqFragment extends Fragment {
    private static final String TAG = "QqFragment";
    RecyclerView mRecyclerView;
    QQAdapter mAdapter;
    List<QQKefu> mDatas = new ArrayList<>();
    private Context mContext;


    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.rv_cus_qq);
        mAdapter = new QQAdapter(R.layout.item_cus, mDatas);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, 0,
                (int) mContext.getResources().getDimension(R.dimen.dp_12), ContextCompat.getColor(mContext, R.color.transparent)));
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1, RecyclerView.HORIZONTAL, false));
    }


    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle) {
        View view = inflater.inflate(R.layout.fragment_cus_qq, paramViewGroup, false);
        mContext = inflater.getContext();
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        mDatas.clear();
        QQKefu kefu1 = new QQKefu();
        kefu1.setQq("4907455754");
        kefu1.setQqName("客服专员");
        kefu1.setQqTempUrl("http://static.runoob.com/images/demo/demo1.jpg");
        QQKefu kefu2 = new QQKefu();
        kefu2.setQq("4907455754");
        kefu2.setQqName("客服专员");
        kefu2.setQqTempUrl("http://static.runoob.com/images/demo/demo1.jpg");
        QQKefu kefu3 = new QQKefu();
        kefu3.setQq("4907455754");
        kefu3.setQqName("客服专员");
        kefu3.setQqTempUrl("http://static.runoob.com/images/demo/demo1.jpg");
        mDatas.add(kefu1);
        mDatas.add(kefu2);
        mDatas.add(kefu3);
    }

}

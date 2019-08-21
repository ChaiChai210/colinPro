package com.chai.colin.promotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.chai.colin.R;
import com.chai.colin.widget.MultipleStatusView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

/*
直属查询界面
 */
public class DirectlyFragment extends Fragment implements View.OnClickListener {

    private TextView tv_directly_val;
    private TextView tv_directly_flow;
    private TextView tv_directly_agent;
    private ImageView iv_chose_id;
    private ImageView iv_chose_time;
    private EditText ed_search;
    private ImageButton ib_time;
    private ImageButton iv_search;
    private ImageButton iv_reset;

    private SmartRefreshLayout smartRefreshLayout;
    private MultipleStatusView multipleStatusView;
    private RecyclerView mRecyclerView;


    private int pageNum = 1;
    private int pageSize = 10;
    private String id;
    private int totalPage;
    private String userId;
    private List<PromoteNextData> paramList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directly, container, false);
        initView(view);
        initData();
        initLisner();
        return view;
    }

    private void initData() {
    }


    private void initLisner() {
        iv_chose_id.setOnClickListener(this);
        iv_chose_time.setOnClickListener(this);
        iv_search.setOnClickListener(this);
        iv_reset.setOnClickListener(this);
    }

    private void initView(View view) {
//        View loading  = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
//        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
//        this.loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
        tv_directly_val = view.findViewById(R.id.tv_directly_val);
        tv_directly_flow = view.findViewById(R.id.tv_directly_flow);
        tv_directly_agent = view.findViewById(R.id.tv_directly_agent);

        iv_chose_id = view.findViewById(R.id.iv_chose_id);
        iv_chose_time = view.findViewById(R.id.iv_chose_time);
        ed_search = view.findViewById(R.id.ed_search);
        ib_time = view.findViewById(R.id.ib_time);
        iv_search = view.findViewById(R.id.iv_search);
        iv_reset = view.findViewById(R.id.iv_reset);

        smartRefreshLayout = view.findViewById(R.id.smart_refresh_layout);
        multipleStatusView = view.findViewById(R.id.msv_directly);
        mRecyclerView = view.findViewById(R.id.recyclerView);
//        initRecyclerView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_chose_id:
                ed_search.setEnabled(true);
                ed_search.setHint("输入直属玩家ID");
                ed_search.getText().clear();
                pageSize = 0;
                ed_search.setBackgroundResource(R.drawable.big_input_box);
                ib_time.setVisibility(View.GONE);
                iv_chose_id.setImageResource(R.drawable.ic_chosed);
                iv_chose_time.setImageResource(R.drawable.ic_unchosed);
                break;
            case R.id.iv_chose_time:
                ed_search.setEnabled(false);
                ed_search.getText().clear();
                ed_search.setHint("请选择时间");
                pageSize = 0;
                ed_search.setBackgroundResource(R.drawable.ic_pc_edit);
                ib_time.setVisibility(View.VISIBLE);
                iv_chose_time.setImageResource(R.drawable.ic_chosed);
                iv_chose_id.setImageResource(R.drawable.ic_unchosed);
                break;
            case R.id.iv_search:
                userId = "";
                if (ed_search.isEnabled())
                    userId = ed_search.getText().toString();
//                getDirectlyList(String.valueOf(userId), pageNum, pageSize);
                break;
            case R.id.iv_reset:
                ed_search.setEnabled(true);
                ed_search.setHint("输入直属玩家ID");
                ed_search.getText().clear();
                pageSize = 0;
                ed_search.setBackgroundResource(R.drawable.big_input_box);
                ib_time.setVisibility(View.GONE);
                iv_chose_id.setImageResource(R.drawable.ic_chosed);
                iv_chose_time.setImageResource(R.drawable.ic_unchosed);
                break;
        }
    }
}

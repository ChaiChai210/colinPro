package com.chai.colin.promotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chai.colin.R;

//主要逻辑：请求，设置2张图片。然后响应点击事件。弹窗
public class MyInstructionFragment extends Fragment {

    private ImageView iv_introduce_img;
    private ImageView iv_commission_bg;
    private RelativeLayout rl_commission;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myinstructionfragment, container, false);
        initView(view);
        initData();
        initLisner();
        return view;
    }

    private void initData() {
        //todo 請求2張圖片
    }


    private void initLisner() {
        rl_commission.setOnClickListener(view -> {
            //todo 弹窗
        });

    }

    private void initView(View view) {
//        View loading  = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
//        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
//        this.loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
        iv_introduce_img = view.findViewById(R.id.iv_introduce_img);
        iv_commission_bg = view.findViewById(R.id.iv_commission_bg);
        rl_commission = view.findViewById(R.id.rl_commission);

    }
}

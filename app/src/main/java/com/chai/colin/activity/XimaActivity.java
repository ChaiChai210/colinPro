package com.chai.colin.activity;

import android.widget.ImageView;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;

public class XimaActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_xima;
    }

    @Override
    protected void initView() {
        ImageView imageView = findViewById(R.id.img_back_bg);
        imageView.setOnClickListener(v -> finish());
    }
}

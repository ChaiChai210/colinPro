package com.chai.colin.CustomerService;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chai.colin.R;

import java.util.List;

public class FqcAdapter extends BaseQuickAdapter<FqcBean, BaseViewHolder> {
    //    CircleImageView circleImageView;
    ImageView circleImageView;

    public FqcAdapter(int layoutResId, @Nullable List<FqcBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FqcBean item) {

        helper.setText(R.id.tv_num, String.valueOf(helper.getAdapterPosition() + 1));
        helper.setText(R.id.tv_fqctitle, item.getProblemName());
        helper.setText(R.id.tv_fqccontent, item.getProblemConcent());
    }
}

package com.chai.colin.recharge;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chai.colin.R;

import java.util.List;

public class LeftMenuAdapter
        extends BaseQuickAdapter<LeftMenuBean, BaseViewHolder> {
    LeftMenuAdapter(@Nullable List<LeftMenuBean> paramList) {
        super(R.layout.item_left_menu, paramList);
    }

    protected void convert(BaseViewHolder vh, LeftMenuBean item) {

//        Glide.with(this.mContext).load(item.getPayTypeIcon()).into(localLeftMenuViewHolder.b);
        RelativeLayout rl_left_menu = vh.getView(R.id.rl_left_menu);
        TextView tv_name = vh.getView(R.id.tv_name);
        ImageView img_discount = vh.getView(R.id.img_discount);
        String str;
        if (item.getPayTypeId() == 6)
        {
            str = "银联充值";
        }
        else
        {
            str = item.getPayTypeName();
        }

        vh.setText(R.id.tv_name,str);
        if (item.isSelected())
        {
            rl_left_menu.setSelected(true);
            tv_name.setSelected(true);
            vh.itemView.setEnabled(false);
        }
        else
        {
            rl_left_menu.setSelected(false);
            tv_name.setSelected(false);
            vh.itemView.setEnabled(true);
        }
        if (item.getIsRecommend().equals("1"))
            img_discount.setVisibility(View.VISIBLE);
        else
            img_discount.setVisibility(View.GONE);
        item.setSelected(false);
    }
}



package com.chai.colin.adapter;

import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chai.colin.R;
import com.chai.colin.entity.CategoryBean;

import java.util.List;

public class CategoryGameAdapter
        extends BaseQuickAdapter<CategoryBean, BaseViewHolder> {
    public CategoryGameAdapter(@Nullable List<CategoryBean> paramList) {
        super(R.layout.item_game_categor, paramList);
    }

    protected void convert(BaseViewHolder vh, CategoryBean item) {
        ImageButton imageButton = vh.getView(R.id.image_button);
        String type = item.getGamingType();
        if ("1".equals(type)) {
            imageButton.setImageResource(R.drawable.hot_game_select);
        } else if ("2".equals(type)) {
            imageButton.setImageResource(R.drawable.qipai_game_select);
        } else if ("3".equals(type)) {
            imageButton.setImageResource(R.drawable.buyu_game_select);
        } else if ("4".equals(type)) {
            imageButton.setImageResource(R.drawable.dianzi_game_select);
        } else if ("5".equals(type)) {
            imageButton.setImageResource(R.drawable.girl_online_select);
        } else if ("6".equals(type)) {
            imageButton.setImageResource(R.drawable.sport_game_select);
        }

        imageButton.setSelected(item.isSelected());
        imageButton.setTag(item.isSelected());
        if (item.isOpen())
            imageButton.setVisibility(View.VISIBLE);
        else
            imageButton.setVisibility(View.GONE);
//        if (vh.getAdapterPosition() == 0) {
//            imageButton.setSelected(true);
//        }
//        imageButton.setSelected(false);
    }


}


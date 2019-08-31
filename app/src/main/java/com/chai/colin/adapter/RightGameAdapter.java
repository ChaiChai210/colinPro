package com.chai.colin.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chai.colin.R;
import com.chai.colin.entity.GameList;

import java.util.List;

public class RightGameAdapter
        extends BaseQuickAdapter<GameList, BaseViewHolder> {
    private int position;

    public RightGameAdapter(@Nullable List<GameList> paramList, int pos) {
        super(R.layout.item_girl, paramList);
        this.position = pos;
    }

    private void setRoundImage(String url, ImageView imageView) {
        Glide.with(this.mContext).load(url).dontAnimate().skipMemoryCache(true).placeholder(R.drawable.placeholder).circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
    }

    private void setNormalImage(String url, ImageView imageView) {
        Glide.with(this.mContext).load(url).dontAnimate().skipMemoryCache(true).placeholder(R.drawable.placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA).into(imageView);
    }

    protected void convert(BaseViewHolder vh, GameList item) {
        ImageView imageView = vh.getView(R.id.iv_head);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (position == 0) {
            if (vh.getLayoutPosition() == 0) {
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.width = (int) mContext.getResources().getDimension(R.dimen.dp_160);
            }
            imageView.setLayoutParams(layoutParams);
            setRoundImage(item.getUrl(), imageView);
        } else if (position == 1) {
            layoutParams.height = (int) mContext.getResources().getDimension(R.dimen.dp_163);
            layoutParams.width = (int) mContext.getResources().getDimension(R.dimen.dp_220);
            imageView.setLayoutParams(layoutParams);
            setNormalImage(item.getUrl(), imageView);
//            getRequest(item.getUrl()).into(new ImageViewTarget<Drawable>(imageView) {
//                @Override
//                protected void setResource(@Nullable Drawable resource) {
//
//                }
//            });
        }


    }


}


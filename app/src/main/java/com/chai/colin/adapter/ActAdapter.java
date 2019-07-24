package com.chai.colin.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chai.colin.R;
import com.chai.colin.entity.ActionItemData;
import com.chai.colin.util.Utils;

import java.util.List;

public class ActAdapter extends BaseQuickAdapter<ActionItemData, BaseViewHolder> {
    public ActAdapter(int layoutResId, @Nullable List<ActionItemData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ActionItemData item) {
        helper.setText(R.id.tv_act_title, item.getMarketingName());
        String dateStart = Utils.long2String(item.getCreationTime(), "yyyy-MM-dd");
        String dateEnd = Utils.long2String(item.getEndDate(), "yyyy-MM-dd");
        StringBuilder time = new StringBuilder();
        time.append(dateStart).append(" 至 ").append(dateEnd);
        helper.setText(R.id.tv_act_time, time.toString());
        String imageUrl = item.getH5Image();

        LinearLayout ll_money = helper.getView(R.id.ll_money);
        RecyclerView webview = helper.getView(R.id.rlayout_add_webview);
        //todo 加载图片
        ImageView iv = helper.getView(R.id.iv_act_img);
        ImageButton imageButton = helper.getView(R.id.ib_activity_get);
        TextView tip = helper.getView(R.id.tv_tips);
        TextView tv_money = helper.getView(R.id.tv_money);
//        Glide.with(mContext).load(str1).dontAnimate().skipMemoryCache(false).placeholder(2131165783).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
        double d = item.getObtainAmount();
        String str1 = item.getIsValid();
        String str2 = item.getRuleId();
        if (("1".equals(str1)) && (d > 0.0D)) {
//            imageButton.setImageResource(2131165341);
            ll_money.setVisibility(View.VISIBLE);
            tv_money.setText(Utils.double2Decimal(item.getObtainAmount()));
            tip.setText("可获得彩金");
            imageButton.setClickable(true);
            imageButton.setOnClickListener(v -> {
//                    ActAdapter.a(ActAdapter.this).getMoney(paramInt);
            });
        } else {
            if (TextUtils.isEmpty(str2)) {
//                imageButton.setImageResource(2131165406);
                tip.setText("该活动不支持在线领取");
                imageButton.setClickable(true);
                imageButton.setOnClickListener(v -> {
//                            UIHelper.goCustomerServiceActivity(ActAdapter.b(ActAdapter.this))
                        }
                );
            } else {
//                imageButton.setImageResource(2131165333);
                tip.setText("您暂未达到要求，达到后即可领取");
                imageButton.setClickable(false);
            }
            ll_money.setVisibility(View.GONE);
        }
        webview.removeAllViews();
//        localObject1 = new X5WebView(this.mContext, null);
//        ((X5WebView) localObject1).setBackgroundColor(this.mContext.getResources().getColor(2131034428));
//        ((X5WebView) localObject1).loadDataWithBaseURL(null, item.getMarketingDesc(), "text/html", "UTF-8", null);
        if (item.isClicked()) {
            webview.setVisibility(View.VISIBLE);
        } else {
            webview.setVisibility(View.GONE);
        }
//        webview.addView((View) localObject1, 0, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}

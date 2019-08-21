package com.chai.colin.promotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.chai.colin.R;
import com.chai.colin.entity.ShareBean;
import com.chai.colin.util.BaseCallBack;
import com.chai.colin.util.FileUtils;
import com.chai.colin.util.ImageUtils;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.UrlHelper;
import com.chai.colin.util.Utils;
import com.chai.colin.widget.LoadingDialog;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Objects;

/**
 * 我的推广
 */
public class MyPromotionFragment extends Fragment implements View.OnClickListener {
    LoadingDialog loadingDialog;
    //左半边
    private TextView tv_myid;
    private TextView tv_recomendid;
    private TextView tv_newadd;
    private TextView tv_child_newadd;
    private TextView tv_today_team_money;
    private TextView tv_member_newadd;
    private TextView tv_childmember_add;
    private TextView tv_todaymoney;
    private TextView tv_agent_newadd;
    private TextView tv_childagent_newadd;
    private TextView tv_todayestimate;
    private ImageView iv_refresh;
    private ImageView tv_yesterday_money;
    private TextView tv_history_money;
    private TextView tv_canget_mony;
    private RelativeLayout rl_get_money;
    //右邊
    private ImageView iv_save_qr;
    private ImageView iv_share_tofriend;
    private ImageView iv_shar_toqq;
    private ImageView iv_share_tocircle;
    private TextView tv_website;
    private ImageView iv_copywebsite;
    private ImageView iv_get_history;
    private ImageView iv_tochart;

    private IWXAPI api;
    private ShareBean shareBeann;

    public MyPromotionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mypromotionfragment, container, false);
        this.api = WXAPIFactory.createWXAPI(getActivity(), UrlHelper.APP_ID, true);
        this.api.registerApp(UrlHelper.APP_ID);
        initView(view);
        initData();
        initLisner();
        return view;
    }

    private void initData() {
        getShareBean();
    }

    private ShareBean getShareBean() {
        shareBeann = new ShareBean();
        shareBeann.setContent("内容");
        shareBeann.setId(1);
        shareBeann.setImage("");
        shareBeann.setTitle("标题");
        shareBeann.setName("名字");
        shareBeann.setShare("https://www.qqkw.com/d/file/p/2018/06-15/feec0eedfdbbe29ebefc2f7bc97e4b1d.jpg");
        return shareBeann;
    }


    private void initLisner() {
        iv_refresh.setOnClickListener(this);
        rl_get_money.setOnClickListener(this);
        iv_share_tofriend.setOnClickListener(this);
        iv_shar_toqq.setOnClickListener(this);
        iv_share_tocircle.setOnClickListener(this);
        iv_copywebsite.setOnClickListener(this);
        iv_tochart.setOnClickListener(this);
    }

    private void initView(View view) {
        View loading = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_loading, null);
        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
        this.loadingDialog.initDialog(loading);
//        loadingDialog.showDialog();
        tv_myid = view.findViewById(R.id.tv_myid);
        tv_recomendid = view.findViewById(R.id.tv_recomendid);
        tv_newadd = view.findViewById(R.id.tv_newadd);
        tv_child_newadd = view.findViewById(R.id.tv_child_newadd);
        tv_today_team_money = view.findViewById(R.id.tv_today_team_money);
        tv_member_newadd = view.findViewById(R.id.tv_member_newadd);
        tv_childmember_add = view.findViewById(R.id.tv_childmember_add);
        tv_todaymoney = view.findViewById(R.id.tv_todaymoney);
        tv_agent_newadd = view.findViewById(R.id.tv_agent_newadd);
        tv_childagent_newadd = view.findViewById(R.id.tv_childagent_newadd);
        tv_todayestimate = view.findViewById(R.id.tv_todayestimate);
        iv_refresh = view.findViewById(R.id.iv_refresh);
        tv_todayestimate = view.findViewById(R.id.tv_todayestimate);
        tv_todayestimate = view.findViewById(R.id.tv_todayestimate);
        tv_history_money = view.findViewById(R.id.tv_history_money);
        tv_canget_mony = view.findViewById(R.id.tv_canget_mony);
        rl_get_money = view.findViewById(R.id.rl_get_money);
//右边

        iv_share_tofriend = view.findViewById(R.id.iv_share_tofriend);
        iv_shar_toqq = view.findViewById(R.id.iv_shar_toqq);
        iv_share_tocircle = view.findViewById(R.id.iv_share_tocircle);
        tv_website = view.findViewById(R.id.tv_website);
        iv_copywebsite = view.findViewById(R.id.iv_copywebsite);
        iv_get_history = view.findViewById(R.id.iv_get_history);
        iv_tochart = view.findViewById(R.id.iv_tochart);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_refresh:
                break;
            case R.id.rl_get_money:
                break;
            case R.id.iv_share_tofriend:
                shareWxImageCompress(false);
//                if (this.shareBeann == null) {
//                    return;
//                }
//                if (AppPackageUtils.checkPackInfo(getContext(), "com.tencent.mm"))
//                {
//                    shareWxImageCompress(false);
//                    return;
//                }
                break;
            case R.id.iv_shar_toqq:
                shareImageCompress();
                break;
            case R.id.iv_share_tocircle:
                shareWxImageCompress(true);
                break;
            case R.id.iv_get_history:
                break;
            case R.id.iv_copywebsite:
                Utils.copyToClipboard(getContext(),tv_website.getText().toString());
                break;
            case R.id.iv_tochart:
                break;
        }
    }

    private void shareImageCompress() {

    }

    private Bitmap shareWXBitmap;

    private void shareWxImageCompress(boolean flag) {

        loadingDialog.showDialog();
        if (shareWXBitmap == null) {
            if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getContext()), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                ToastUtil.getInstance().showToast("请打开存储权限");
                loadingDialog.dismissDialog();
            } else {
                ImageUtils.compressImageUrlResultPath(getContext(), shareBeann.getShare(), new BaseCallBack() {
                            @Override
                            public void onFail(int paramInt, String paramString) {
//                                UIHelper.showToast(a.b.getContext(), "分享失败");
                                ToastUtil.getInstance().showToast("分享失败");
                                loadingDialog.dismissDialog();
                            }

                            @Override
                            public void onSuccess(Object bitmap, String paramString) {
                                FileUtils.saveImageToGallery((Bitmap) bitmap);
                                shareWXBitmap = (Bitmap) bitmap;
                                loadingDialog.dismissDialog();
                            }

                        }
                );
            }
        } else {
            shareWeChat(flag);
        }
    }

    private void shareWeChat(boolean paramBoolean) {
        WXWebpageObject localObject = new WXWebpageObject();
        localObject.webpageUrl = this.shareBeann.getImage();
        if (this.shareWXBitmap == null) {
            this.shareWXBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        }
        WXMediaMessage localWXMediaMessage = new WXMediaMessage(localObject);
        localWXMediaMessage.mediaObject = new WXImageObject(this.shareWXBitmap);
        localWXMediaMessage.title = this.shareBeann.getTitle();
        localWXMediaMessage.description = this.shareBeann.getContent();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = localWXMediaMessage;
        if (paramBoolean) {
            req.scene = SendMessageToWX.Req.WXSceneTimeline;
        } else {
            req.scene = SendMessageToWX.Req.WXSceneSession;
        }
        api.sendReq(req);
        new Handler().postDelayed(() -> loadingDialog.dismissDialog(), 5000L);
    }
}

package com.chai.colin.util;

import android.view.View;
import android.widget.TextView;

import com.chai.colin.R;
import com.liyi.multiple.MultipleStatusView;

/**
 * Created by albertlii on 2018/4/18.
 */

public class StatusViewUtil {
    private MultipleStatusView defaultView, customView;

    public StatusViewUtil(MultipleStatusView defaultView, MultipleStatusView customView) {
        this.defaultView = defaultView;
//        customView.setView(MultipleStatusView.ViewType.TYPE_LOADING, R.layout.custom_test_view);
//        customView.setView(MultipleStatusView.ViewType.TYPE_NETWORK_POOR, R.layout.custom_test_view);
//        customView.setView(MultipleStatusView.ViewType.TYPE_EMPTY, R.layout.custom_test_view);
//        customView.setView(MultipleStatusView.ViewType.TYPE_ERROR, R.layout.custom_test_view);
//        customView.setView(MultipleStatusView.ViewType.TYPE_SPECIFIED, R.layout.custom_test_view);
        customView.setView(10, R.layout.custom_test_view);
        customView.setView(20, R.layout.custom_test_view);
        this.customView = customView;
    }

    public void showDefaultView(int viewType) {
        defaultView.showView(viewType);
        defaultView.setVisibility(View.VISIBLE);
        customView.setVisibility(View.GONE);
    }

    public void showCustomView(int viewType) {
        String desc = "自定义 view 测试";
        switch (viewType) {
            case MultipleStatusView.ViewType.TYPE_LOADING:
                desc = "TEST === 加载中";
                break;
            case MultipleStatusView.ViewType.TYPE_NETWORK_POOR:
                desc = "TEST === 网络异常";
                break;
            case MultipleStatusView.ViewType.TYPE_EMPTY:
                desc = "TEST === 空数据";
                break;
            case MultipleStatusView.ViewType.TYPE_ERROR:
                desc = "TEST === 加载失败";
                break;
            case MultipleStatusView.ViewType.TYPE_SPECIFIED:
                desc = "TEST === 自定义 SPECIFIED";
                break;
            case 10:
                desc = "TEST === 自定义 x10";
                break;
            case 20:
                desc = "TEST === 自定义 x20";
                break;
        }
        final String finalDesc = desc;
        customView.setHandler(viewType, (viewType1, view) -> ((TextView) view.findViewById(R.id.tv_test_desc)).setText(finalDesc));
        customView.showView(viewType);
        customView.setVisibility(View.VISIBLE);
        defaultView.setVisibility(View.GONE);
    }
}

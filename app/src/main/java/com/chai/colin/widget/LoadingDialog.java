package com.chai.colin.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.chai.colin.R;

public class LoadingDialog extends Dialog  {
    private AnimationDrawable animationDrawable;

    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void dismissDialog() {
        try {
            dismiss();
            if (this.animationDrawable != null) {
                this.animationDrawable.stop();
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

//    public void hideLoadingView() {
//
//    }

    public void initDialog(View paramView) {
        setContentView(paramView);
        ImageView view = paramView.findViewById(R.id.iv_loading);
        if (getWindow() != null) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.width = -1;
            localLayoutParams.height = -1;
            getWindow().setAttributes(localLayoutParams);
        }
        this.animationDrawable = ((AnimationDrawable) view.getDrawable());
    }


    public void showDialog() {
        try {
            if (!isShowing()) {
                show();
                if (this.animationDrawable != null) {
                    this.animationDrawable.stop();
                    this.animationDrawable.start();
                }
            }
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

}

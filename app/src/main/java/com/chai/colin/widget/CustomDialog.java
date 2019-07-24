package com.chai.colin.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

public class CustomDialog
        extends Dialog {
    private float x1 = 0.0F;
    private float x2 = 0.0F;
    private float y1 = 0.0F;
    private float y2 = 0.0F;


    public CustomDialog(Context context) {
        this(context, 0);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public boolean dispatchTouchEvent(@NonNull MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                x1 = ev.getX();
                y1 = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                x2 = ev.getX();
                y2 = ev.getY();
                if ((y1 - y2 <= 50f) && (y2 - y1) <= 50f) {
                    EventBus.getDefault().post("touchOutSideEvent");
                }
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
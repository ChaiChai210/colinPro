package com.chai.colin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomScrollViewPager
        extends ViewPager {
    private boolean scrollable = false;

    public CustomScrollViewPager(@NonNull Context paramContext) {
        super(paramContext);
    }

    public CustomScrollViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        return scrollable;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        return scrollable;
    }

    public void setScrollable(boolean scrollable) {
        this.scrollable = scrollable;
    }
}


package com.chai.colin.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chai.colin.R;

import java.util.ArrayList;

public class MultipleStatusView
        extends RelativeLayout {
    private static final LayoutParams DEFAULT_LAYOUT_PARAMS = new LayoutParams(-1, -1);
    private static final int NULL_RESOURCE_ID = -1;
    public static final int STATUS_CONTENT = 0;
    public static final int STATUS_EMPTY = 2;
    public static final int STATUS_ERROR = 3;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_NO_NETWORK = 4;
    private static final String TAG = "MultipleStatusView";
    private View mContentView;
    private int mContentViewResId;
    private View mEmptyView;
    private int mEmptyViewResId;
    private View mErrorView;
    private int mErrorViewResId;
    private final LayoutInflater mInflater;
    private View mLoadingView;
    private int mLoadingViewResId;
    private View mNoNetworkView;
    private int mNoNetworkViewResId;
    private OnClickListener mOnRetryClickListener;
    private final ArrayList<Integer> mOtherIds = new ArrayList();
    private int mViewStatus;
    private String showString;

    public MultipleStatusView(Context paramContext) {
        this(paramContext, null);
    }

    public MultipleStatusView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public MultipleStatusView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        TypedArray ta = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MultipleStatusView, paramInt, 0);
        this.mEmptyViewResId = ta.getResourceId(R.styleable.MultipleStatusView_emptyView, R.layout.view_empty);
        this.mContentViewResId = ta.getResourceId(0, -1);
        ta.recycle();
        this.mInflater = LayoutInflater.from(paramContext);
    }

    private void checkNull(Object paramObject, String paramString) {
        if (paramObject != null) {
            return;
        }
        throw new NullPointerException(paramString);
    }

    private void clear(View... paramVarArgs) {
        if (paramVarArgs == null) {
            return;
        }
        try {
            for (View localView : paramVarArgs) {
                if (localView != null) {
                    removeView(localView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View inflateView(int paramInt) {
        return this.mInflater.inflate(paramInt, null);
    }

    private void showContentView() {
        int k = getChildCount();
        for (int i = 0; i < k; i++) {
            View localView = getChildAt(i);
            if (this.mOtherIds.contains(localView.getId())) {
                localView.setVisibility(GONE);
            } else {
                localView.setVisibility(VISIBLE);
            }
        }
    }

    private void showViewById(int paramInt) {
        int k = getChildCount();
        for (int i = 0; i < k; i++) {
            View localView = getChildAt(i);
            if (localView.getId() == paramInt) {
                localView.setVisibility(VISIBLE);
            } else {
                localView.setVisibility(GONE);
            }
        }
    }

    public int getViewStatus() {
        return this.mViewStatus;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear(this.mEmptyView, this.mLoadingView, this.mErrorView, this.mNoNetworkView);
        mOtherIds.clear();
        if (this.mOnRetryClickListener != null) {
            this.mOnRetryClickListener = null;
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        showContent();
    }

    public void setOnRetryClickListener(OnClickListener paramOnClickListener) {
        this.mOnRetryClickListener = paramOnClickListener;
    }

    public final void showContent() {
        this.mViewStatus = 0;
        if (this.mContentView == null) {
            int i = this.mContentViewResId;
            if (i != -1) {
                this.mContentView = this.mInflater.inflate(i, null);
                addView(this.mContentView, 0, DEFAULT_LAYOUT_PARAMS);
            }
        }
        showContentView();
    }

    public final void showContent(int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        showContent(inflateView(paramInt), paramLayoutParams);
    }

    public final void showContent(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        checkNull(paramView, "Content view is null.");
        checkNull(paramLayoutParams, "Layout params is null.");
        this.mViewStatus = 0;
        clear(this.mContentView);
        this.mContentView = paramView;
        addView(this.mContentView, 0, paramLayoutParams);
        showViewById(this.mContentView.getId());
    }

    public final void showEmpty() {
        showEmpty(this.mEmptyViewResId, DEFAULT_LAYOUT_PARAMS);
    }

    public final void showEmpty(int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        View localView2 = this.mEmptyView;
        View localView1 = localView2;
        if (localView2 == null) {
            localView1 = inflateView(paramInt);
        }
        showEmpty(localView1, paramLayoutParams);
    }

    public final void showEmpty(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        checkNull(paramView, "Empty view is null.");
        checkNull(paramLayoutParams, "Layout params is null.");
        this.mViewStatus = 2;
        if (this.mEmptyView == null) {
            this.mEmptyView = paramView;
            View localView = this.mEmptyView.findViewById(R.id.empty_retry_view);
            if ((paramView != null) && (mOnRetryClickListener != null)) {
                localView.setOnClickListener(mOnRetryClickListener);
            }
            if (!TextUtils.isEmpty(this.showString)) {
                try {
                    ((TextView) this.mEmptyView.findViewById(R.id.empty_view_tv)).setText(this.showString);
                    this.showString = "";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mOtherIds.add(this.mEmptyView.getId());
            addView(this.mEmptyView, 0, paramLayoutParams);
        }
        showViewById(this.mEmptyView.getId());
    }

    public final void showEmpty(String paramString) {
        this.showString = paramString;
        showEmpty(this.mEmptyViewResId, DEFAULT_LAYOUT_PARAMS);
    }

    public final void showLoading() {
        showLoading(this.mLoadingViewResId, DEFAULT_LAYOUT_PARAMS);
    }

    public final void showLoading(int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        View localView2 = this.mLoadingView;
        View localView1 = localView2;
        if (localView2 == null) {
            localView1 = inflateView(paramInt);
        }
        showLoading(localView1, paramLayoutParams);
    }

    public final void showLoading(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        checkNull(paramView, "Loading view is null.");
        checkNull(paramLayoutParams, "Layout params is null.");
        this.mViewStatus = 1;
        if (this.mLoadingView == null) {
            this.mLoadingView = paramView;
            this.mOtherIds.add(this.mLoadingView.getId());
            addView(this.mLoadingView, 0, paramLayoutParams);
        }
        showViewById(this.mLoadingView.getId());
    }
}



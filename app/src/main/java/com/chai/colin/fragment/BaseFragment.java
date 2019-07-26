package com.chai.colin.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;
import com.chai.colin.util.SoundPoolUtil;
import com.chai.colin.widget.LoadingDialog;

import java.util.Objects;

public class BaseFragment
        extends Fragment {
    public static final String TAG = "BaseFragment";
    protected InputMethodManager inputMethodManager;
    protected LoadingDialog loadingDialog;
    protected boolean mIsPrepare;
    protected boolean mIsVisible;
    protected BaseActivity mContext;
    private void onLazyLoad() {
        if ((this.mIsVisible) && (this.mIsPrepare)) {
            this.mIsPrepare = false;
            initData();
        }
    }

//  protected void dialogSet(Dialog paramDialog)
//  {
//    paramDialog = paramDialog.getWindow();
//    if (paramDialog != null)
//    {
//      WindowManager.LayoutParams localLayoutParams = paramDialog.getAttributes();
//      localLayoutParams.gravity = 17;
//      localLayoutParams.width = -1;
//      localLayoutParams.height = -2;
//      paramDialog.getDecorView().setPadding(0, 0, 0, 0);
//      paramDialog.setAttributes(localLayoutParams);
//    }
//  }

    protected void initData() {
    }

    protected void initView() {
    }

    protected boolean isLazyLoad() {
        return true;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            this.mIsVisible = true;
            onVisible();
        } else {
            this.mIsVisible = false;
            onInvisible();
        }
    }


    protected void onInvisible() {
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        LoadingUtil.getInstance().initView(getActivity());
//    this.inputMethodManager = ((InputMethodManager)((Context)Objects.requireNonNull(getContext())).getSystemService("input_method"));
        View loading  = LayoutInflater.from(mContext).inflate(R.layout.layout_loading, null);
        this.loadingDialog = new LoadingDialog((Context) Objects.requireNonNull(getContext()), R.style.MobileDialog);
        this.loadingDialog.initDialog(loading);
        if (isLazyLoad()) {
            this.mIsPrepare = true;
            onLazyLoad();
        } else {
            initData();
        }
        initView();
    }


    protected void onVisible() {
        onLazyLoad();
    }

    public void playMusic(int paramInt, float paramFloat) {
        SoundPoolUtil.play(paramInt, paramFloat);
    }


    public void stopMusic(int paramInt) {
        SoundPoolUtil.stop(paramInt);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (BaseActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
    }
}


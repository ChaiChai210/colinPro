package com.chai.colin;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.chai.colin.util.EventBusHelper;
import com.chai.colin.util.SoundPoolUtil;
import com.chai.colin.widget.LoadingDialog;


public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected AudioManager audioManager;
    private NetworkChangeReceiver receiver;
    protected static float volume = 0.8F;
    protected static float volumeBg = 0.8F;
    protected LoadingDialog loadingDialog;
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        mContext = this;
//        setStatusBarColor();
        // 基类中注册 eventbus
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBusHelper.register(this);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//黑色
        }
//        StatusBarUtil.setLightMode(this);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        View view  = LayoutInflater.from(this).inflate(R.layout.layout_loading, null);
        this.loadingDialog = new LoadingDialog(this, R.style.MobileDialog);
        this.loadingDialog.initDialog(view);
        registerNetworkChangeReceiver();
        initView();
        initData();
    }

//    public void setStatusBarColor() {
//        StatusBarUtil.setColor(this, getResources().getColor(android.R.color.white), 0);
//    }

    protected abstract int getLayoutResId();

    protected abstract void initView();

    protected void initData() {

    }

    /**
     * 注册网络监听广播
     */
    private void registerNetworkChangeReceiver() {
        receiver = new NetworkChangeReceiver(this);
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver.onDestroy();
            receiver = null;
        }
        // 取消注册
        if (this.getClass().isAnnotationPresent(BindEventBus.class)) {
            EventBusHelper.unregister(this);
        }
    }

    public void setStatusBarTextColor(Window window, boolean lightStatusBar) {
        // 设置状态栏字体颜色 白色与深色
        View decor = window.getDecorView();
        int ui = decor.getSystemUiVisibility();
        ui |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (lightStatusBar) {
                ui |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            } else {
                ui &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            }
        }
        decor.setSystemUiVisibility(ui);
    }

    public boolean isSilentMode() {
        return audioManager.getRingerMode() != 2;
    }

    public void playMusic(int paramInt, float paramFloat) {
        SoundPoolUtil.getInstance(this).play(paramInt, volume);
    }

    public void stopMusic(int paramInt) {
        SoundPoolUtil.stop(paramInt);
    }
    public void showLoading(){
        loadingDialog.showDialog();
    }
    public void hideLoading(){
        loadingDialog.dismissDialog();
    }
}

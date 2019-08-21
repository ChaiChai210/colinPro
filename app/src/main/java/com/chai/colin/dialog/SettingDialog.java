package com.chai.colin.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chai.colin.R;
import com.chai.colin.util.MediaPlayUtil;
import com.chai.colin.util.SPUtils;
import com.chai.colin.util.SoundPoolUtil;
import com.king.app.dialog.AppDialog;
import com.king.app.dialog.AppDialogConfig;
import com.king.app.updater.AppUpdater;

public class SettingDialog extends BaseDialogFragment {
    private boolean accountBalance;
//    public static SettingDialog newInstance(String account, String password) {
//        SettingDialog frag = new SettingDialog();
//        Bundle args = new Bundle();
//        args.putString("account", account);
//        args.putString("password", password);
//        frag.setArguments(args);
//        return frag;
//    }

    private RadioGroup rg_setting;
    private RadioButton changePwd;
    private FrameLayout content;
    private String version;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        String account = getArguments().getString("account");
//        String password = getArguments().getString("password");
        View view = inflater.inflate(R.layout.dialog_setting, container);
        initView(view);
        settingSoundFragment();
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.btn_close).setOnClickListener(view1 -> dismiss()
        );
        rg_setting = view.findViewById(R.id.rg_setting);
        changePwd = view.findViewById(R.id.rBtn_setting_password_replace);
        content = view.findViewById(R.id.fl_setting_right);

        if (accountBalance) {
            changePwd.setVisibility(View.VISIBLE);
        } else {
            changePwd.setVisibility(View.GONE);
        }

        rg_setting.setOnCheckedChangeListener((group, checkedId) -> {
            if (R.id.rBtn_setting_sound == checkedId) {
                settingSoundFragment();
            } else if (R.id.rBtn_setting_password_replace == checkedId) {
            } else if (R.id.rBtn_setting_app_replace == checkedId) {
                AppDialogConfig config = new AppDialogConfig();
                config.setTitle("简单弹框升级")
                        .setOk("升级")
                        .setContent("1、新增某某功能、\n2、修改某某问题、\n3、优化某某BUG、")
                        .setOnClickOk(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                new AppUpdater.Builder()
                                        .serUrl("https://raw.githubusercontent.com/jenly1314/AppUpdater/master/app/release/app-release.apk")
                                        .setFilename("AppUpdater.apk")
                                        .build(getContext())
                                        .start();
                                AppDialog.INSTANCE.dismissDialog();
                            }
                        });
                AppDialog.INSTANCE.showDialog(getContext(),config);
//                mContext.showLoading();
            }
        });

    }

    private void settingSoundFragment() {
        View rightContent;
        if (accountBalance) {
            rightContent = LayoutInflater.from(mContext).inflate(R.layout.fragment_setting_sound, content, false);
        } else {
            rightContent = LayoutInflater.from(mContext).inflate(R.layout.fragment_setting_sound_nologin, content, false);
        }
        int volume = mContext.getMediaVolume();
        final int maxVolume = mContext.getMaxVolume();

        SeekBar sb_music = rightContent.findViewById(R.id.sb_music);
        SeekBar sb_vol = rightContent.findViewById(R.id.sb_vol);
        sb_music.setProgress(SPUtils.getInstance().getMusic(mContext.getMediaVolume()));
        sb_music.setMax(maxVolume);
        sb_vol.setProgress(SPUtils.getInstance().getVolum(mContext.getMediaVolume()));
        sb_vol.setMax(maxVolume);

        TextView tv_setting_name = rightContent.findViewById(R.id.tv_setting_name);
//        tv_setting_name.setText(userAccount);
        TextView tv_setting_id = rightContent.findViewById(R.id.tv_setting_id);
//        tv_setting_name.setText(memberLevelVIPName);
        TextView tv_app_version = rightContent.findViewById(R.id.tv_app_version);
        tv_app_version.setText(version);

        ImageView btn_logout = rightContent.findViewById(R.id.btn_logout);
        if (accountBalance) {
            //todo退出登录
//            btn_logout.setOnClickListener();
        } else {
            btn_logout.setVisibility(View.INVISIBLE);
        }
        sb_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                SPUtils.getInstance().setMusic(progress);
                if (!mContext.isSilentMode()) {
                    MediaPlayUtil.setVolume((float) progress / maxVolume);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                SPUtils.getInstance().setVolume(progress);
                if (!mContext.isSilentMode())
                    SoundPoolUtil.setVolume2(SoundPoolUtil.mStreamId2, (float) progress / maxVolume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        content.removeAllViews();
        content.addView(rightContent);
    }


}

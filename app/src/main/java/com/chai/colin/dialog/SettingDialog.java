package com.chai.colin.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.chai.colin.BaseActivity;
import com.chai.colin.R;
import com.chai.colin.util.SPUtils;
import com.chai.colin.util.Utils;

public class SettingDialog extends DialogFragment {
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
        settingSoundFragment(inflater);
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
            String msg = "";
            if (R.id.rBtn_setting_sound == checkedId) {
//                settingSoundFragment();
            } else if (R.id.rBtn_setting_password_replace == checkedId) {
                msg = "换密码";
            } else if (R.id.rBtn_setting_app_replace == checkedId) {
                msg = "ddd";
            }
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        });

    }

    private void settingSoundFragment(LayoutInflater inflater) {
        View rightContent;
        if (accountBalance) {
            rightContent = inflater.inflate(R.layout.fragment_setting_sound, content, false);
        } else {
            rightContent = inflater.inflate(R.layout.fragment_setting_sound_nologin, content, false);
        }

        SeekBar sb_music =  rightContent.findViewById(R.id.sb_music);
        SeekBar sb_vol =  rightContent.findViewById(R.id.sb_vol);
        TextView tv_setting_name = rightContent.findViewById(R.id.tv_setting_name);
//        tv_setting_name.setText(userAccount);
        TextView tv_setting_id = rightContent.findViewById(R.id.tv_setting_id);
//        tv_setting_name.setText(memberLevelVIPName);
        TextView tv_app_version = rightContent.findViewById(R.id.tv_app_version);
        tv_app_version.setText(version);

        ImageView btn_logout =rightContent.findViewById(R.id.btn_logout);
        if(accountBalance){
            //todo退出登录
//            btn_logout.setOnClickListener();
        }else{
            btn_logout.setVisibility(View.INVISIBLE);
        }
        //音量设置
//        i1 = audioManager.getStreamMaxVolume(3);
//        int k1 = audioManager.getStreamVolume(3);
//        int j1 = SPUtils.getInstance().getMusic(k1);
//        k1 = SPUtils.getInstance().getVolum(k1);
//        sb_music.setMax(i1);
//        sb_music.setProgress(j1);
        sb_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                final MainActivity a = MainActivity.this;
//                BaseActivity.volumeBg = (float) l1 / a.getMaxVolume();
//                SPUtils.getInstance().setMusic(l1);
//                if (!a.isSilentMode())
//                    MediaPlayUtil.setVolume(BaseActivity.volumeBg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb_music.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                final MainActivity a = MainActivity.this;
//                BaseActivity.volume = (float) l1 / a.getMaxVolume();
//                SPUtils.getInstance().setVolume(l1);
//                if (!a.isSilentMode())
//                    SoundPoolUtil.setVolume2(SoundPoolUtil.mStreamId2, BaseActivity.volume);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MobileDialog);
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
//        attributes.gravity = 17;
//        attributes.height = -2;
//        attributes.width = -2;
//        getDialog().getWindow().setAttributes(attributes);
//    }


}

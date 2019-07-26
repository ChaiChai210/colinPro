package com.chai.colin.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;

import com.chai.colin.R;
import com.chai.colin.util.SoftKeyboardUtil;
import com.chai.colin.util.ToastUtil;
import com.chai.colin.util.Utils;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;

import java.lang.reflect.Field;

public class SafePwdDialog extends BaseDialogFragment {
    public static SafePwdDialog newInstance() {
        SafePwdDialog frag = new SafePwdDialog();
        Bundle args = new Bundle();
//        args.putString("account", account);
//        args.putString("password", password);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_input_password, container);
        initView(view);
        return view;
    }

    private void initView(View view) {
        view.findViewById(R.id.btn_close).setOnClickListener(view1 -> dismiss()
        );

        GridPasswordView pswViewSet = view.findViewById(R.id.pswViewSet);
        ImageView iv_confirm_commit = view.findViewById(R.id.iv_confirm_commit);

        setClickShowKeyBoard(pswViewSet, getImeEdittext(pswViewSet));
        pswViewSet.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {

            }

            @Override
            public void onInputFinish(String psw) {
                SoftKeyboardUtil.hideSoftKeyboard(pswViewSet);
            }
        });
        iv_confirm_commit.setOnClickListener(view12 -> {
            String passWord1 = pswViewSet.getPassWord();
            if (passWord1.length() < 4) {
                ToastUtil.getInstance().showToast("密码位数不足");
            }
            verifySafeBoxPassword(Utils.Md5(passWord1));
        });
        setObjByReflect(pswViewSet);
    }

    private void verifySafeBoxPassword(String md5) {

    }

    private void setObjByReflect(GridPasswordView paramGridPasswordView) {
        try {
            getImeEdittext(paramGridPasswordView).setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ImeDelBugFixedEditText getImeEdittext(GridPasswordView paramGridPasswordView) {
        try {
            Field localField = Class.forName("com.jungly.gridpasswordview.GridPasswordView").getDeclaredField("mInputView");
            localField.setAccessible(true);
            return (ImeDelBugFixedEditText) localField.get(paramGridPasswordView);
//            return paramGridPasswordView;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setClickShowKeyBoard(GridPasswordView paramGridPasswordView, final ImeDelBugFixedEditText paramImeDelBugFixedEditText) {
        paramGridPasswordView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
//                Log.e("MainActivity", "onClick: 点击");
                boolean bool = SoftKeyboardUtil.isSoftShowing(mContext);
//                paramAnonymousView = new StringBuilder();
//                paramAnonymousView.append("onClick: softShowing==");
//                paramAnonymousView.append(bool);
//                Log.i("MainActivity", paramAnonymousView.toString());
                if (!bool) {
                    SoftKeyboardUtil.showKeyBoard(mContext);
                    if (paramGridPasswordView != null) {
                        paramGridPasswordView.setFocusable(true);
                        paramImeDelBugFixedEditText.setFocusableInTouchMode(true);
                        paramImeDelBugFixedEditText.requestFocus();
                    }
                }
            }
        });
    }
}

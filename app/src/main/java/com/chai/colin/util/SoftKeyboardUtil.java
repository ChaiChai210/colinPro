package com.chai.colin.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class SoftKeyboardUtil {

    private SoftKeyboardUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 隐藏软键盘
     *
     * @param view
     */
    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean isSoftShowing(Activity paramActivity) {
        int i = paramActivity.getWindow().getDecorView().getHeight();
        Rect localRect = new Rect();
        paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
        boolean bool;
        if (i * 2 / 3 > localRect.bottom) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public static void showKeyBoard(Context paramContext) {
        InputMethodManager imm = (InputMethodManager) paramContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0, 2);
        }
    }
}

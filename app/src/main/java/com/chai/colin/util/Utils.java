package com.chai.colin.util;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
    private static final String ACCOUNT = "^[0-9A-Za-z]{6,16}$";
    private static final String MOBILE = "^[1]\\d{10}$";
    private static final String NAME = "^[\\u4E00-\\u9FA5]{1,6}";
    private static final String PWD = "(?!^[_#@]+$)^.{6,12}$";
    private static final String QQ_NUMBER = "[1-9][0-9]{4,}";
    private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-_|\\\\.]?)+[a-z0-9A-Z]@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";

    public static String Md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result.append(temp);
            }
            //将其转成小写
            return result.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String appMD5(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return "";
        }
        String str = Md5(Md5(paramString));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reverse(str.substring(0, str.length() / 2)));
        stringBuilder.append(reverse(str.substring(str.length() / 2)));
        stringBuilder.append(paramString.substring(2, 8));
        return Md5(stringBuilder.toString());
    }

    public static void copyToClipboard(Context paramContext, String paramString) {
        //获取剪贴板管理器
        ClipboardManager cm = (ClipboardManager) paramContext.getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("text", paramString);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);

    }

    public static double div(double paramDouble1, double paramDouble2, int paramInt) {
        return new BigDecimal(Double.toString(paramDouble1)).divide(new BigDecimal(Double.toString(paramDouble2)), paramInt, 4).doubleValue();
    }

    public static String div(String paramString1, String paramString2, int paramInt) {
        int i = paramInt;
        if (paramInt < 0) {
            i = 0;
        }
        return new BigDecimal(paramString1).divide(new BigDecimal(paramString2), i, 4).toString();
    }

    public static String double2Decimal(double paramDouble) {
        return new DecimalFormat("#0.00").format(paramDouble);
    }

//    @SuppressLint({"MissingPermission"})
//    public static String getIMEI(Context paramContext) {
//        paramContext = (TelephonyManager) paramContext.getSystemService("phone");
//        try {
//            paramContext = paramContext.getDeviceId();
//            return paramContext;
//        } catch (Exception paramContext) {
//        }
//        return "";
//    }

    public static String getProxyName(String paramString) {
        String name = "";
        if (paramString.equals("CAIPIAOPROXY")) {
            name = "彩票";
        } else if (paramString.equals("TIYUPROXY")) {
            name = "体育";
        } else if (paramString.equals("QIPAIPROXY")) {
            name = "棋牌";
        } else if (paramString.equals("BUYUPROXY")) {
            name = "捕鱼";
        } else if (paramString.equals("DIANZIPROXY")) {
            name = "电子";
        }
        return name;
    }

    public static String getRechargeType(String paramString) {
        String name = "";
        if (!paramString.equals("18")) {
            name = "微信转账";
        } else if (!paramString.equals("17")) {
            name = "支付宝转账";
        } else if (!paramString.equals("16")) {
            name = "快速充值";
        } else if (paramString.equals("14")) {
            name = "支付宝入款";
        } else if (paramString.equals("13")) {
            name = "QQ钱包入款";
        } else if (paramString.equals("12")) {
            name = "微信入款";
        } else if (paramString.equals("11")) {
            name = "银行卡入款";
        } else if (paramString.equals("1")) {
            name = "系统入款";
        } else if (paramString.equals("11")) {
            name = "银行卡入款";
        } else {
            name = "无入款来源";
        }
        return name;


    }

    public static int getScreenHeight(Context paramContext) {
        return paramContext.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context paramContext) {
        return paramContext.getResources().getDisplayMetrics().widthPixels;
    }

//    public static String getTopText(String paramString) {
//        paramString = "快速充值";
//        break;
//        case 6:
//        paramString = "代理充值";
//        break;
//        case 4:
//        paramString = "京东钱包";
//        break;
//        case 3:
//        paramString = "支付宝";
//        break;
//        case 2:
//        paramString = "QQ钱包";
//        break;
//        case 1:
//        paramString = "微信";
//        break;
//        case 0:
//        paramString = "银行卡";
//        return paramString;
//    }

//    public static void getWechatApi(Context paramContext) {
//        try {
//            Intent localIntent = new android / content / Intent;
//            localIntent.<init> ("android.intent.action.MAIN");
//            ComponentName localComponentName = new android / content / ComponentName;
//            localComponentName.<init> ("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
//            localIntent.addCategory("android.intent.category.LAUNCHER");
//            localIntent.addFlags(268435456);
//            localIntent.setComponent(localComponentName);
//            paramContext.startActivity(localIntent);
//        } catch (ActivityNotFoundException paramContext) {
//            UIHelper.errorToastString("检查到您手机没有安装微信，请安装后使用该功能");
//        }
//    }

    public static boolean isAccount(String paramString) {
        return paramString.matches("^[0-9A-Za-z]{6,16}$");
    }

    public static boolean isEmail(String paramString) {
        return paramString.matches("^([a-z0-9A-Z]+[-_|\\\\.]?)+[a-z0-9A-Z]@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$");
    }

    public static boolean isName(String paramString) {
        return paramString.matches("^[\\u4E00-\\u9FA5]{1,6}");
    }

    public static boolean isPhone(String paramString) {
        return paramString.matches("^[1]\\d{10}$");
    }

    public static boolean isPwd(String paramString) {
        return paramString.matches("(?!^[_#@]+$)^.{6,12}$");
    }

    public static boolean isQQ(String paramString) {
        return paramString.matches("[1-9][0-9]{4,}");
    }

//    public static int isScreenAutoRotate(Context paramContext) {
//        int i;
//        try {
//            i = Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation");
//        } catch (Settings.SettingNotFoundException paramContext) {
//            paramContext.printStackTrace();
//            i = 0;
//        }
//        return i;
//    }

    public static String long2String(long paramLong, String paramString) {
        if (paramLong < 1000L) {
            return null;
        }
        Date localDate = new Date(paramLong);
        return new SimpleDateFormat(paramString, Locale.CHINA).format(localDate);
    }

    public static double mul(double paramDouble1, double paramDouble2) {
        return new BigDecimal(Double.toString(paramDouble1)).multiply(new BigDecimal(Double.toString(paramDouble2))).doubleValue();
    }

    public static String pwdMD5(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return "";
        }
        paramString = Md5(Md5(paramString));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(reverse(paramString.substring(0, paramString.length() / 2)));
        localStringBuilder.append(reverse(paramString.substring(paramString.length() / 2)));
        localStringBuilder.append(localStringBuilder.substring(0, 3));
        return Md5(localStringBuilder.toString());
    }

    public static String[] range2data(String paramString) {
        return paramString.split("-");
    }

    private static String reverse(String paramString) {
        return new StringBuilder(paramString).reverse().toString();
    }

    public static double round(double paramDouble, int paramInt1, int paramInt2) {
        return new BigDecimal(paramDouble).setScale(paramInt1, paramInt2).doubleValue();
    }


    public void saveBitmap(Context paramContext, Bitmap paramBitmap) {
        // 首先保存图片
        File appDir = new File(Environment.getExternalStorageDirectory(), "/zupubao/");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        StringBuilder fileName = new StringBuilder();
        fileName.append(java.lang.System.currentTimeMillis());
        fileName.append("wei_xin.jpg");
        File pictureFile = new File(appDir, fileName.toString());
        if (pictureFile.exists()) {
            pictureFile.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(pictureFile);
            paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
//            Snackbar.make(paramContext.findViewById(android.R.id.content), "保存图片成功"+pictureFile.getAbsolutePath(), Snackbar.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 其次把文件插入到系统图库
        try {
            MediaStore.Images.Media.insertImage(paramContext.getContentResolver(),
                    pictureFile.getAbsolutePath(), fileName.toString(), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 最后通知图库更新
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(pictureFile);
        intent.setData(uri);
        paramContext.sendBroadcast(intent);
    }

    public static void setEditTextHintSize(EditText paramEditText, String paramString, int paramInt) {
        SpannableString spannableString = new SpannableString(paramString);
        spannableString.setSpan(new AbsoluteSizeSpan(paramInt, true), 0, paramString.length(), 33);
        paramEditText.setHint(new SpannedString(paramString));
    }

    public static double sub(double paramDouble1, double paramDouble2) {
        return new BigDecimal(Double.toString(paramDouble1)).subtract(new BigDecimal(Double.toString(paramDouble2))).doubleValue();
    }

    public static double sum(double paramDouble1, double paramDouble2) {
        return new BigDecimal(Double.toString(paramDouble1)).add(new BigDecimal(Double.toString(paramDouble2))).doubleValue();
    }
}


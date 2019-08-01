package com.chai.colin.util;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import com.chai.colin.R;

import java.util.List;

public class AppUtil {

    private AppUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static String getAppVersion() {
        return null;
    }

    public static String getAppName(Context context) {
        PackageManager pm = context.getPackageManager();
        //获取包信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //获取应用 信息
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            //获取albelRes
            int labelRes = applicationInfo.labelRes;
            //返回App的名称
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isAppInstalled(Context context, String packagename) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        return packageInfo != null;
    }
//另外一种方法

    private boolean isAvilible(Context context, String packageName) {

        final PackageManager packageManager = context.getPackageManager();

        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for (int i = 0; i < pinfo.size(); i++) {

            // 循环判断是否存在指定包名
            if (pinfo.get(i).packageName.equalsIgnoreCase(packageName)) {
                return true;
            }

        }
        return false;

    }

    // 帮助
    private ComponentName help_set;
    private final static String help_set_pack = "cn.abc.help";
    private final static String help_set_name = "cn.abc.help.MainActivity";

    /**
     * 启动一个app
     * com -- ComponentName 对象，包含apk的包名和主Activity名
     * param -- 需要传给apk的参数
     */
//    private void startApp(ComponentName com, String param) {
//        if (com != null) {
//            PackageInfo packageInfo;
//            try {
//                packageInfo = getPackageManager().getPackageInfo(com.getPackageName(), 0);
//            } catch (NameNotFoundException e) {
//                packageInfo = null;
//                Toast.makeText(this, "没有安装", Toast.LENGTH_SHORT).show();
//                e.printStackTrace();
//            }
//            try {
//                Intent intent = new Intent();
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.setComponent(com);
//                if (param != null) {
//                    Bundle bundle = new Bundle(); // 创建Bundle对象
//                    bundle.putString("flag", param); // 装入数据
//                    intent.putExtras(bundle); // 把Bundle塞入Intent里面
//                }
//                startActivity(intent);
//            } catch (Exception e) {
//                Toast.makeText(this, "启动异常", Toast.LENGTH_SHORT).show();
//            }
//        }
    public static void startAPP(Context context, String appPackageName) {
        try {
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(appPackageName);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "没有安装", Toast.LENGTH_LONG).show();
        }
    }

//    public static void launchApp(Context context, String packName) {
//        if (isAvilible(context, "com.tencent.mm")) {
//            Intent i = new Intent(); //启动指定包名应用
//            ComponentName cn = new ComponentName("com.tencent.mm",
//                    "com.tencent.mm.WeiXinActivity");
//            i.setComponent(cn);
//            context.startActivity(i);
////            context.startActivityForResult(i, RESULT_OK);
//        } else {
//            Uri uri = Uri.parse("market://details?id=com.tencent.mm");//市场下载
//            // 直接从指定网址下载
//            // Uri uri = Uri.parse("http://dldir1.qq.com/foxmail/weixin521android400.apk");
//            Intent it = new Intent(Intent.ACTION_VIEW, uri);
//            context.startActivity(it);
//
//        }
//    }


    public static void luncherQQ(Context context, String paramString) {
        if (isAppInstalled(context, "com.tencent.mobileqq")) {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("mqqwpa://im/chat?chat_type=wpa&uin=");
            localStringBuilder.append(paramString);
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(localStringBuilder.toString())));
        } else {
            Toast.makeText(context, R.string.please_download, Toast.LENGTH_LONG).show();
        }
    }

    public static void getWechatApi(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            ComponentName localComponentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(localComponentName);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            ToastUtil.getInstance().showToast("检查到您手机没有安装微信，请安装后使用该功能");
        }
    }
}


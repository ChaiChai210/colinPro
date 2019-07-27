package com.chai.colin.util;

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileUtils {
    private static final String TAG = "FileUtils";
    private String SDPATH;

    public interface FileCallback {

        void onFileCallback(File file);
    }


    public FileUtils() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Environment.getExternalStorageDirectory());
        stringbuilder.append("/");
        SDPATH = stringbuilder.toString();
    }

    static String a() {
        return TAG;
    }


    public static boolean deleteFile(Context context, String s) {
        return context.deleteFile(s);
    }

    public static boolean exists(Context context, String s) {
        return (new File(context.getFilesDir(), s)).exists();
    }

    /**
     * 获取asset文件下的资源文件信息
     *
     * @param fileName
     * @return
     */
    public static String getFromAssets(String fileName, Context context) {

        try {
            InputStreamReader inputReader = new InputStreamReader(
                    context.getAssets().open(fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line;
            StringBuilder Result = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                Result.append(line);
            }
            return Result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


//    public static void install(Context context, Uri uri) {
//        Intent intent = new Intent("android.intent.action.VIEW");
//        intent.addFlags(0x10000000);
//        intent.setDataAndType(uri, "application/vnd.android.package-archive");
//        context.startActivity(intent);
//    }

//    public static void install(Context context, File file) {
//        Intent intent = new Intent("android.intent.action.VIEW");
//        intent.addFlags(0x10000000);
//        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
//        context.startActivity(intent);
//    }

    public void installApk(Context context, File file, String authority) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N ? FileProvider.getUriForFile(context, authority, file) :
                Uri.fromFile(file), "\"application/vnd.android.package-archive\"");
        context.startActivity(intent);
    }


    public static String saveImageToGallery(Bitmap bitmap) {
        File dir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile(), "shareImg");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(System.currentTimeMillis());
        stringbuilder.append(".jpg");
        File file = new File(dir, stringbuilder.toString());
        stringbuilder = new StringBuilder();
        stringbuilder.append("saveImageToGallery: currentFile==");
        stringbuilder.append(file);
        Log.e((TAG), stringbuilder.toString());
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file.getAbsolutePath();

    }


    public File createSDDir(String s) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(SDPATH);
        stringbuilder.append(s);
        File file = new File(stringbuilder.toString());
        file.mkdir();
        return file;
    }

    public File createSDFile(String s) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(SDPATH);
        stringbuilder.append(s);
        return new File(stringbuilder.toString());
    }

    public String getSDPATH() {
        return SDPATH;
    }

//    public boolean isFileExist(String s) {
//        StringBuilder stringbuilder = new StringBuilder();
//        stringbuilder.append(SDPATH);
//        stringbuilder.append(s);
//        s = new File(stringbuilder.toString());
//        if (s.exists())
//            s.delete();
//        return false;
//    }


}

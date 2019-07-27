package com.chai.colin.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chai.colin.MyApp;
import com.chai.colin.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
    @RequiresApi(api = 26)
    public static Bitmap base2Bitmap(@NonNull String paramString) {
        byte[] bytes = Base64.decode(paramString, 0);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" bitmap: ");
        localStringBuilder.append(paramString.toString());
        Log.e("Bitmap", localStringBuilder.toString());
        return bitmap;
    }

    public static void commenLoad(Context paramContext, String paramString, ImageView paramImageView, int paramInt) {
        Glide.with(paramContext).load(paramString).skipMemoryCache(false).error(paramInt).into(paramImageView);
    }

    public static Bitmap compressImage(Bitmap paramBitmap) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramBitmap.compress(CompressFormat.JPEG, 100, localByteArrayOutputStream);
        for (int i = 100; localByteArrayOutputStream.toByteArray().length / 1024 > 100; i -= 10) {
            localByteArrayOutputStream.reset();
            paramBitmap.compress(CompressFormat.JPEG, i, localByteArrayOutputStream);
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(localByteArrayOutputStream.toByteArray()), null, null);
    }


    public static void compressImageUrlResultPath(Context paramContext, final String paramString, final BaseCallBack paramBaseCallBack) {
        new Thread(() -> {
            Bitmap localBitmapt = null;
            try {
                localBitmapt = Glide.with(paramContext).asBitmap().load(paramString).submit().get();
            } catch (Exception localException) {
                localException.printStackTrace();
                paramBaseCallBack.onFail(-1, "Exception");
            }
            if (localBitmapt != null) {
                String path = FileUtils.saveImageToGallery(ImageUtils.compressImage(localBitmapt));
                if (!TextUtils.isEmpty(path)) {
                    paramBaseCallBack.onSuccess(localBitmapt, "");
                    return;
                } else {
                    paramBaseCallBack.onFail(-1, "shareQQLocalPath is null");
                }
            } else {
                paramBaseCallBack.onFail(-1, "bitmap is null");
            }

        }).start();
    }

    public static Bitmap convertToBlackWhite(Bitmap paramBitmap) {
        int m = paramBitmap.getWidth();
        int k = paramBitmap.getHeight();
        int[] arrayOfInt = new int[m * k];
        paramBitmap.getPixels(arrayOfInt, 0, m, 0, 0, m, k);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                int n = m * i + j;
                int i1 = arrayOfInt[n];
                i1 = (int) (((0xFF0000 & i1) >> 16) * 0.3D + ((0xFF00 & i1) >> 8) * 0.59D + (i1 & 0xFF) * 0.11D);
                arrayOfInt[n] = (i1 | i1 << 16 | 0xFF000000 | i1 << 8);
            }
        }
        paramBitmap = Bitmap.createBitmap(m, k, Config.RGB_565);
        paramBitmap.setPixels(arrayOfInt, 0, m, 0, 0, m, k);
        return ThumbnailUtils.extractThumbnail(paramBitmap, 320, 480);
    }

    public static File createTempFile() {
        File localFile = new File(MyApp.getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES), "_verify.jpeg");
        try {
            if (!localFile.exists()) {
                localFile.createNewFile();
            }
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return localFile;
    }

    public static Bitmap getBitmapFormUrl(Context paramContext, String paramString) throws IOException {
        InputStream inputStream = paramContext.getContentResolver().openInputStream(Uri.parse(paramString));
        Options localOptions = new Options();
        localOptions.inJustDecodeBounds = true;
        localOptions.inDither = true;
        localOptions.inPreferredConfig = Config.ARGB_8888;


        int j = localOptions.outWidth;
        int i = localOptions.outHeight;
        int ratio = 1;
        if ((j != -1) && (i != -1)) {
            float f;
            if (j > i) {
                f = j;
                if (f > 480.0F) {
                    ratio = (int) (f / 480.0F);
                }
            }
            if (j < i) {
                f = i;
                if (f > 800.0F) {
                    ratio = (int) (f / 800.0F);
                }
            }
            localOptions.inSampleSize = ratio;
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, localOptions);
            inputStream.close();
            return compressImage(bitmap);
        }
        return null;
    }


    public static Bitmap getImage(String paramString) {
        Options localOptions = new Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        int width = localOptions.outWidth;
        int height = localOptions.outHeight;
        float f = 1f;
        if ((width > height) && (width > 720.0F)) {
            f = width / 720.0F;
        } else if ((width < height) && (height > 1280.0F)) {
            f = height / 1280F;
        }

        localOptions.inSampleSize = (int) f;
        return compressImage(BitmapFactory.decodeFile(paramString, localOptions));
    }


    public static void load(Context paramContext, String paramString, ImageView paramImageView) {
        if (Build.VERSION.SDK_INT >= 17) {
            Glide.with(paramContext).load(paramString).transition(
                    DrawableTransitionOptions
                            .withCrossFade())
                    .skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.DATA).error(R.drawable.ic_alert_error).into(paramImageView);
        }
    }


    public static void loadAll(Context paramContext, String paramString, ImageView paramImageView) {
        Glide.with(paramContext).load(paramString).transition(
                DrawableTransitionOptions
                        .withCrossFade())
                .skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).error(R.drawable.ic_alert_error).into(paramImageView);
    }
}


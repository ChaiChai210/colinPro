package com.chai.colin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

import com.chai.colin.R;

import java.util.HashMap;
import java.util.Objects;

public class SoundPoolUtil {
    static Context mContext;
    public static int mStreamId;
    public static int mStreamId2;
    private static SoundPool soundPool;
    private static SoundPool soundPool2;
    private static HashMap<Integer, Integer> soundPoolMap = new HashMap<>();
    private static SoundPoolUtil soundPoolUtil;

    @SuppressLint({"UseSparseArrays"})
    private SoundPoolUtil(Context context) {
        mContext = context;
        soundPool = new SoundPool(1,  AudioManager.STREAM_MUSIC, 0);
        soundPool2 = new SoundPool(1,  AudioManager.STREAM_MUSIC, 0);
        soundPoolMap.put(1, R.raw.button_tap);
        soundPoolMap.put(2, R.raw.music_acitivityviewcontroller);
        soundPoolMap.put(3, R.raw.music_cgpromotioncontroller);
        soundPoolMap.put(4, soundPool2.load(context, R.raw.music_game, 1));
        soundPoolMap.put(5, R.raw.music_kyhomeviewcontroller);
        soundPoolMap.put(6, R.raw.music_kysafedepositboxviewcontroller);
        soundPoolMap.put(7, R.raw.music_kywithdrawviewcontroller);
        soundPoolMap.put(8, R.raw.music_messageviewcontroller);
        soundPoolMap.put(9, R.raw.music_personcentercontroller);
        soundPoolMap.put(10, R.raw.music_washcodealertviewcontroller);
        soundPoolMap.put(11, R.raw.music_webviewcontroller);
        soundPoolMap.put(12, R.raw.music_customerservicecontroller);
        soundPoolMap.put(13, R.raw.music_kyrechargeviewcontroller);
    }

    public static void autoPause() {
        soundPool.autoPause();
    }

    public static SoundPoolUtil getInstance(Context paramContext) {
        if (soundPoolUtil == null) {
            soundPoolUtil = new SoundPoolUtil(paramContext);
        }
        return soundPoolUtil;
    }

    public static void pause(int paramInt) {
        soundPool2.pause(paramInt);
    }

    public static void play(int key, final float volume) {
        if (soundPoolMap.containsKey(key)) {
            Integer resId = soundPoolMap.get(key);
            mStreamId = soundPool.load(mContext, Objects.requireNonNull(resId), 3);
            soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                public void onLoadComplete(SoundPool paramAnonymousSoundPool, int sampleId,
                                           int status) {
                    paramAnonymousSoundPool.play(mStreamId, volume, volume, 0, 0, 1.0F);
                }
            });
        }
    }


    public static void playAlways(float f) {
        soundPool2.play(soundPoolMap.get(4), f, f, 0, -1, 1.0F);
//        StringBuilder stringbuilder = new StringBuilder();
//        stringbuilder.append("stream id==>");
//        stringbuilder.append(mStreamId);
//        Log.d("lll", stringbuilder.toString());
    }

    public static void release() {
        soundPool.release();
    }

    public static void resume(int paramInt) {
        soundPool2.resume(paramInt);
    }

    public static void setVolume(int paramInt, float paramFloat) {
        soundPool2.setVolume(paramInt, paramFloat, paramFloat);
    }

    public static void setVolume2(int paramInt, float paramFloat) {
        soundPool.setVolume(paramInt, paramFloat, paramFloat);
    }

    public static void stop(int paramInt) {
        soundPool2.stop(paramInt);
    }
}


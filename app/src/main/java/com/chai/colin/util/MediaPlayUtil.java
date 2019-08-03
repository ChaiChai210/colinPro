package com.chai.colin.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

public class MediaPlayUtil {

    static Context mContext;
    private static boolean isPause = false;
    private static MediaPlayer mPlayer;
    private static MediaPlayUtil mediaPlayUtil;

    public MediaPlayUtil(Context paramContext) {
        mContext = paramContext;
    }

    public static MediaPlayUtil getInstance(Context paramContext) {
        if (mediaPlayUtil == null) {
            mediaPlayUtil = new MediaPlayUtil(paramContext);
        }
        return mediaPlayUtil;
    }

    public static void pause() {
        MediaPlayer localMediaPlayer = mPlayer;
        if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
            mPlayer.pause();
            isPause = true;
        }
    }

    public static void playSound(int paramInt, MediaPlayer.OnCompletionListener paramOnCompletionListener) {
        Object localObject = mPlayer;
        if (localObject == null) {
            mPlayer = MediaPlayer.create(mContext, paramInt);
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.setOnCompletionListener(paramOnCompletionListener);
            mPlayer.setLooping(true);
            mPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2) {
                    mPlayer.reset();
                    return false;
                }
            });

            mPlayer.start();
            isPause = false;
        } else {
            mPlayer.start();
        }
    }

    public static void release() {
        MediaPlayer localMediaPlayer = mPlayer;
        if (localMediaPlayer != null) {
            localMediaPlayer.release();
            mPlayer = null;
        }
    }

    public static void resume() {
        MediaPlayer localMediaPlayer = mPlayer;
        if ((localMediaPlayer != null) && (isPause)) {
            localMediaPlayer.start();
            isPause = false;
        }
    }

    public static void setVolume(float paramFloat) {
        MediaPlayer localMediaPlayer = mPlayer;
        if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
            localMediaPlayer.setVolume(paramFloat, paramFloat);
        }
    }

    public static void stop() {
        MediaPlayer localMediaPlayer = mPlayer;
        if (localMediaPlayer != null) {
            localMediaPlayer.stop();
            mPlayer = null;
        }
    }
}



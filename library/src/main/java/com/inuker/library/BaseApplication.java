package com.inuker.library;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by liwentian on 17/8/16.
 */

public class BaseApplication extends Application {

    private static BaseApplication sInstance;

    private static int mScreenWidth, mScreenHeight;

    private static float mDensity;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public final void onCreate() {
        super.onCreate();

        sInstance = this;

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();

        mScreenWidth = Math.max(width, height);
        mScreenHeight = Math.min(width, height);

        mDensity = getResources().getDisplayMetrics().density;
    }

    public static int getScreenWidth() {
        return mScreenWidth;
    }

    public static int getScreenHeight() {
        return mScreenHeight;
    }
}
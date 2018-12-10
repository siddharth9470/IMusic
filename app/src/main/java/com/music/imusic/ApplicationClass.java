package com.music.imusic;

import android.app.Application;
import android.content.Context;

/**
 * Created by Siddharth Singh on 1/11/2017.
 */

public class ApplicationClass extends Application {

    private static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationClass.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ApplicationClass.context;
    }
}

package com.lp.testpagingandroom;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.lp.testpagingandroom.db.AbstractRoomDatabase;
import com.lp.testpagingandroom.db.RoomDatabaseImpl;

/**
 * @Author: liupan
 * @Date: 2020/11/23
 */
public class CustomApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Log.e("network--available", "  " + NetworkUtil.isNetworkConnected());
        new Thread(new Runnable() {
            @Override
            public void run() {
                RoomDatabaseImpl.getInstance();
            }
        }).start();
    }

    public static Context getContext() {
        return mContext;
    }
}

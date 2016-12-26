package com.yoflying.drivingschool;

import android.app.Application;
import android.content.Context;

/**
 * Created by yaojiulong on 2016/12/26.
 */

public class DriverApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();

    }
    //返回
    public static Context getContextObject(){
        return mContext;
    }
}

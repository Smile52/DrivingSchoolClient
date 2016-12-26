package com.yoflying.drivingschool.modules.wecome;

import android.os.Handler;

import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.modules.wecome.IWecomeView;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

/**
 * Created by yaojiulong on 2016/12/26.
 */

public class WecomePresenter extends BasePresenter<IWecomeView> {
    private IWecomeView mWecomeView;
    private boolean mIsNew=true;

    public WecomePresenter(IWecomeView wecomeView) {
        this.mWecomeView=wecomeView;
    }

    public void checkData(){
        String token= UtilSharedPreferences.getStringData(DriverApplication.getContextObject(), Config.KEY_TOKEN);
        if (token.equals("")){
            mIsNew=true;
        }else {
            mIsNew=false;
        }
        delayed();
    }

    private void delayed(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mIsNew){
                    mWecomeView.toLoginActivity();
                }else
                    mWecomeView.toAdminActivity();
            }
        },1000);
    }


}

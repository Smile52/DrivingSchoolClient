package com.yoflying.drivingschool.modules.admin;

import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

/**
 * Created by yaojiulong on 2016/12/28.
 */

public class AdminPresenter extends BasePresenter<IAdminView>{
    private IAdminView mAdminView;

    public AdminPresenter(IAdminView mAdminView) {
        this.mAdminView=mAdminView;
        attachView(mAdminView);
        showSomeInfo();

    }

    private void showSomeInfo(){
        mAdminView.showUserName(UtilSharedPreferences.getStringData
                (DriverApplication.getContextObject(), Config.KEY_USERNAME));
        mAdminView.showUserType(UtilSharedPreferences.getStringData
                (DriverApplication.getContextObject(),Config.KEY_USER_TYPE));
    }

}

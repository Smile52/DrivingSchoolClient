package com.yoflying.drivingschool.home;

import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

/**
 * Created by yaojiulong on 2016/12/28.
 */

public class HomePresenter extends BasePresenter<IHomeView>{
    private IHomeView mAdminView;

    public HomePresenter(IHomeView adminView) {
        this.mAdminView=adminView;
        attachView(mAdminView);
        switchFragment();
        showSomeInfo();


    }

    private void switchFragment() {
        String userType=UtilSharedPreferences.getStringData(DriverApplication.getContextObject(),Config.KEY_USER_TYPE);
        if (userType.equals(DriverApplication.getContextObject().getResources().getString(R.string.user_admin))){
            mAdminView.showAdminFragment();
        }else if (userType.equals(DriverApplication.getContextObject().getResources().getString(R.string.user_teacher))){
            mAdminView.showTeacherFragment();
        }else if (userType.equals(DriverApplication.getContextObject().getResources().getString(R.string.user_student))){
            mAdminView.showStudentFragment();
        }
    }

    private void showSomeInfo(){
        mAdminView.showUserName(UtilSharedPreferences.getStringData
                (DriverApplication.getContextObject(), Config.KEY_USERNAME));
        mAdminView.showUserType(UtilSharedPreferences.getStringData
                (DriverApplication.getContextObject(),Config.KEY_USER_TYPE));
    }

}

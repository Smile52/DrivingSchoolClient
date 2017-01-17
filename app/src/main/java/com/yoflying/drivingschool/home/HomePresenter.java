package com.yoflying.drivingschool.home;

import android.content.Context;
import android.util.Log;

import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.bean.Admin;
import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.Person;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.retrofit.ApiCallBack;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaojiulong on 2016/12/28.
 */

public class HomePresenter extends BasePresenter<IHomeView>{
    private IHomeView mHomeView;
    private String mToken;
    private Context mContext;
    public HomePresenter(IHomeView adminView) {
        this.mHomeView=adminView;
        attachView(mHomeView);
        mContext=DriverApplication.getContextObject();
        mToken= UtilSharedPreferences.getStringData(DriverApplication.getContextObject(), Config.KEY_TOKEN);
        switchFragment();
        showSomeInfo();


    }

    private void switchFragment() {
        String userType=UtilSharedPreferences.getStringData(DriverApplication.getContextObject(),Config.KEY_USER_TYPE);
        if (userType.equals(DriverApplication.getContextObject().getResources().getString(R.string.user_admin))){
            mHomeView.showAdminFragment();
            getAdminInfoFromServer(mToken);
        }else if (userType.equals(DriverApplication.getContextObject().getResources().getString(R.string.user_teacher))){
            mHomeView.showTeacherFragment();
            getUserInfoFromServer(mToken);
        }else if (userType.equals(DriverApplication.getContextObject().getResources().getString(R.string.user_student))){
            mHomeView.showStudentFragment();
            getUserInfoFromServer(mToken);
        }
    }

    private void showSomeInfo(){
      /*  mHomeView.showUserName(UtilSharedPreferences.getStringData
                (DriverApplication.getContextObject(), Config.KEY_USERNAME));
        mHomeView.showUserType(UtilSharedPreferences.getStringData
                (DriverApplication.getContextObject(),Config.KEY_USER_TYPE));*/
    }

    /**
     * 获取学员或者教练的信息
     * @param token
     */
    private void getUserInfoFromServer(String token){
        ApiCallBack<HttpsResult<Person>> subscriber=new ApiCallBack<HttpsResult<Person>>() {
            @Override
            public void onSuccess(HttpsResult<Person> model) {
                mHomeView.showUserName(model.getData().getName());
               // Log.e("dandy","获取用户信息 "+model.toString());
                if (model.getData().getDiscern()==1){
                    mHomeView.showUserType(mContext.getResources().getString(R.string.user_teacher));
                }else if (model.getData().getDiscern()==2){
                    mHomeView.showUserType(mContext.getResources().getString(R.string.user_student));
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.e("dandy","请求失败 "+msg);
            }

            @Override
            public void onFinish() {

            }
        };


        addSubscription(mApiStore.getUserInfo(),subscriber);
    }

    /**
     * 获取管理员信息
     * @param token
     */
    private void getAdminInfoFromServer(String token){
        ApiCallBack<HttpsResult<Admin>> subscriber=new ApiCallBack<HttpsResult<Admin>>() {
            @Override
            public void onSuccess(HttpsResult<Admin> model) {
                mHomeView.showUserName(model.getData().getUsername());
                mHomeView.showUserType(mContext.getResources().getString(R.string.user_admin));
                Log.e("dandy","获取管理员信息成功");
            }

            @Override
            public void onFailure(String msg) {
                Log.e("dandy","获取管理员信息失败 "+msg);
            }

            @Override
            public void onFinish() {

            }
        };
        addSubscription(mApiStore.getAdminInfo(),subscriber);

    }

}

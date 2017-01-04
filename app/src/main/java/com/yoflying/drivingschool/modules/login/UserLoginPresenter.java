package com.yoflying.drivingschool.modules.login;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.yoflying.drivingschool.DriverApplication;
import com.yoflying.drivingschool.R;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.Person;
import com.yoflying.drivingschool.bean.User;
import com.yoflying.drivingschool.config.Config;
import com.yoflying.drivingschool.modules.login.IUserLoginView;
import com.yoflying.drivingschool.retrofit.ApiCallBack;
import com.yoflying.drivingschool.utils.UtilSharedPreferences;

import okhttp3.RequestBody;
import rx.Subscriber;

/**用户登录控制器，负责view与model交互
 * Created by yaojiulong on 2016/12/21.
 */

public class UserLoginPresenter extends BasePresenter<IUserLoginView>{
    private int type;
    private IUserLoginView mUserLoginView;
    private Context mContext;


    public UserLoginPresenter( IUserLoginView mUserLoginView) {

        this.mUserLoginView = mUserLoginView;
        attachView(mUserLoginView);
        mContext=DriverApplication.getContextObject();
    }

    public void login(){
        String userName=mUserLoginView.getUseName();
        String pwd=mUserLoginView.getPassword();
        type=mUserLoginView.getUserType();
        Log.e("dandy","type  "+type);
        if (userName==null||userName.equals("")||pwd==null||pwd.equals("")){
            mUserLoginView.userOrPwdIsNull();
            return;
        }
        mUserLoginView.showDialog();
        ApiCallBack<HttpsResult<Person>> subscriber1=new ApiCallBack<HttpsResult<Person>>() {
            @Override
            public void onSuccess(HttpsResult<Person> model) {
                Log.e("dandy"," "+model.toString());
                mUserLoginView.cancelDialog();
                if (model.getStatus()==0){
                    mUserLoginView.toMainActivity();
                    savaUserToken(model);
                }else {
                    mUserLoginView.toastMeassager(model.getMessage());
                }
            }

            @Override
            public void onFailure(String msg) {
                //Log.e("dandy","error "+msg);
                mUserLoginView.cancelDialog();
            }

            @Override
            public void onFinish() {

            }
        };
        User user=new User();
        user.setCategory(type);
        user.setUsername(userName);
        user.setPassword(pwd);
        Gson gson=new Gson();
        String route= gson.toJson(user);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        addSubscription(mApiStore.login(body),subscriber1);

    }

    private void savaUserToken(HttpsResult<Person> person){
        Log.e("dandy","person "+person);
        UtilSharedPreferences.saveStringData(mContext, Config.KEY_TOKEN,person.getMessage());
        UtilSharedPreferences.saveStringData(mContext,Config.KEY_USERNAME,person.getData().getUsername());
        if (person.getData().getDiscern()==1){
            UtilSharedPreferences.saveStringData(mContext,Config.KEY_USER_TYPE,mContext.getResources().getString(R.string.user_teacher));
        }else {
            UtilSharedPreferences.saveStringData(mContext,Config.KEY_USER_TYPE,mContext.getResources().getString(R.string.user_student));
        }
        if (type==1){
            UtilSharedPreferences.saveStringData(mContext,Config.KEY_USER_TYPE,mContext.getResources().getString(R.string.user_admin));
        }

    }

    /**
     * 注销，取消订阅
     */
    public void destory(){
        detachView();
    }
}

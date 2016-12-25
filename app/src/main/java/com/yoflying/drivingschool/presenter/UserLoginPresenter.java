package com.yoflying.drivingschool.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.yoflying.drivingschool.base.BasePresenter;
import com.yoflying.drivingschool.bean.HttpsResult;
import com.yoflying.drivingschool.bean.Person;
import com.yoflying.drivingschool.bean.Person1;
import com.yoflying.drivingschool.bean.User;
import com.yoflying.drivingschool.login.IUserLoginView;

import okhttp3.RequestBody;
import rx.Subscriber;

/**用户登录控制器，负责view与model交互
 * Created by yaojiulong on 2016/12/21.
 */

public class UserLoginPresenter extends BasePresenter{

    private IUserLoginView mUserLoginView;


    public UserLoginPresenter( IUserLoginView mUserLoginView) {

        this.mUserLoginView = mUserLoginView;
        attachView(mUserLoginView);
    }

    public void login(){
        String userName=mUserLoginView.getUseName();
        String pwd=mUserLoginView.getPassword();
        int type=mUserLoginView.getUserType();
        Log.e("dandy","type  "+type);
        if (userName==null||userName.equals("")||pwd==null||pwd.equals("")){
            mUserLoginView.userOrPwdIsNull();
            return;
        }
        mUserLoginView.showDialog();
        Subscriber<HttpsResult<Person1>> subscriber=new Subscriber<HttpsResult<Person1>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("dandy","error "+e.toString());
                mUserLoginView.cancelDialog();
            }

            @Override
            public void onNext(HttpsResult<Person1> person) {
                Log.e("dandy"," "+person.toString());
                mUserLoginView.cancelDialog();
                if (person.getStatus()==0){
                    mUserLoginView.toMainActivity();
                }else {
                    mUserLoginView.toastMeassager(person.getMessage());
                }

            }
        };
        User user=new User();
        user.setCategory(type);
        user.setUsername(userName);
        user.setPassword(pwd);
        Gson gson=new Gson();
        String route= gson.toJson(user);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        addSubscription(mApiStore.login(body),subscriber);

    }

    /**
     * 注销，取消订阅
     */
    public void destory(){
        detachView();
    }
}

package com.yoflying.drivingschool.login;

import com.yoflying.drivingschool.base.BaseView;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public interface IUserLoginView extends BaseView{
    String getUseName();
    String getPassword();

    void toMainActivity();
    void showFailedError();
    int getUserType();
    void userOrPwdIsNull();


}

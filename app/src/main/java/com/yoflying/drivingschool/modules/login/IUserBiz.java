package com.yoflying.drivingschool.modules.login;

import com.yoflying.drivingschool.modules.login.OnLoginListener;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public interface IUserBiz {
    void login(String userNum,String password,OnLoginListener loginListener);
}

package com.yoflying.drivingschool.login;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public interface IUserBiz {
    void login(String userNum,String password,OnLoginListener loginListener);
}

package com.yoflying.drivingschool.modules.login;

/**
 * Created by yaojiulong on 2016/12/21.
 */

public class UserLoginBiz implements IUserBiz {
    @Override
    public void login(final String userNum, String password, final OnLoginListener loginListener) {


        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }
             /*   User user = new User();
                user.setUserName(userNum);
                loginListener.loginSuccess(user);*/
            }
        }.start();
    }
}

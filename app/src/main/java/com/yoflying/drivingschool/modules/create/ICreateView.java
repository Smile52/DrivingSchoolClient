package com.yoflying.drivingschool.modules.create;

/**
 * Created by yaojiulong on 2016/12/26.
 */

public interface ICreateView {
    String getUserName();
    String getIDnum();
    int getSex();
    int getUserType();
    String getPassword();
    String getPhone();
    String getWechat();
    int getCourse();

    void toastMeassage(String msg);

}

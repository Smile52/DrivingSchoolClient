package com.yoflying.drivingschool.home;

/**
 * Created by yaojiulong on 2016/12/26.
 */

public interface IHomeView {
    void showUserName(String name);
    void showUserType(String type);

    void showAdminFragment();
    void showTeacherFragment();
    void showStudentFragment();
}

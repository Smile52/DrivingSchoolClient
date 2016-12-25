package com.yoflying.drivingschool.login;

import com.yoflying.drivingschool.bean.User;

/**登录事件
 * Created by yaojiulong on 2016/12/21.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void loginFailed();
}

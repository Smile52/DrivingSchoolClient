package com.yoflying.drivingschool.bean;

/**用户类
 * Created by yaojiulong on 2016/12/20.
 */

public class User {


    /**
     * category : 2
     * username : 1
     * password : admin
     */

    private int category;
    private String username;
    private String password;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

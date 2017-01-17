package com.yoflying.drivingschool.bean;

/**管理员信息类
 * Created by yaojiulong on 2017/1/4.
 */

public class Admin {


    /**
     * id : 1
     * username : admin
     * password : admin
     * dsId : 1
     * identityCard : 130229199307063617
     * dsPhone : 13113656554
     * status : 1
     * createTime : 1481812879000
     * modifyTime : 1481812879000
     */

    private int id;
    private String username;
    private String password;
    private int dsId;
    private String identityCard;
    private String dsPhone;
    private int status;
    private long createTime;
    private long modifyTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDsId() {
        return dsId;
    }

    public void setDsId(int dsId) {
        this.dsId = dsId;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getDsPhone() {
        return dsPhone;
    }

    public void setDsPhone(String dsPhone) {
        this.dsPhone = dsPhone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
}

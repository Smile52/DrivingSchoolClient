package com.yoflying.drivingschool.bean;

/**
 * Created by yaojiulong on 2016/12/23.
 */

public class Person1 {
    private int id;
    private String username;
    private String password;
    private int dsId;
    private String name;
    private int sex;
    private String identityCard;
    private int discern;
    private String phone;
    private String wechat;
    private String address;
    private int course;
    private int coachId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public int getDiscern() {
        return discern;
    }

    public void setDiscern(int discern) {
        this.discern = discern;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
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

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dsId=" + dsId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", identityCard='" + identityCard + '\'' +
                ", discern=" + discern +
                ", phone='" + phone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", address='" + address + '\'' +
                ", course=" + course +
                ", coachId=" + coachId +
                ", status=" + status +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}

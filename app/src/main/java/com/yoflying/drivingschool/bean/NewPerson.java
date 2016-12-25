package com.yoflying.drivingschool.bean;

/**注册教练或者学员实体类
 * Created by yaojiulong on 2016/12/22.
 */

public class NewPerson {
    /**
     * 用户名(昵称) 可选
     */
    private String userName;
    private String password;
    /**
     * 真实姓名
     */
    private String name;
    //可选
    private int sex;
    /**
     * 身份证号码
     */
    private String identityCard;

    /**
     * 角色类别 教练或者学员
     */
    private int discern;

    private String phone;
    //可选b
    private String wechat;
    //可选
    private String address;
    //可选
    private int course;
    private int status;

    private NewPerson(Builder builder){
        this.userName=builder.userNmae;
        this.password=builder.password;
        this.sex=builder.sex;
        this.identityCard=builder.identityCard;
        this.discern=builder.discern;
        this.phone=builder.phone;
        this.wechat=builder.wechat;
        this.address=builder.address;
        this.status=builder.status;
    }

    public static class Builder{
        private String userNmae;
        private String password;
        private String name;
        private int sex;
        private String identityCard;
        private int discern;
        private String phone;
        private String wechat;
        private String address;
        private int course;
        private int status;

        public Builder(String password,String name,String identityCard,int discern,String phone,int status){
            this.password=password;
            this.name=name;
            this.identityCard=identityCard;
            this.discern=discern;
            this.phone=phone;
            this.status=status;

        }

        public Builder userName(String userName){
            this.userNmae=userName;
            return this;
        }

        public Builder sex(int sex){
            this.sex=sex;
            return this;
        }

        public Builder wechat(String wechat){
            this.wechat=wechat;
            return  this;
        }

        public Builder address(String address){
            this.address=address;
            return this;
        }

        public Builder course(int course){
            this.course=course;
            return this;
        }

        public NewPerson build(){
            return new NewPerson(this);
        }

    }


}

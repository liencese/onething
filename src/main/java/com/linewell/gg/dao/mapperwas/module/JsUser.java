package com.linewell.gg.dao.mapperwas.module;

/**
 *  江苏政务服务网 用户
 *
 * @author lenovo
 * @version 1.0
 */
public class JsUser {

    private String loginName;//江苏政务服务网 登录名称
    private String name;//用户名
    private String mobile;//手机号
    private String userType;//用户类型
    private String idcardNum;//身份证
    private String coruserName;//法人姓名
    private String corusercardId;//法人身份证

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public String getCoruserName() {
        return coruserName;
    }

    public void setCoruserName(String coruserName) {
        this.coruserName = coruserName;
    }

    public String getCorusercardId() {
        return corusercardId;
    }

    public void setCorusercardId(String corusercardId) {
        this.corusercardId = corusercardId;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", userType='" + userType + '\'' +
                ", idcardNum='" + idcardNum + '\'' +
                ", coruserName='" + coruserName + '\'' +
                ", corusercardId='" + corusercardId + '\'' +
                '}';
    }
}

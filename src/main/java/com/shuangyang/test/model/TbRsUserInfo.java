package com.shuangyang.test.model;

import java.util.Date;

public class TbRsUserInfo {
    private String sid;

    private String netSid;

    private String username;

    private String email;

    private String password;

    private String mobile;

    private Integer chatType;

    private String chatNbr;

    private String realname;

    private String address;

    private Integer national;

    private String oConType1;

    private String oConNbr1;

    private String oConType2;

    private String oConNbr2;

    private Date createDate;

    private Date updateDate;

    private Integer loginTimes;

    private Integer province;

    private Integer city;

    private String valicode;

    private Integer status;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getNetSid() {
        return netSid;
    }

    public void setNetSid(String netSid) {
        this.netSid = netSid == null ? null : netSid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getChatType() {
        return chatType;
    }

    public void setChatType(Integer chatType) {
        this.chatType = chatType;
    }

    public String getChatNbr() {
        return chatNbr;
    }

    public void setChatNbr(String chatNbr) {
        this.chatNbr = chatNbr == null ? null : chatNbr.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public String getoConType1() {
        return oConType1;
    }

    public void setoConType1(String oConType1) {
        this.oConType1 = oConType1 == null ? null : oConType1.trim();
    }

    public String getoConNbr1() {
        return oConNbr1;
    }

    public void setoConNbr1(String oConNbr1) {
        this.oConNbr1 = oConNbr1 == null ? null : oConNbr1.trim();
    }

    public String getoConType2() {
        return oConType2;
    }

    public void setoConType2(String oConType2) {
        this.oConType2 = oConType2 == null ? null : oConType2.trim();
    }

    public String getoConNbr2() {
        return oConNbr2;
    }

    public void setoConNbr2(String oConNbr2) {
        this.oConNbr2 = oConNbr2 == null ? null : oConNbr2.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getValicode() {
        return valicode;
    }

    public void setValicode(String valicode) {
        this.valicode = valicode == null ? null : valicode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
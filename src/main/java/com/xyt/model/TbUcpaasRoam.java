package com.xyt.model;

import java.util.Date;

public class TbUcpaasRoam {
    private Integer roamId;

    private String clientNumber;

    private Integer expDays;

    private Date createDate;

    private Date updateDate;

    private Date expDate;

    private Byte callMode;

    private String phone;

    private String sid;

    private String appSid;

    private Boolean status;

    private String forwardPhone;

    private Date nextDate;

    public Integer getRoamId() {
        return roamId;
    }

    public void setRoamId(Integer roamId) {
        this.roamId = roamId;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber == null ? null : clientNumber.trim();
    }

    public Integer getExpDays() {
        return expDays;
    }

    public void setExpDays(Integer expDays) {
        this.expDays = expDays;
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

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Byte getCallMode() {
        return callMode;
    }

    public void setCallMode(Byte callMode) {
        this.callMode = callMode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getAppSid() {
        return appSid;
    }

    public void setAppSid(String appSid) {
        this.appSid = appSid == null ? null : appSid.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getForwardPhone() {
        return forwardPhone;
    }

    public void setForwardPhone(String forwardPhone) {
        this.forwardPhone = forwardPhone == null ? null : forwardPhone.trim();
    }

    public Date getNextDate() {
        return nextDate;
    }

    public void setNextDate(Date nextDate) {
        this.nextDate = nextDate;
    }
}
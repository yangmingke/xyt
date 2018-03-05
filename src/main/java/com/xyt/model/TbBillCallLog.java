package com.xyt.model;

import java.util.Date;

public class TbBillCallLog {
    private Integer callId;

    private Integer sessionId;

    private String brandId;

    private String fromNumber;

    private String toNumber;

    private String rawFromNumber;

    private String rawToNumber;

    private String fromIp;

    private String toIp;

    private Date startTime;

    private Date endTime;

    private String timeType;

    private String callType;

    private Integer callTime;

    private Integer pkgCallTime;

    private Integer billingTime;

    private Integer gateId;

    private String gateName;

    private String gateRate;

    private Integer gateDiscount;

    private Integer gateUnits;

    private Long gateFee;

    private Integer agentId;

    private String agentName;

    private String agentRate;

    private Integer agentDiscount;

    private Integer agentUnits;

    private Long agentFee;

    private Integer fieldId;

    private String fieldName;

    private String fieldRate;

    private Integer fieldDiscount;

    private Integer fieldUnits;

    private Long fieldFee;

    private Integer userId;

    private String longName;

    private Date callDate;

    private Integer callYear;

    private Integer callMonth;

    private Integer callDay;

    private Integer callHour;

    private Integer callWeek;

    private String callSessionId;

    private Byte showType;

    private Integer hungupReason;

    private Integer delay;

    private Integer continued;

    private Byte rest;

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getFromNumber() {
        return fromNumber;
    }

    public void setFromNumber(String fromNumber) {
        this.fromNumber = fromNumber == null ? null : fromNumber.trim();
    }

    public String getToNumber() {
        return toNumber;
    }

    public void setToNumber(String toNumber) {
        this.toNumber = toNumber == null ? null : toNumber.trim();
    }

    public String getRawFromNumber() {
        return rawFromNumber;
    }

    public void setRawFromNumber(String rawFromNumber) {
        this.rawFromNumber = rawFromNumber == null ? null : rawFromNumber.trim();
    }

    public String getRawToNumber() {
        return rawToNumber;
    }

    public void setRawToNumber(String rawToNumber) {
        this.rawToNumber = rawToNumber == null ? null : rawToNumber.trim();
    }

    public String getFromIp() {
        return fromIp;
    }

    public void setFromIp(String fromIp) {
        this.fromIp = fromIp == null ? null : fromIp.trim();
    }

    public String getToIp() {
        return toIp;
    }

    public void setToIp(String toIp) {
        this.toIp = toIp == null ? null : toIp.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType == null ? null : timeType.trim();
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType == null ? null : callType.trim();
    }

    public Integer getCallTime() {
        return callTime;
    }

    public void setCallTime(Integer callTime) {
        this.callTime = callTime;
    }

    public Integer getPkgCallTime() {
        return pkgCallTime;
    }

    public void setPkgCallTime(Integer pkgCallTime) {
        this.pkgCallTime = pkgCallTime;
    }

    public Integer getBillingTime() {
        return billingTime;
    }

    public void setBillingTime(Integer billingTime) {
        this.billingTime = billingTime;
    }

    public Integer getGateId() {
        return gateId;
    }

    public void setGateId(Integer gateId) {
        this.gateId = gateId;
    }

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName == null ? null : gateName.trim();
    }

    public String getGateRate() {
        return gateRate;
    }

    public void setGateRate(String gateRate) {
        this.gateRate = gateRate == null ? null : gateRate.trim();
    }

    public Integer getGateDiscount() {
        return gateDiscount;
    }

    public void setGateDiscount(Integer gateDiscount) {
        this.gateDiscount = gateDiscount;
    }

    public Integer getGateUnits() {
        return gateUnits;
    }

    public void setGateUnits(Integer gateUnits) {
        this.gateUnits = gateUnits;
    }

    public Long getGateFee() {
        return gateFee;
    }

    public void setGateFee(Long gateFee) {
        this.gateFee = gateFee;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentRate() {
        return agentRate;
    }

    public void setAgentRate(String agentRate) {
        this.agentRate = agentRate == null ? null : agentRate.trim();
    }

    public Integer getAgentDiscount() {
        return agentDiscount;
    }

    public void setAgentDiscount(Integer agentDiscount) {
        this.agentDiscount = agentDiscount;
    }

    public Integer getAgentUnits() {
        return agentUnits;
    }

    public void setAgentUnits(Integer agentUnits) {
        this.agentUnits = agentUnits;
    }

    public Long getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(Long agentFee) {
        this.agentFee = agentFee;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldRate() {
        return fieldRate;
    }

    public void setFieldRate(String fieldRate) {
        this.fieldRate = fieldRate == null ? null : fieldRate.trim();
    }

    public Integer getFieldDiscount() {
        return fieldDiscount;
    }

    public void setFieldDiscount(Integer fieldDiscount) {
        this.fieldDiscount = fieldDiscount;
    }

    public Integer getFieldUnits() {
        return fieldUnits;
    }

    public void setFieldUnits(Integer fieldUnits) {
        this.fieldUnits = fieldUnits;
    }

    public Long getFieldFee() {
        return fieldFee;
    }

    public void setFieldFee(Long fieldFee) {
        this.fieldFee = fieldFee;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName == null ? null : longName.trim();
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Integer getCallYear() {
        return callYear;
    }

    public void setCallYear(Integer callYear) {
        this.callYear = callYear;
    }

    public Integer getCallMonth() {
        return callMonth;
    }

    public void setCallMonth(Integer callMonth) {
        this.callMonth = callMonth;
    }

    public Integer getCallDay() {
        return callDay;
    }

    public void setCallDay(Integer callDay) {
        this.callDay = callDay;
    }

    public Integer getCallHour() {
        return callHour;
    }

    public void setCallHour(Integer callHour) {
        this.callHour = callHour;
    }

    public Integer getCallWeek() {
        return callWeek;
    }

    public void setCallWeek(Integer callWeek) {
        this.callWeek = callWeek;
    }

    public String getCallSessionId() {
        return callSessionId;
    }

    public void setCallSessionId(String callSessionId) {
        this.callSessionId = callSessionId == null ? null : callSessionId.trim();
    }

    public Byte getShowType() {
        return showType;
    }

    public void setShowType(Byte showType) {
        this.showType = showType;
    }

    public Integer getHungupReason() {
        return hungupReason;
    }

    public void setHungupReason(Integer hungupReason) {
        this.hungupReason = hungupReason;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public Integer getContinued() {
        return continued;
    }

    public void setContinued(Integer continued) {
        this.continued = continued;
    }

    public Byte getRest() {
        return rest;
    }

    public void setRest(Byte rest) {
        this.rest = rest;
    }
}
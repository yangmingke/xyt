package com.xyt.model;

import java.util.Date;

public class TbUcpaasUser {
    private String sid;

    private String token;

    private String username;

    private String email;

    private String password;

    private String userType;

    private String status;

    private String oauthStatus;

    private String mobile;

    private Integer province;

    private Integer city;

    private String address;

    private String realname;

    private String idType;

    private String idNbr;

    private String orgId;

    private String legalPerson;

    private String companyNbr;

    private String webSite;

    private Date createDate;

    private Date updateDate;

    private Integer loginTimes;

    private String revisability;

    private String randomNbr;

    private Date oauthDate;

    private Byte isContract;

    private Integer channelId;

    private String authType;

    private String authId;

    private Byte isHeavybuyer;

    private Byte isProxy;

    private Byte internRate;

    private String chatType;

    private String chatNbr;

    private String national;

    private String oConType1;

    private String oConNbr1;

    private String oConType2;

    private String oConNbr2;

    private String oConType3;

    private String oConNbr3;

    private Integer guide;

    private String postAddress;

    private Byte isProxyRecordFee;

    private Integer userTag;

    private String superSid;

    private String agentUrl;

    private String agentLogo;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOauthStatus() {
        return oauthStatus;
    }

    public void setOauthStatus(String oauthStatus) {
        this.oauthStatus = oauthStatus == null ? null : oauthStatus.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNbr() {
        return idNbr;
    }

    public void setIdNbr(String idNbr) {
        this.idNbr = idNbr == null ? null : idNbr.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getCompanyNbr() {
        return companyNbr;
    }

    public void setCompanyNbr(String companyNbr) {
        this.companyNbr = companyNbr == null ? null : companyNbr.trim();
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
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

    public String getRevisability() {
        return revisability;
    }

    public void setRevisability(String revisability) {
        this.revisability = revisability == null ? null : revisability.trim();
    }

    public String getRandomNbr() {
        return randomNbr;
    }

    public void setRandomNbr(String randomNbr) {
        this.randomNbr = randomNbr == null ? null : randomNbr.trim();
    }

    public Date getOauthDate() {
        return oauthDate;
    }

    public void setOauthDate(Date oauthDate) {
        this.oauthDate = oauthDate;
    }

    public Byte getIsContract() {
        return isContract;
    }

    public void setIsContract(Byte isContract) {
        this.isContract = isContract;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId == null ? null : authId.trim();
    }

    public Byte getIsHeavybuyer() {
        return isHeavybuyer;
    }

    public void setIsHeavybuyer(Byte isHeavybuyer) {
        this.isHeavybuyer = isHeavybuyer;
    }

    public Byte getIsProxy() {
        return isProxy;
    }

    public void setIsProxy(Byte isProxy) {
        this.isProxy = isProxy;
    }

    public Byte getInternRate() {
        return internRate;
    }

    public void setInternRate(Byte internRate) {
        this.internRate = internRate;
    }

    public String getChatType() {
        return chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType == null ? null : chatType.trim();
    }

    public String getChatNbr() {
        return chatNbr;
    }

    public void setChatNbr(String chatNbr) {
        this.chatNbr = chatNbr == null ? null : chatNbr.trim();
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national == null ? null : national.trim();
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

    public String getoConType3() {
        return oConType3;
    }

    public void setoConType3(String oConType3) {
        this.oConType3 = oConType3 == null ? null : oConType3.trim();
    }

    public String getoConNbr3() {
        return oConNbr3;
    }

    public void setoConNbr3(String oConNbr3) {
        this.oConNbr3 = oConNbr3 == null ? null : oConNbr3.trim();
    }

    public Integer getGuide() {
        return guide;
    }

    public void setGuide(Integer guide) {
        this.guide = guide;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress == null ? null : postAddress.trim();
    }

    public Byte getIsProxyRecordFee() {
        return isProxyRecordFee;
    }

    public void setIsProxyRecordFee(Byte isProxyRecordFee) {
        this.isProxyRecordFee = isProxyRecordFee;
    }

    public Integer getUserTag() {
        return userTag;
    }

    public void setUserTag(Integer userTag) {
        this.userTag = userTag;
    }

    public String getSuperSid() {
        return superSid;
    }

    public void setSuperSid(String superSid) {
        this.superSid = superSid == null ? null : superSid.trim();
    }

    public String getAgentUrl() {
        return agentUrl;
    }

    public void setAgentUrl(String agentUrl) {
        this.agentUrl = agentUrl == null ? null : agentUrl.trim();
    }

    public String getAgentLogo() {
        return agentLogo;
    }

    public void setAgentLogo(String agentLogo) {
        this.agentLogo = agentLogo == null ? null : agentLogo.trim();
    }
}
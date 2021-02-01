package com.example.hardcoredemo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LzUser implements Serializable {
    private Integer id;

    private String phoneNumber;

    private String openId;

    private String nickName;

    private String url;

    private Integer level;

    private Integer type;

    private Integer schoolId;

    private Integer isBuy;

    private BigDecimal totalAmount;

    private BigDecimal yearAmount;

    private Date currentsTime;

    private Integer referrer;

    private Integer referrerType;

    private String referrerPhoneNumber;

    private String referrerName;

    private Integer advisory;

    private String advisoryPhoneNumber;

    private String advisoryName;

    private String student1;

    private String student2;

    private String remark;

    private String parents;

    private String lables;

    private Integer isEnable;

    private Integer isDeleted;

    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Integer isBuy) {
        this.isBuy = isBuy;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getYearAmount() {
        return yearAmount;
    }

    public void setYearAmount(BigDecimal yearAmount) {
        this.yearAmount = yearAmount;
    }

    public Date getCurrentsTime() {
        return currentsTime;
    }

    public void setCurrentsTime(Date currentsTime) {
        this.currentsTime = currentsTime;
    }

    public Integer getReferrer() {
        return referrer;
    }

    public void setReferrer(Integer referrer) {
        this.referrer = referrer;
    }

    public Integer getReferrerType() {
        return referrerType;
    }

    public void setReferrerType(Integer referrerType) {
        this.referrerType = referrerType;
    }

    public String getReferrerPhoneNumber() {
        return referrerPhoneNumber;
    }

    public void setReferrerPhoneNumber(String referrerPhoneNumber) {
        this.referrerPhoneNumber = referrerPhoneNumber == null ? null : referrerPhoneNumber.trim();
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName == null ? null : referrerName.trim();
    }

    public Integer getAdvisory() {
        return advisory;
    }

    public void setAdvisory(Integer advisory) {
        this.advisory = advisory;
    }

    public String getAdvisoryPhoneNumber() {
        return advisoryPhoneNumber;
    }

    public void setAdvisoryPhoneNumber(String advisoryPhoneNumber) {
        this.advisoryPhoneNumber = advisoryPhoneNumber == null ? null : advisoryPhoneNumber.trim();
    }

    public String getAdvisoryName() {
        return advisoryName;
    }

    public void setAdvisoryName(String advisoryName) {
        this.advisoryName = advisoryName == null ? null : advisoryName.trim();
    }

    public String getStudent1() {
        return student1;
    }

    public void setStudent1(String student1) {
        this.student1 = student1 == null ? null : student1.trim();
    }

    public String getStudent2() {
        return student2;
    }

    public void setStudent2(String student2) {
        this.student2 = student2 == null ? null : student2.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents == null ? null : parents.trim();
    }

    public String getLables() {
        return lables;
    }

    public void setLables(String lables) {
        this.lables = lables == null ? null : lables.trim();
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
package com.spring.boot.coffeine.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jinz
 */
@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable {
    private String phoneNumber;
    private String fullName;
    private String email;
    private boolean isReged;
    private String resultCode;
    private String description;
    private String sourceFrom;
    private String partnerCode;

    private Date createdDate;
    private Date lastUpdatedDate;

    public Account() {
        this.resultCode = "-1";
        this.isReged = false;
        this.createdDate = this.lastUpdatedDate =  new Date();
    }

    public Account(String walletId, String name, String email) {
        this.phoneNumber = walletId;
        this.email = email;
        this.fullName = name;
        this.sourceFrom = "Chia sẻ bạn bè";
        this.resultCode = "-1";
        this.description = "Chuẩn bị đăng ký, chưa nhập OTP";
        this.isReged = false;
        this.createdDate = this.lastUpdatedDate =  new Date();
    }

    @Id
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "IS_REGED")
    public boolean isReged() {
        return isReged;
    }

    public void setReged(boolean reged) {
        isReged = reged;
    }
    @Column(name = "RESULT_CODE")
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Column(name = "SOURCE_FROM")
    public String getSourceFrom() {
        return sourceFrom;
    }

    public void setSourceFrom(String sourceFrom) {
        this.sourceFrom = sourceFrom;
    }

    @Column(name = "PARTNER_CODE")
    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    @Override
    public String toString() {
        return "Account{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", isReged=" + isReged +
                ", resultCode='" + resultCode + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}

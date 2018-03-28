package com.luo.study.mmmapper.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "B2B_A_ACCOUNT")
public class AccountEntity {
    @Id
    @Column(name = "KEY_ID")
    private String keyId;

    @Column(name = "REQ_SN")
    private String reqSn;

    @Column(name = "ACCOUNT_NO")
    private String accountNo;

    @Column(name = "BANK_ACCOUNT_NO")
    private String bankAccountNo;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "SYS_CODE")
    private String sysCode;

    @Column(name = "MER_ID")
    private String merId;

    @Column(name = "CHANNEL")
    private String channel;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "CERT_TYPE")
    private String certType;

    @Column(name = "CERT_NO")
    private String certNo;

    @Column(name = "TRADE_PWD")
    private String tradePwd;

    @Column(name = "TRADE_PWD_SALT")
    private String tradePwdSalt;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "AVAILABLE_AMOUNT")
    private BigDecimal availableAmount;

    @Column(name = "FROZEN_AMOUNT")
    private BigDecimal frozenAmount;

    @Column(name = "IN_TRANSIT_AMOUNT")
    private BigDecimal inTransitAmount;

    @Column(name = "AUDIT_STATUS")
    private String auditStatus;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "IS_PRINCIPAL_ACCOUNT")
    private String isPrincipalAccount;

    @Column(name = "CTR_UPDATE_NO")
    private BigDecimal ctrUpdateNo;

    @Column(name = "USER_TYPE")
    private String userType;

    @Column(name = "ENABLE_")
    private String enable;

    @Column(name = "ACCEPT_DATE")
    private Date acceptDate;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    /**
     * @return KEY_ID
     */
    public String getKeyId() {
        return keyId;
    }

    /**
     * @param keyId
     */
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    /**
     * @return REQ_SN
     */
    public String getReqSn() {
        return reqSn;
    }

    /**
     * @param reqSn
     */
    public void setReqSn(String reqSn) {
        this.reqSn = reqSn;
    }

    /**
     * @return ACCOUNT_NO
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return BANK_ACCOUNT_NO
     */
    public String getBankAccountNo() {
        return bankAccountNo;
    }

    /**
     * @param bankAccountNo
     */
    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    /**
     * @return USER_ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return SYS_CODE
     */
    public String getSysCode() {
        return sysCode;
    }

    /**
     * @param sysCode
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /**
     * @return MER_ID
     */
    public String getMerId() {
        return merId;
    }

    /**
     * @param merId
     */
    public void setMerId(String merId) {
        this.merId = merId;
    }

    /**
     * @return CHANNEL
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return ACCOUNT_TYPE
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return ACCOUNT_NAME
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return CERT_TYPE
     */
    public String getCertType() {
        return certType;
    }

    /**
     * @param certType
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * @return CERT_NO
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * @param certNo
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * @return TRADE_PWD
     */
    public String getTradePwd() {
        return tradePwd;
    }

    /**
     * @param tradePwd
     */
    public void setTradePwd(String tradePwd) {
        this.tradePwd = tradePwd;
    }

    /**
     * @return TRADE_PWD_SALT
     */
    public String getTradePwdSalt() {
        return tradePwdSalt;
    }

    /**
     * @param tradePwdSalt
     */
    public void setTradePwdSalt(String tradePwdSalt) {
        this.tradePwdSalt = tradePwdSalt;
    }

    /**
     * @return TOTAL_AMOUNT
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return AVAILABLE_AMOUNT
     */
    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    /**
     * @param availableAmount
     */
    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }

    /**
     * @return FROZEN_AMOUNT
     */
    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    /**
     * @param frozenAmount
     */
    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    /**
     * @return IN_TRANSIT_AMOUNT
     */
    public BigDecimal getInTransitAmount() {
        return inTransitAmount;
    }

    /**
     * @param inTransitAmount
     */
    public void setInTransitAmount(BigDecimal inTransitAmount) {
        this.inTransitAmount = inTransitAmount;
    }

    /**
     * @return AUDIT_STATUS
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return IS_PRINCIPAL_ACCOUNT
     */
    public String getIsPrincipalAccount() {
        return isPrincipalAccount;
    }

    /**
     * @param isPrincipalAccount
     */
    public void setIsPrincipalAccount(String isPrincipalAccount) {
        this.isPrincipalAccount = isPrincipalAccount;
    }

    /**
     * @return CTR_UPDATE_NO
     */
    public BigDecimal getCtrUpdateNo() {
        return ctrUpdateNo;
    }

    /**
     * @param ctrUpdateNo
     */
    public void setCtrUpdateNo(BigDecimal ctrUpdateNo) {
        this.ctrUpdateNo = ctrUpdateNo;
    }

    /**
     * @return USER_TYPE
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return ENABLE_
     */
    public String getEnable() {
        return enable;
    }

    /**
     * @param enable
     */
    public void setEnable(String enable) {
        this.enable = enable;
    }

    /**
     * @return ACCEPT_DATE
     */
    public Date getAcceptDate() {
        return acceptDate;
    }

    /**
     * @param acceptDate
     */
    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    /**
     * @return CREATED_DATE
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return CREATED_BY
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return UPDATED_DATE
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * @return UPDATED_BY
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "keyId='" + keyId + '\'' +
                ", reqSn='" + reqSn + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", bankAccountNo='" + bankAccountNo + '\'' +
                ", userId='" + userId + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", merId='" + merId + '\'' +
                ", channel='" + channel + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountName='" + accountName + '\'' +
                ", certType='" + certType + '\'' +
                ", certNo='" + certNo + '\'' +
                ", tradePwd='" + tradePwd + '\'' +
                ", tradePwdSalt='" + tradePwdSalt + '\'' +
                ", totalAmount=" + totalAmount +
                ", availableAmount=" + availableAmount +
                ", frozenAmount=" + frozenAmount +
                ", inTransitAmount=" + inTransitAmount +
                ", auditStatus='" + auditStatus + '\'' +
                ", status='" + status + '\'' +
                ", isPrincipalAccount='" + isPrincipalAccount + '\'' +
                ", ctrUpdateNo=" + ctrUpdateNo +
                ", userType='" + userType + '\'' +
                ", enable='" + enable + '\'' +
                ", acceptDate=" + acceptDate +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
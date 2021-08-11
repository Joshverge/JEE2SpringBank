package com.jeespb.databaseservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "rewards")
public class Reward {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_id", nullable = false)
    private String username;

    @Column(name = "rewards_account_id", nullable = false)
    private String accountId;

    @Column(name = "rewards_balance", nullable = false)
    private Double balance;

    @Column(name = "rewards_type", nullable = false)
    private String type;

    @Column(name = "rewards_redeem_status", nullable = false)
    private String redeemStatus;

    @Column(name = "rewards_expiry", nullable = false)
    private String expiry;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRedeemStatus() {
        return redeemStatus;
    }

    public void setRedeemStatus(String redeemStatus) {
        this.redeemStatus = redeemStatus;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}

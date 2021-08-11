package com.jeespb.databaseservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_id", nullable = false, unique = true)
    private String username;

    @Column(name = "account_number", nullable = false, unique = true)
    private String number;

    @Column(name = "account_type", nullable = false)
    private String type;

    @Column(name = "account_branch_code", nullable = false)
    private String branchCode;

    @Column(name = "account_balance", nullable = false)
    private Double balance;

    @Column(name = "account_currency", nullable = false)
    private String currency;

    @Column(name = "account_status", nullable = false)
    private String status;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

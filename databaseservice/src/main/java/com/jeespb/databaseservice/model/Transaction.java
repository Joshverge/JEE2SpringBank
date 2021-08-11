package com.jeespb.databaseservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "transaction_date", nullable = false)
    private String date;

    @Column(name = "transaction_amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_currency", nullable = false)
    private String currency;

    @Column(name = "transaction_status", nullable = false)
    private String status;

    @Column(name = "transaction_description", nullable = false)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

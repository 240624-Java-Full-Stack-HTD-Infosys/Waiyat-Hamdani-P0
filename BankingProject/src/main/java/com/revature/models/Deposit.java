package com.revature.models;

import java.util.Date;

public class Deposit {
    private int depositId;
    private int accountId;
    private Date date;
    private double amountDeposit;

    public Deposit() {
    }

    public Deposit(int depositId, int accountId, Date date, double amountDeposit) {
        this.depositId = depositId;
        this.accountId = accountId;
        this.date = date;
        this.amountDeposit = amountDeposit;
    }

    public int getDepositId() {return depositId;}

    public void setDepositId(int depositId) {this.depositId = depositId;}

    public int getAccountId() {return accountId;}

    public void setAccountId(int accountId) {this.accountId = accountId;}

    public java.sql.Date getDate() {return (java.sql.Date) date;}

    public void setDate(Date date) {this.date = date;}

    public double getAmountDeposit() {return amountDeposit;}

    public void setAmountDeposit(double amountDeposit) {this.amountDeposit = amountDeposit;}
}

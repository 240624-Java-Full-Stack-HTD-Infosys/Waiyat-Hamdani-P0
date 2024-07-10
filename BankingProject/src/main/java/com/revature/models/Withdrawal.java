package com.revature.models;

import java.util.Date;

public class Withdrawal {
    private int withdrawId;
    private int accountId;
    private Date date;
    private double amountWithdrawal;

    public Withdrawal(){}

    public Withdrawal(int withdrawId, int accountId, Date date, double amountWithdrawal) {
        this.withdrawId = withdrawId;
        this.accountId = accountId;
        this.date = date;
        this.amountWithdrawal = amountWithdrawal;
    }

    public int getWithdrawId() {return withdrawId;}
    public void setWithdrawId(int withdrawId) {this.withdrawId = withdrawId;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    public java.sql.Date getDate() {return (java.sql.Date) date;}
    public void setDate(Date date) {this.date = date;}
    public double getAmountWithdrawal() {return amountWithdrawal;}
    public void setAmountWithdrawal(double amountWithdrawal) {this.amountWithdrawal = amountWithdrawal;}

    @Override
    public String toString() {
        return "Withdrawal{" +
                "withdrawId=" + withdrawId +
                ", accountId=" + accountId +
                ", date=" + date +
                ", amountWithdrawal=" + amountWithdrawal +
                '}';
    }
}

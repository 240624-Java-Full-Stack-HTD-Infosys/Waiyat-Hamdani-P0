package com.revature.models;

import java.sql.Date;

public class BankAccountDetails {
    private int accountId;
    private double amountWithdrawal;
    private double amountDeposit;
    private Date withdrawDate;
    private Date depositDate;

    public BankAccountDetails() {}

    public BankAccountDetails(int accountId, double amountWithdrawal, double amountDeposit, Date withdrawDate, Date depositDate) {
        this.accountId = accountId;
        this.amountWithdrawal = amountWithdrawal;
        this.amountDeposit = amountDeposit;
        this.withdrawDate = withdrawDate;
        this.depositDate = depositDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmountWithdrawal() {
        return amountWithdrawal;
    }

    public void setAmountWithdrawal(double amountWithdrawal) {
        this.amountWithdrawal = amountWithdrawal;
    }

    public double getAmountDeposit() {
        return amountDeposit;
    }

    public void setAmountDeposit(double amountDeposit) {
        this.amountDeposit = amountDeposit;
    }

    public Date getWithdrawDate() {
        return withdrawDate;
    }

    public void setWithdrawDate(Date withdrawDate) {
        this.withdrawDate = withdrawDate;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }
}

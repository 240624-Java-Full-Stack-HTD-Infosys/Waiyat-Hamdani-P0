package com.revature.models;

public class Account {

    private int accountId;
    private double balance;
    private String accountType;
    private int userId;

    public Account(){}
    public Account(String username, String password, int accountId, double balance, String accountType, int userId) {
        this.accountId = accountId;
        this.balance = balance;
        this.accountType = accountType;
        this.userId = userId;
    }
    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId = userId;}
    public String getAccountType() {return accountType;}
    public void setAccountType(String accountType) {this.accountType = accountType;}
    public double getBalance() {return balance;}
    public void setBalance(double balance) {this.balance = balance;}
    public int getAccountId() {return accountId;}
    public void setAccountId(int accountId) {this.accountId = accountId;}
    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", userId=" + userId +
                '}';
    }
}

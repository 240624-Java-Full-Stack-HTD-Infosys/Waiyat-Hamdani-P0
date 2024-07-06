package com.revature.models;

public class Account {
    private String username;
    private String password;
    private int accountId;
    private double balance;
    private String accountType;
    private int userId;


    public Account(){}

    public Account(String username, String password, int accountId, double balance, String accountType, int userId) {
        this.username = username;
        this.password = password;
        this.accountId = accountId;
        this.balance = balance;
        this.accountType = accountType;
        this.userId = userId;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public String getAccountType() {return accountType;}

    public void setAccountType(String accountType) {this.accountType = accountType;}

    public double getBalance() {return balance;}

    public void setBalance(double balance) {this.balance = balance;}

    public int getAccountId() {return accountId;}

    public void setAccountId(int accountId) {this.accountId = accountId;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountId=" + accountId +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", userId=" + userId +
                '}';
    }
}

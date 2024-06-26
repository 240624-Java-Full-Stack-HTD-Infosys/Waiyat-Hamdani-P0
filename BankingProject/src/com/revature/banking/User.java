package com.revature.banking;

public class User {


    private String Firstname;
    private String Lastname;
    private String Address;
    private int userId;
    private String Email;
    private double Balance;

    public User(String firstname, String lastname, String email, String add) {
        super();
        Firstname = firstname;
        Lastname = lastname;
        Email = email;
        Address = add;

    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}


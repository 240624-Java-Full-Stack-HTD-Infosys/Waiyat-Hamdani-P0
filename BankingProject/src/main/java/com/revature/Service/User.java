package com.revature.Service;

public class User {

    private String Firstname;
    private String Lastname;
    private String TypeUser;
    private String Phone;
    private String Address;
    private int userId;
    private String Email;
    private double Balance;
    private String Password;

    public User(){}

    public User(String firstname, String lastname, String typeUser, String phone, String address, int userId, String email, double balance, String password) {
        Firstname = firstname;
        Lastname = lastname;
        TypeUser = typeUser;
        Phone = phone;
        Address = address;
        this.userId = userId;
        Email = email;
        Balance = balance;
        Password = password;
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

    public String getTypeUser() {
        return TypeUser;
    }

    public void setTypeUser(String typeUser) {
        TypeUser = typeUser;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
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
        this.Email = email;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", TypeUser='" + TypeUser + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address='" + Address + '\'' +
                ", userId=" + userId +
                ", Email='" + Email + '\'' +
                ", Balance=" + Balance +
                ", Password='" + Password + '\'' +
                '}';
    }
}


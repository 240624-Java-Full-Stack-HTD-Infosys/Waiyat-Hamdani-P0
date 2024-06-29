package com.revature.banking;

public class User {

    private String Name;
    private String TypeUser;
    private String Phone;
    private String Address;
    private int userId;
    private String Email;
    private double Balance;

    public User(){

    }
    public User(String Name, String email, String add) {
        super();
        this.Name =Name;
        this.Email = email;
        this.Address = add;

    }

    public String getName() {
        return Name;
    }

    public void setName(String firstname) {
        this.Name = firstname;
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
}


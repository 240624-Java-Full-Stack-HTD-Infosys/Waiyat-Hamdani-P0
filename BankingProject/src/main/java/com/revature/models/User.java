package com.revature.models;

public class User {
    private int userId;
    private String Firstname;
    private String Lastname;
    private String Phone;
    private String Address;
    private String Email;

    public User(){}

    public User(String firstname, String lastname, String typeUser, String phone, String address, int userId, String email, double balance, String password) {
        Firstname = firstname;
        Lastname = lastname;
        Phone = phone;
        Address = address;
        this.userId = userId;
        Email = email;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}


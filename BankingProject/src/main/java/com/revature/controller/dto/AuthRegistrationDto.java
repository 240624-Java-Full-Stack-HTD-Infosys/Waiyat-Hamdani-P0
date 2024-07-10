package com.revature.controller.dto;

import com.revature.models.Account;
import com.revature.models.User;

public class AuthRegistrationDto {
    private User user ;
    private Account account ;
    public AuthRegistrationDto() {}
    public AuthRegistrationDto(User user, Account account) {
        this.account = account;

        this.user = user;
    }

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public Account getAccount() {return account;}
    public void setAccount(Account account) {this.account = account;}
}

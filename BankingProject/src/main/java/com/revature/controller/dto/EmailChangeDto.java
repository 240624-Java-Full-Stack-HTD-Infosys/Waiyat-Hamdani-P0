package com.revature.controller.dto;

public class EmailChangeDto {
    private String newEmail;
    public EmailChangeDto() {}
    public EmailChangeDto(String newEmail) {this.newEmail = newEmail;}
    public String getNewEmail() {return newEmail;}
    public void setNewEmail(String newEmail) {this.newEmail = newEmail;}
}

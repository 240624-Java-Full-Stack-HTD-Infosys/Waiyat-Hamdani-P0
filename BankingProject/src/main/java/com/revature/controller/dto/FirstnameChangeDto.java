package com.revature.controller.dto;

public class FirstnameChangeDto {
    private String newFirstname;
    public FirstnameChangeDto() {}
    public FirstnameChangeDto(String newFirstname) {this.newFirstname = newFirstname;}
    public String getNewFirstname() {return newFirstname;}
    public void setNewFirstname(String newFirstname) {this.newFirstname = newFirstname;}
}

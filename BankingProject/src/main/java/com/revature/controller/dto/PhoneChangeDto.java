package com.revature.controller.dto;

public class PhoneChangeDto {
    private String newPhone;
    public PhoneChangeDto() {}
    public PhoneChangeDto(String newPhone) {this.newPhone = newPhone;}
    public String getNewPhone() {return newPhone;}
    public void setNewPhone(String newPhone) {this.newPhone = newPhone;}
}

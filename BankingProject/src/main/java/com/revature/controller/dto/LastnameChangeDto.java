package com.revature.controller.dto;

public class LastnameChangeDto {
    private String newLastname;
    public LastnameChangeDto() {}
    public LastnameChangeDto(String newLastname) {this.newLastname = newLastname;}
    public String getNewLastname() {return newLastname;}
    public void setNewLastname(String newLastname) {this.newLastname = newLastname;}
}

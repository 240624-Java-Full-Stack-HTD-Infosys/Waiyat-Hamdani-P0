package com.revature.controller.dto;

public class AddressChangeDto {
    private String newAddress;
    public AddressChangeDto() {}
    public AddressChangeDto(String newAddress) {this.newAddress = newAddress;}
    public String getNewAddress() {return newAddress;}
    public void setNewAddress(String newAddress) {this.newAddress = newAddress;}
}

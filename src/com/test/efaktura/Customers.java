/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.efaktura;

/**
 *
 * @author Abhishek.Gautam
 */

public class Customers {
    private String name;
    private String phoneNo;
    private String address;

    public Customers() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customers{" + "name=" + name + ", phoneNo=" + phoneNo + ", address=" + address + '}';
    }

    public Customers(String name, String phoneNo, String address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }
    
    
}

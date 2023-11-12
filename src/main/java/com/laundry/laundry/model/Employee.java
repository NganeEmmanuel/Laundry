package com.laundry.laundry.model;

import java.util.Date;

public class Employee {
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String city;
    private String address1;
    private String address2;
    private String role;  // manager, receptionist, etc
    private Date orderDate;
    private Date updatedDate;
    public Employee() {}
    public Employee(String name, String email, String phoneNumber, String city, String address1, String address2, String role, Date orderDate, Date updatedDate) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.role = role;
        this.orderDate = orderDate;
        this.updatedDate = updatedDate;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", role='" + role + '\'' +
                ", orderDate=" + orderDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}

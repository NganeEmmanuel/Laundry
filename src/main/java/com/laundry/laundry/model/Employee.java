package com.laundry.laundry.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String city;
    private String address1;
    private String address2;
    private String role;  // manager, receptionist, etc
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_updated")
    private Date lastUpdated;
    public Employee() {}
    public Employee(String name, String email, String phoneNumber, String city, String address1, String address2, String role, Date createdDate, Date lastUpdated) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.role = role;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}

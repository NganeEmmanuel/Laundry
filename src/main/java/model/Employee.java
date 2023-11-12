package model;

import jakarta.persistence.ManyToMany;

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
    @ManyToMany()
    private Order order;
}

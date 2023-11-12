package model;

import helper.OrderStatus;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private Service service;
    private OrderStatus orderStatus;
    @ManyToOne
    private User user;
    private Date orderDate;
    private Date updatedDate;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Employee> updatedBy;

}

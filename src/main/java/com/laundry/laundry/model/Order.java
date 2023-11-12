package com.laundry.laundry.model;

import com.laundry.laundry.helper.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Service service; //E.G washing, wahsing and drying, etc
    private Date orderDate;
    private Date updatedDate;
    private OrderStatus orderStatus;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> updatedBy;
    public Order(){}

    public Order(User user, Service service, Date orderDate, Date updatedDate, OrderStatus orderStatus, List<Employee> updatedBy) {
        this.user = user;
        this.service = service;
        this.orderDate = orderDate;
        this.updatedDate = updatedDate;
        this.orderStatus = orderStatus;
        this.updatedBy = updatedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Employee> getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(List<Employee> updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", com.laundry.laundry.service=" + service +
                ", orderDate=" + orderDate +
                ", updatedDate=" + updatedDate +
                ", orderStatus=" + orderStatus +
                ", updatedBy=" + updatedBy +
                '}';
    }
}

package com.laundry.laundry.model;

import com.laundry.laundry.helper.status.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Service service; //E.G washing, wahsing and drying, etc
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "order_status")
    private OrderStatus orderStatus;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> updatedBy;
    public Order(){}

    public Order(User user, Service service, Date orderDate, Date updatedDate, OrderStatus orderStatus, List<Employee> updatedBy) {
        this.user = user;
        this.service = service;
        this.orderDate = new Date();
        this.updatedDate = this.orderDate;
        this.orderStatus = OrderStatus.RECEIVED;
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

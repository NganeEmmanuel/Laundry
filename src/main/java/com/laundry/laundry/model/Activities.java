package com.laundry.laundry.model;

import com.laundry.laundry.helper.ActivityAction;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Activities {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Employee employee;
    private String table; //Order, Employee, Users, Service
    private Object objectId = new Order();
    private ActivityAction action;
    private String description;
    private Date actionDate;
    public Activities(){}

    public Activities(Employee employee, String table, Object objectId, ActivityAction action, String description, Date actionDate) {
        this.employee = employee;
        this.table = table;
        this.objectId = objectId;
        this.action = action;
        this.description = description;
        this.actionDate = actionDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Object getObjectId() {
        return objectId;
    }

    public void setObjectId(Object objectId) {
        this.objectId = objectId;
    }

    public ActivityAction getAction() {
        return action;
    }

    public void setAction(ActivityAction action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", employee=" + employee +
                ", table='" + table + '\'' +
                ", objectId=" + objectId +
                ", action=" + action +
                ", description='" + description + '\'' +
                ", actionDate=" + actionDate +
                '}';
    }
}

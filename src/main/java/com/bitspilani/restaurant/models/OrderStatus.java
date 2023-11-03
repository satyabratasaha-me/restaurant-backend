package com.bitspilani.restaurant.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name="order_status")
public class OrderStatus {



    @Id
    @Column(name = "order_id")
    Integer id;
    @Column(name = "order_status")
    String status;

    OrderStatus(){};

    public OrderStatus(String status) {
        this.status = status;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }




}

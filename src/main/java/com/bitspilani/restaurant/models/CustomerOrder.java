package com.bitspilani.restaurant.models;


import jakarta.persistence.*;

@Entity
public class CustomerOrder {

    public Integer getOrderId() {
        return orderId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    public CustomerOrder(Integer customerId, Integer statusId) {
        this.customerId = customerId;
        this.statusId = statusId;
    }

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_status_id")
    private  Integer statusId;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }



    CustomerOrder(){}


}

package com.bitspilani.restaurant.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Feedback(String comments) {
        this.comments = comments;
    }

    Feedback(){};

    public Feedback(Integer orderId, Integer customerId, Integer rating, String comments) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.rating = rating;
        this.comments = comments;
    }

    @Column(name="order_id")
    private Integer orderId;
    @Column(name="customer_id")
    private  Integer customerId;
    @Column(name="rating")
    private  Integer rating;
    @Column(name="comments")
    private String comments;

}

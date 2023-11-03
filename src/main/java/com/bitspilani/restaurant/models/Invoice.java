package com.bitspilani.restaurant.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "id")
    private Integer id;

    @Id
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "total_amount")
    private Integer totalAmount;

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "status")
    private String status;
    @Column(name = "invoice_date")
    private Date invoiceDate;

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public Invoice(){}

    public Invoice(Integer orderId, Integer totalAmount, String status, Date invoiceDate) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.invoiceDate = invoiceDate;
    }





}

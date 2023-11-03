package com.bitspilani.restaurant.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_management")
public class Orders {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;


    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "menu_item_id")
    private Integer menuItemId;



    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private Integer amount;


    public Orders() {
    }

    public Orders(Integer order_id, Integer menuItemId, Integer quantity) {
        this.menuItemId = menuItemId;
        this.quantity = quantity;
        this.order_id = order_id;
    }


    public Integer getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.menuItemId = menuItemId;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Integer getId() {
        return order_id;
    }

    public Integer getAmount() {
        return amount;
    }




}

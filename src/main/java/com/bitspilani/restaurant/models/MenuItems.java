package com.bitspilani.restaurant.models;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_item")
public class MenuItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    @Id
    private Integer id;
    @Column(name="item_name")
    private String name;
    @Column(name="item_category")
    private String category;

    MenuItems(){}

    public MenuItems(String name, String category, Integer price, String imageLink) {
        super();
        this.name = name;
        this.category = category;
        this.price = price;
        this.imageLink = imageLink;
    }

    @Column(name="item_price")
    private Integer price;
    @Column(name="item_image_link")
    private String imageLink;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }



}

package com.bitspilani.restaurant.models;


import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int Id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "primary_phone_number")
    private String phoneNumber;

    public Customer(){}

    public Customer(String firstName, String lastName, String emailId, String phoneNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPrimaryPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getId() {
        return Id;
    }

    public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
        this.phoneNumber = primaryPhoneNumber;
    }


}

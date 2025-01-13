package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerAddress;
    private String customerEmail;

    public Customer() {}

    public Customer(Long customerId, String customerAddress, String customerEmail) {
        this.customerId = customerId;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public Long getCustomerId() { return customerId; }
    public String getCustomerAddress() { return customerAddress; }
    public String getCustomerEmail() { return customerEmail; }
}
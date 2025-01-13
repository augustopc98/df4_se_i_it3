package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {
    Customer getCustomerDetails(Long customerId);
}
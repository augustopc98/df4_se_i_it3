package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerDetails(Long customerId);

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer updatedCustomer);

    void deleteCustomer(Long customerId);

    List<Customer> getAllCustomers();
}

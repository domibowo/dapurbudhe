package com.domibowo.dapurbudhe.service;

import com.domibowo.dapurbudhe.models.Customer;

import java.util.List;

public interface CustomerServices {

    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<Customer> getAllCustomersByName(String name);
    Customer getCustomerById(String id);
    void deleteCustomer(String id);

}

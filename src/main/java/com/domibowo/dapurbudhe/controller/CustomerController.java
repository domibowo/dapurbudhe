package com.domibowo.dapurbudhe.controller;

import com.domibowo.dapurbudhe.models.Customer;
import com.domibowo.dapurbudhe.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerServices services;

    @PostMapping("/customer/form")
    public Customer saveCustomer(@RequestBody Customer customer){
        return services.saveCustomer(customer);
    }

    @PutMapping("/customer/form")
    public Customer updateCustomer(@RequestBody Customer customer){
        return services.updateCustomer(customer);
    }

    @GetMapping("/customer")
    public List<Customer> getCustomersByNameLike(@RequestParam(name = "name") String name){
        return services.getAllCustomersByName(name);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return services.getCustomerById(id);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable String id){
        services.deleteCustomer(id);
    }
}

package com.domibowo.dapurbudhe.service.impl;

import com.domibowo.dapurbudhe.exceptions.ResourceNotFoundException;
import com.domibowo.dapurbudhe.models.Customer;
import com.domibowo.dapurbudhe.repositories.CustomerRepository;
import com.domibowo.dapurbudhe.service.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomersByName(String name) {
        return repository.findAllCustomersByName(name);
    }

    @Override
    public Customer getCustomerById(String id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        } else {
            return repository.findById(id).get();
        }
    }

    @Override
    public void deleteCustomer(String id) {
        repository.deleteById(id);
    }
}

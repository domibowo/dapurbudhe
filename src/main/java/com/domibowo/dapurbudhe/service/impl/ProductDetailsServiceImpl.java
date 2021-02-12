package com.domibowo.dapurbudhe.service.impl;

import com.domibowo.dapurbudhe.exceptions.ResourceNotFoundException;
import com.domibowo.dapurbudhe.models.ProductDetails;
import com.domibowo.dapurbudhe.repositories.ProductDetailsRepository;
import com.domibowo.dapurbudhe.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    ProductDetailsRepository repository;

    @Override
    public ProductDetails saveProductDetails(ProductDetails details) {
        return repository.save(details);
    }

    @Override
    public ProductDetails updateProductDetails(ProductDetails details) {
        return repository.save(details);
    }

    @Override
    public ProductDetails getDetailsByID(String id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        } else {
            return repository.findById(id).get();
        }
    }

    @Override
    public void deleteDetails(String id) {
        repository.deleteById(id);
    }
}

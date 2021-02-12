package com.domibowo.dapurbudhe.service.impl;

import com.domibowo.dapurbudhe.exceptions.ResourceNotFoundException;
import com.domibowo.dapurbudhe.models.Product;
import com.domibowo.dapurbudhe.repositories.ProductRepository;
import com.domibowo.dapurbudhe.service.ProductDetailsService;
import com.domibowo.dapurbudhe.service.ProductServices;
import com.domibowo.dapurbudhe.utils.FileHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

    @Autowired
    ProductRepository repository;

    @Autowired
    FileHandler fileHandler;

    @Autowired
    ProductDetailsService productDetailsService;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Product saveProduct(String reqProduct, MultipartFile multipartFile) throws JsonProcessingException {
        Product product = repository.save(mapper.readValue(reqProduct, Product.class));
        String dest = String.format("%s.%s", product.getProductName().toLowerCase().replace(" ","_"), FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
        String path = fileHandler.store(multipartFile, dest);
        product.setImage(path);
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        product.setPrdDetails(productDetailsService.getDetailsByID(product.getPrdDetailId()));
        return repository.save(product);
    }

    @Override
    public Product getProductByID(String id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        } else {
            return repository.findById(id).get();
        }
    }

    @Override
    public List<Product> getAllProductByNameLike(String name) {
        return repository.findAllProductByProductName(name);
    }

    @Override
    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}

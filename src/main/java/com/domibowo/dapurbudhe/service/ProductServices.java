package com.domibowo.dapurbudhe.service;

import com.domibowo.dapurbudhe.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductServices {

    Product saveProduct(String reqProduct, MultipartFile multipartFile) throws JsonProcessingException;
    Product updateProduct(Product product);
    Product getProductByID(String id);
    List<Product> getAllProductByNameLike(String name);
    void deleteProduct(String id);
}

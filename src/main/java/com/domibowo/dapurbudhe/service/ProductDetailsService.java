package com.domibowo.dapurbudhe.service;

import com.domibowo.dapurbudhe.models.ProductDetails;

public interface ProductDetailsService {

    ProductDetails saveProductDetails(ProductDetails details);
    ProductDetails updateProductDetails(ProductDetails details);
    ProductDetails getDetailsByID(String id);
    void deleteDetails(String id);
}

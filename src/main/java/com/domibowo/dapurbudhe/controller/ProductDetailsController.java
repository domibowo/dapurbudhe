package com.domibowo.dapurbudhe.controller;

import com.domibowo.dapurbudhe.models.ProductDetails;
import com.domibowo.dapurbudhe.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product/details")
public class ProductDetailsController {

    @Autowired
    ProductDetailsService service;

    @PostMapping("/form")
    public ProductDetails saveProductDetails(@RequestBody ProductDetails details){
        return service.saveProductDetails(details);
    }

    @PutMapping("/form")
    public ProductDetails updateProductDetails(@RequestBody ProductDetails details){
        return service.updateProductDetails(details);
    }

    @GetMapping("/{id}")
    public ProductDetails getDetailsById(@PathVariable String id){
        return service.getDetailsByID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetails(@PathVariable String id){
        service.deleteDetails(id);
    }
}

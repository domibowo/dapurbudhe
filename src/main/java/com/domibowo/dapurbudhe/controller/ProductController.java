package com.domibowo.dapurbudhe.controller;

import com.domibowo.dapurbudhe.models.Product;
import com.domibowo.dapurbudhe.service.ProductServices;
import com.domibowo.dapurbudhe.utils.FileHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices services;

    @Autowired
    FileHandler fileHandler;

    @PostMapping("/form")
    public Product saveProduct(@RequestPart MultipartFile file, @RequestPart String reqProduct) throws JsonProcessingException {
        return services.saveProduct(reqProduct, file);
    }

    @PutMapping("/form")
    public Product updateProduct(@RequestPart Product product){
        return services.updateProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return services.getProductByID(id);
    }

    @GetMapping()
    public List<Product> getProductsByNameLike(@RequestParam(name = "name") String name){
        return services.getAllProductByNameLike(name);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable String id){
        services.deleteProduct(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<Resource> getProductPhoto(@PathVariable String id, HttpServletRequest request) throws IOException {
        Product product = services.getProductByID(id);
        Resource resource = fileHandler.read(product.getImage());
        String content = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(content))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}

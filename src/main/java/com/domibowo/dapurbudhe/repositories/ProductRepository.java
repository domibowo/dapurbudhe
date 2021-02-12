package com.domibowo.dapurbudhe.repositories;

import com.domibowo.dapurbudhe.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "select * from product p where p.product_name like concat('%', :name, '%')", nativeQuery = true)
    List<Product> findAllProductByProductName(String name);
}

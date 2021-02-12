package com.domibowo.dapurbudhe.repositories;

import com.domibowo.dapurbudhe.models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, String> {
}

package com.domibowo.dapurbudhe.repositories;

import com.domibowo.dapurbudhe.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "select * from Customer c where c.name like concat('%', :name, '%') ", nativeQuery = true)
    List<Customer> findAllCustomersByName(String name);
}

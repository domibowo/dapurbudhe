package com.domibowo.dapurbudhe.repositories;

import com.domibowo.dapurbudhe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    Boolean existsByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}

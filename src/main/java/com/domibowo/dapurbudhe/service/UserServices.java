package com.domibowo.dapurbudhe.service;

import com.domibowo.dapurbudhe.models.User;

public interface UserServices {

    User saveUser(User user);
    User updateUser(User user);
    User authenticateUser(String username, String password);
    User getUserById(String id);
    void deleteUser(String id);
}

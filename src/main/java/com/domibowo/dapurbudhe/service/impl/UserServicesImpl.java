package com.domibowo.dapurbudhe.service.impl;

import com.domibowo.dapurbudhe.exceptions.ResourceNotFoundException;
import com.domibowo.dapurbudhe.exceptions.UnauthenticatedUserException;
import com.domibowo.dapurbudhe.models.User;
import com.domibowo.dapurbudhe.repositories.UserRepository;
import com.domibowo.dapurbudhe.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository repository;


    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Override
    public User authenticateUser(String username, String password) {
        if(!repository.existsByUsernameAndPassword(username, password)){
            throw new UnauthenticatedUserException(username);
        } else {
            return repository.findByUsername(username);
        }
    }

    @Override
    public User getUserById(String id) {
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException(id);
        } else {
            return repository.findById(id).get();
        }
    }

    @Override
    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}

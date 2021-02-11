package com.domibowo.dapurbudhe.controller;

import com.domibowo.dapurbudhe.models.User;
import com.domibowo.dapurbudhe.service.UserServices;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UserServices services;

    @PostMapping("/sign-up")
    public User saveUser(@RequestBody User user){
        return services.saveUser(user);
    }

    @PutMapping("/setting")
    public User updateUser(@RequestBody User user){
        return services.updateUser(user);
    }

    @PostMapping("/sign-in")
    public User login(@RequestBody ObjectNode node){
        String username = node.get("username").asText();
        String password = node.get("password").asText();
        return services.authenticateUser(username, password);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return services.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        services.deleteUser(id);
    }
}

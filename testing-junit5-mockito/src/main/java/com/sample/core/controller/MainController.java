package com.sample.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.core.model.User;
import com.sample.core.services.UserService;

@RestController
@ComponentScan(basePackages = "com.sample.core")
public class MainController {
	
	@Autowired
	private UserService userService;
	
    @GetMapping("/")
    public String hello() {
        return userService.get();
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
    @PostMapping("/user/{id}/{name}/{age}")
    public String addUser(@PathVariable("id") int id,
    		@PathVariable("name") String name,@PathVariable("age") int age){
    	return userService.addUser(id,name, age);
    }
    @PutMapping("/user/{id}/{name}/{age}")
    public String editUser(@PathVariable("id") int id,
    		@PathVariable("name") String name,@PathVariable("age") int age){
    	return userService.editUser(id,name, age);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id){
    	return userService.deleteUser(id);
    }

}

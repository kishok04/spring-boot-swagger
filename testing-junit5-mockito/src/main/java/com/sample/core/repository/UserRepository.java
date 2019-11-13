package com.sample.core.repository;

import java.util.List;

import com.sample.core.model.User;

public interface UserRepository {
	
    public String get();
    
    public List<User> getUsers();
    
    public String addUser(User user);
    
    public String editUser(int id,String name,int age);
    
    public String deleteUser(int id);
    
}

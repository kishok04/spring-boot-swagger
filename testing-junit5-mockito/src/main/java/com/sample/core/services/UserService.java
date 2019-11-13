package com.sample.core.services;


import java.util.List;

import com.sample.core.model.User;

public interface UserService {

    public String get();
    
    public List<User> getUsers();
    
    public String addUser(int id,String name,int age);
    
    public String editUser(int id,String name,int age);
    
    public String deleteUser(int id);

}

package com.sample.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.core.model.User;
import com.sample.core.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String get() {
        return userRepository.get();
    }

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public String addUser(int id, String name, int age) {
		return userRepository.addUser(new User(id,name,age));
	}

	@Override
	public String editUser(int id, String name, int age) {
		return userRepository.editUser(id, name, age);
	}

	@Override
	public String deleteUser(int id) {
		return userRepository.deleteUser(id);
	}

}

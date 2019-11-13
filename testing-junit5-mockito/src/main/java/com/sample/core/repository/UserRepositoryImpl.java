package com.sample.core.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sample.core.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	List<User> list = new ArrayList<>();
    @Override
    public String get() {
        return "Hello JUnit 5";
    }

	@Override
	public List<User> getUsers() {
		return list;
	}

	@Override
	public String addUser(User user) {
		list.add(user);
		return "User added successfully";
	}

	@Override
	public String editUser(int id,String name,int age) {
		list.stream().filter(lst -> lst.getId() == id).collect(Collectors.toList()).
		forEach(ls -> {
			ls.setAge(age);
			ls.setName(name);
		});
		return "User "+name+" Edited successfully";
	}

	@Override
	public String deleteUser(int id) {
		list.removeIf(l -> l.getId() == id);
		return "User with id "+id+" deleted successfully";
	}
}

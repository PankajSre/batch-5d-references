package com.amdocs.training.dao;

import java.util.List;

import com.amdocs.training.model.User;

public interface UserDAO {

	List<User> findAll();

	boolean addUser(User user);

	User getUserById(Long id);

	boolean deleteUser(Long id);
	
	boolean updateUser(User user);
}

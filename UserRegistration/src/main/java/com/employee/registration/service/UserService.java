package com.employee.registration.service;

import java.util.List;

import com.employee.registration.model.User;

public interface UserService {

	public abstract User getByFirstNameLastName(String firstName, String lastName);

	public abstract List<User> getByFirstName(String firstName);

	public abstract void createUser(User user);

	public abstract void updateUser(User user);

	public abstract void deleteUserById(long id);

	public abstract User findById(long id);

	public abstract void deleteAllUsers();

	public abstract List<User> findAllUsers();
	
	boolean isUserExist(User user);
	
}

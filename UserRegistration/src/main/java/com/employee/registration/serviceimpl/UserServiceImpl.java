package com.employee.registration.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.registration.dao.UserDao;
import com.employee.registration.model.User;
import com.employee.registration.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getByFirstNameLastName(String firstName, String lastName) {
		return userDao.getByFirstNameLastName(firstName, lastName);
	}

	@Override
	public List<User> getByFirstName(String firstName) {
		return userDao.getByFirstName(firstName);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUserById(long id) {
		userDao.deleteUserById(id);
	}

	@Override
	public User findById(long id) {
		return userDao.findById(id);
	}

	@Override
	public void deleteAllUsers() {
		userDao.deleteAllUsers();
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	@Override
	public boolean isUserExist(User user) {
		return userDao.getByFirstNameLastName(user.getFirstName(), user.getLastName()) != null;
	}

}

package com.employee.registration.daoimpl;

import java.util.List;

import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.employee.registration.dao.UserDao;
import com.employee.registration.model.User;

@Repository
public class UserDaoImpl extends ObjectDaoImpl<User> implements UserDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * @Autowired protected Datastore dataStore;
	 */

	@Override
	public User getByFirstNameLastName(String firstName, String lastName) {
		logger.info("Start's getByFirstNameLastName");
		Query<User> query = dataStore.createQuery(User.class).field("firstName").equal(firstName).field("lastName")
				.equal(lastName);
		logger.info("End's getByFirstNameLastName");
		return query.get();
	}

	@Override
	public List<User> getByFirstName(String firstName) {
		logger.info("Star's-getByFirstName");
		Query<User> query = dataStore.createQuery(User.class).field("firstName").equal(firstName);
		logger.info("End's getByFirstName");
		return query.asList();
	}

	@Override
	public void createUser(User user) {
		dataStore.save(user);
		logger.info("User Saved Successfully!");
	}

	@Override
	public void updateUser(User user) {
		dataStore.merge(user);
		logger.info("User Info Updated Successfully!");
	}

	@Override
	public void deleteUserById(long id) {
		User user = dataStore.getByKey(User.class, new Key<User>(User.class, null, id));
		dataStore.delete(user);
		logger.info("User was Deleted Successfully!");
	}

	@Override
	public User findById(long id) {
		User user = dataStore.getByKey(User.class, new Key<User>(User.class, null, id));
		logger.info("Obtained User Object Successfully!");
		return user;
	}

	@Override
	public void deleteAllUsers() {
		List<User> allUsers = dataStore.find(User.class).asList();
		logger.info("Delted All User's Info Successfully!");
	}

	@Override
	public List<User> findAllUsers() {
		List<User> allUsers = dataStore.find(User.class).asList();
		System.out.println("User's List of Info: " + allUsers);
		return allUsers;
	}

}

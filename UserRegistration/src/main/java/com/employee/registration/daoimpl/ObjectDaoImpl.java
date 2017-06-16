package com.employee.registration.daoimpl;

import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.registration.dao.ObjectDao;

public class ObjectDaoImpl<T> implements ObjectDao<T> {

	@Autowired
	protected Datastore dataStore;

}

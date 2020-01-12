package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.UserDAO;
import com.dev.dao.UserDAOJDBCImpl;

public class ServiceJDBCImpl implements ServiceDAO {

	UserDAO udao = new UserDAOJDBCImpl();
	@Override
	public Boolean createUser(User user) {
		boolean res = udao.createUser(user); 
		return res;
	}

	@Override
	public User retrieveUser(Integer userId) {
		User u = udao.retrieveUser(userId);
		return u;
	}

	@Override
	public Boolean updateUser(User user) {
		boolean res = udao.updateUser(user);
		return res;
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		boolean res = udao.deleteUser(userId, password);
		return res;
	}

}

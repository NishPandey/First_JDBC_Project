package com.dev.services;

import com.dev.beans.User;
import com.dev.dao.UserDAO;
import com.dev.dao.UserDAOImpl;

public class ServiceDAOImpl implements ServiceDAO {

	UserDAO udao = new UserDAOImpl();

	@Override
	public Boolean createUser(User user) {
		Boolean rs = udao.createUser(user);
		return rs;
	}

	@Override
	public User retrieveUser(Integer userId) {
		return udao.retrieveUser(userId);
	}

	@Override
	public Boolean updateUser(User user) {
		Boolean rs = udao.updateUser(user);
		return rs;
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		Boolean rs = udao.deleteUser(userId, password);
		return rs;
	}

}

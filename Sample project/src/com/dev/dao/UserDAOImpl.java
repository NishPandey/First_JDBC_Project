package com.dev.dao;

import java.util.HashMap;

import com.dev.beans.User;
import com.dev.repo.HashMapRepo;

public class UserDAOImpl implements UserDAO {


	HashMapRepo ucoll = new HashMapRepo();

	HashMap <Integer, User> map = ucoll.map;

	@Override
	public Boolean createUser(User user) {
		return ucoll.createUser(user);
	}

	@Override
	public User retrieveUser(Integer userId) {
		return ucoll.retrieveUser(userId);
	}

	@Override
	public Boolean updateUser(User user) {
		return ucoll.updateUser(user);
	}

	@Override
	public Boolean deleteUser(Integer userId, String password) {
		return ucoll.deleteUser(userId, password);
	}

}



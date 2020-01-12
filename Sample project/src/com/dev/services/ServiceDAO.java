package com.dev.services;

import com.dev.beans.User;

public interface ServiceDAO {

	public Boolean createUser(User user);
	public User retrieveUser(Integer userId);
	public Boolean updateUser(User user);
	public Boolean deleteUser(Integer userId, String password);

}

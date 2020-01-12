package com.dev.repo;

import java.util.HashMap;

import com.dev.beans.User;

public class HashMapRepo {

	public static HashMap <Integer, User> map = new HashMap<>();

	public Boolean createUser(User user) {
		User u1 = map.put(user.getUserid(),user);
		u1=map.get(user.getUserid());

		if(u1==null)
		{
			return false;
		} 
		return true;
	}

	public User retrieveUser(Integer userId) {
		if(map.containsKey(userId))

		{		
			return map.get(userId);
		}
		else	
			return null;
	}

	public Boolean updateUser(User user) {
		if(map.containsKey(user.getUserid()))
		{	
			map.put(user.getUserid(),user);
			return true;
		}else
			return false;
	}

	public Boolean deleteUser(Integer userId, String password) {
		if(map.containsKey(userId))
		{
			User user=map.get(userId);
			if(user.getPassword().equals(password)) {
				map.remove(userId);
				return true;
			}

		}
		return false;

	}

	public HashMapRepo(){
		User user1 = new User();
		user1.setUserid(1);
		user1.setUsername("Nisha");
		user1.setPassword("root");
		user1.setEmail("nish@gmail");
		map.put(1, user1);

		User user2 = new User();
		user2.setUserid(2);
		user2.setUsername("Sonu");
		user2.setPassword("456");
		user2.setEmail("sonu@gmail");
		map.put(2, user2);


		User user3 = new User();
		user3.setUserid(3);
		user3.setUsername("Komal");
		user3.setPassword("komdi");
		user3.setEmail("komal@gmail.com");
		map.put(3, user3);
	}


}

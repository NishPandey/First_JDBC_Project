package com.dev.controller;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.dao.UserDAOImpl;
import com.dev.dao.UserDAOJDBCImpl;
import com.dev.services.ServiceDAO;
import com.dev.services.ServiceDAOImpl;
import com.dev.services.ServiceJDBCImpl;

public class MainJDBCApp {

	public static void main(String args[]) {

		ServiceDAO sd = new ServiceJDBCImpl();

		Scanner sc = new Scanner (System.in);

		UserDAOJDBCImpl userjdbcdao;
		ServiceDAO servicedao;
		int i=5;

		while(i>0) {
			System.out.println("Select a option...");
			System.out.println("1) Create a profile");
			System.out.println("2) Get a profile");
			System.out.println("3) Update a profile");
			System.out.println("4) Delete a profile");
			System.out.println("5) Exit");

			i = sc.nextInt();
			switch(i) {
			case 1:
				//create
				System.out.println("Enter user id");
				int id = sc.nextInt();
				System.out.println("Enter user name");
				String name = sc.next();
				System.out.println("Enter email");
				String email = sc.next();
				System.out.println("Enter password");
				String password = sc.next();

				User u = new User();
				u.setUserid(id);
				u.setUsername(name);
				u.setPassword(password);
				u.setEmail(email);

				userjdbcdao = new UserDAOJDBCImpl();
				userjdbcdao.createUser(u);

				System.out.println("User Successfully Added");

				break;

			case 2:
				//retrieve 
				System.out.println("Enter user id");
				int uid = sc.nextInt();
				User user = sd.retrieveUser(uid);
				if(user!=null) {
					System.out.println(user);
				}
				else {
					System.out.println("No such user exist with id: "+uid);
				}
				break;

			case 3:
				//update
				System.out.println("Enter user id");
				id = sc.nextInt();
				System.out.println("Enter new password");
				password = sc.next();

				System.out.println("Enter new name");
				name = sc.next();
				System.out.println("Enter updated email id");
				email = sc.next();

				//create object and Insert data
				u = new User();
				u.setUserid(id);
				u.setUsername(name);
				u.setEmail(email);
				u.setPassword(password);

				servicedao =  new ServiceDAOImpl();
				boolean res = sd.updateUser(u);

				if(res)
				{
					System.out.println("User data Successfully Updated");
				}
				else
				{
					System.out.println("Please enter Corect data");
				}
				break;

			case 4:
				//delete
				System.out.println("Enter user id");
				id = sc.nextInt();
				System.out.println("Enter password");
				password = sc.next();

				boolean rs = sd.deleteUser(id, password);
				if(rs)
				{
					System.out.println("User Successfully Deleted");
				}
				else
				{
					System.out.println("No. such user exists with id: ");
				}
				break;
			case 5:
				//exit
				i=0;
				break;

			default:
				System.out.println("Please Enter the correct option");

			}
		}
	}

}





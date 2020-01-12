package com.dev.controller;

import java.util.Scanner;

import com.dev.beans.User;
import com.dev.services.ServiceDAO;
import com.dev.services.ServiceDAOImpl;

public class MainApp {

	public static void main(String[] args) {

		ServiceDAO sdao = new ServiceDAOImpl();
		Scanner sc = new Scanner(System.in);
		Boolean res;

		int i=5;

		while(i!=0) {
			System.out.println("Select a option: ");
			System.out.println("1) Create user Profile");
			System.out.println("2) Get Profile Detail");
			System.out.println("3) Update profile");
			System.out.println("4) Delete profile");
			System.out.println("5) exit");
			i=sc.nextInt();
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

				res = sdao.createUser(u);
				if(res)
				{
					System.out.println("User Successfully Added");
				}
				else
				{
					System.out.println("Something went wrong");
				}
				break;

			case 2:

				//retrieve 
				System.out.println("Enter user id");
				int userId = sc.nextInt();
				u = sdao.retrieveUser(userId);
				if(u!=null) {
					System.out.println(u);
				}
				else {
					System.out.println("No such user exist with id: "+userId);
				}
				break;
			case 3:
				//update 
				System.out.println("Enter the Userid:");
				id=sc.nextInt();
				System.out.println("Enter new Username:");
				name=sc.next();
				System.out.println("Enter new  email id:");
				email=sc.next();
				System.out.println("Enter new password:");
				password=sc.next();

				//create object and Insert data
				u = new User();
				u.setEmail(email);
				u.setPassword(password);
				u.setUserid(id);
				u.setUsername(name);
				res = sdao.updateUser(u);

				if(res)
				{
					System.out.println("User data Successfully Updated");
				}
				else
				{
					System.err.println("Somethimg went wrong");
				}
				break;
			case 4:
				//delete
				System.out.println("Enter user id");
				id = sc.nextInt();
				System.out.println("Enter password");
				password = sc.next();

				res = sdao.deleteUser(id,password);
				System.out.println(res+"hhh");
				System.out.println(id);
				System.out.println(password);
				if(res)
				{
					System.out.println("User Successfully Deleted");
				}
				else
				{
					System.out.println("Please enter correct userid and password");
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


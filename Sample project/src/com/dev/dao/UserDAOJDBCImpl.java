package com.dev.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dev.beans.User;
import com.dev.repo.HashMapRepo;

public class UserDAOJDBCImpl implements UserDAO{

	public UserDAOJDBCImpl() {
		try {
			//load the driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	String url = "jdbc:mysql://localhost:123/user_db"+"?user=root&password=root";

	@Override
	public Boolean createUser(User user) {
		String query = "Insert into user_info values (?,?,?,?)";
		try(Connection conn = DriverManager.getConnection(url);
				PreparedStatement pstmt = conn.prepareStatement(query)){

			pstmt.setInt(1, user.getUserid());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getEmail());
			pstmt.setString(4, user.getPassword());
			int i=pstmt.executeUpdate();

			if(i>0) {
				System.out.println("Query OK, 1 row affected");
				return true;
			}
			else {
				System.out.println("Data Insertion Failed");
				return false;

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public User retrieveUser(Integer userId) {
		String query="SELECT  * FROM user_info where user_id="+userId;

		try(Connection conn=DriverManager.getConnection(url);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){

			if(rs.next()) {
				User u= new User();

				u.setUserid(rs.getInt("user_id"));
				u.setUsername(rs.getString("name"));
				u.setEmail((rs.getString("email")));
				return u;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean updateUser(User user) {

		String query="UPDATE user_info SET name=?,email=?,password=? WHERE user_id="+user.getUserid();
		String passQuery="SELECT * FROM user_info WHERE user_id="+user.getUserid();
		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(passQuery)
				){
			if(rs.next()) {

				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());

				int i=pstmt.executeUpdate();
				return true;
			}
			else {
				return false;

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}	

	@Override
	public Boolean deleteUser(Integer userId,String password) {


		String query="DELETE FROM user_info WHERE user_id=? and password=?";

		String passQuery="SELECT * FROM user_info WHERE user_id="+userId+" and password='"+password+"'";

		try(Connection conn=DriverManager.getConnection(url);
				PreparedStatement pstmt=conn.prepareStatement(query);
				Statement stmt=conn.createStatement();
				ResultSet x=stmt.executeQuery(passQuery);
				){
			pstmt.setInt(1,userId);
			pstmt.setString(2,password);
			int i = pstmt.executeUpdate();
			//Process the Results..
			if(x.next()) {
				pstmt.executeUpdate();
				System.out.println("Data Deleted...");
				return true;
			}else {
				System.out.println("Failed to Delete the Data..");

			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}

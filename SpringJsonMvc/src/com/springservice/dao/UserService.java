package com.springservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.springservice.domain.User;
import com.springservice.utility.DBUtility;

public class UserService {

	private Connection connection;

	public UserService() {
		connection = DBUtility.getConnection();
	}

	public int getUserCount() {
		int count = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select count(*) as count from Employee");
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void addUser(User user) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Employee (Name,EmployeeCode,Address,deleteflag) values (?,?, ?, ? )");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmployeeCode());
			preparedStatement.setString(3, user.getAddress());
			preparedStatement.setString(4, user.getDeleteFlag());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int empCode) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Employee where EmployeeCode=?");
			preparedStatement.setInt(1, empCode);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Employee set Name=? where EmployeeCode=?");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(3, user.getEmployeeCode());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Employee");
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("Name"));
				user.setEmployeeCode(rs.getString("EmployeeCode"));
				user.setAddress(rs.getString("Address"));
				user.setDeleteFlag(rs.getString("deleteflag"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(int userId) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Employee where EmployeeCode=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setName(rs.getString("Name"));
				user.setEmployeeCode(rs.getString("EmployeeCode"));
				user.setAddress(rs.getString("Address"));
				user.setDeleteFlag(rs.getString("deleteflag"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}

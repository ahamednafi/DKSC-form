package com.serpro.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serpro.usermanagement.model.User;



public class UserDao {
	private String url = "jdbc:mysql://localhost:3306/registration";
	private String username = "root";
	private String password = "root";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO memberdetails (id,Name,Unit,Taluk,District,FatherName,Address,AdhaarNo,MobNo) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_USER_BY_ID = "select id,Name,Unit,Taluk,District,FatherName,Address,AdhaarNo,MobNo from memberdetails where id =?";
	private static final String SELECT_ALL_USERS = "select * from memberdetails";
	private static final String DELETE_USERS_SQL = "delete from memberdetails where id = ?";
	private static final String UPDATE_USERS_SQL = "update memberdetails set Name = ?,Unit= ?, Taluk =?, District=?,FatherName=?,Address=?,AdhaarNo=?,MobNo=? where id = ?";
	
	
	public UserDao() {
		
	}
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getUnit());
			preparedStatement.setString(4, user.getTaluk());
			preparedStatement.setString(5, user.getDistrict());
			preparedStatement.setString(6, user.getFatherName());
			preparedStatement.setString(7, user.getAddress());
			preparedStatement.setString(8, user.getAdhaarNo());
			preparedStatement.setString(9, user.getMobNo());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("Name");
				String unit = rs.getString("Unit");
				String taluk = rs.getString("Taluk");
				String district = rs.getString("District");
				String fatherName = rs.getString("FatherName");
				String address = rs.getString("Address");
				String adhaarNo = rs.getString("AdhaarNo");
				String mobNo = rs.getString("MobNo");
				user = new User(id, name, unit, taluk,district,fatherName,address,adhaarNo,mobNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("Name");
				String unit = rs.getString("Unit");
				String taluk = rs.getString("Taluk");
				String district = rs.getString("District");
				String fatherName = rs.getString("FatherName");
				String address = rs.getString("Address");
				String adhaarNo = rs.getString("AdhaarNo");
				String mobNo = rs.getString("MobNo");
				users.add(new User(id, name, unit, taluk,district,fatherName,address,adhaarNo,mobNo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	
	
	
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getUnit());
			statement.setString(3, user.getTaluk());
			statement.setString(4, user.getDistrict());
			statement.setString(5, user.getFatherName());
			statement.setString(6, user.getAddress());
			statement.setString(7, user.getAdhaarNo());
			statement.setString(8, user.getMobNo()); 
			statement.setInt(9, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
}

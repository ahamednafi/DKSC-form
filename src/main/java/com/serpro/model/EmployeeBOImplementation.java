package com.serpro.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBOImplementation implements EmployeeBO {

	private static String url ="jdbc:mysql://localhost:3306/registration";
	private static String username = "root";
	private static String password = "root";
	private Connection connection;
	private PreparedStatement prepareStatement;
	private static final String INSERT_QUERY = "INSERT INTO `dkscdetails`(username,password) VALUES(?,?)";
	
	public EmployeeBOImplementation()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int save(Employee e) {
		
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setString(1,e.getUserName());
			prepareStatement.setString(2,e.getPassword());
			return prepareStatement.executeUpdate();
		} catch (SQLException e1) { 
			e1.printStackTrace();
		}
		return 0;
		
	}
	
	

}

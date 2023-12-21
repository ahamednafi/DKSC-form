package com.serpro.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private static final String QUERY = "SELECT * FROM dkscdetails WHERE username=? AND password=?";
	private PreparedStatement prepareStatement;
	private ResultSet res;
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String url = "jdbc:mysql://localhost:3306/registration";
			String user = "root";
			String pass = "root";
			RequestDispatcher dispatcher=null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url,user,pass);
				prepareStatement = connection.prepareStatement(QUERY);
				prepareStatement.setString(1, username);
				prepareStatement.setString(2, password);
				res = prepareStatement.executeQuery();
				if(res.next())
				{
					resp.setContentType("text/html");
					dispatcher = req.getRequestDispatcher("user-list.jsp");
					//resp.sendRedirect("user-list.jsp");
				}
				else 
				{
					dispatcher = req.getRequestDispatcher("signin.html");
				}
				dispatcher.forward(req,resp);
				
			} catch (ClassNotFoundException | SQLException e) { 
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			
			
			
		}
}

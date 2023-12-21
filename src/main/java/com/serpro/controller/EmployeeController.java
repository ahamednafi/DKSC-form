package com.serpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.serpro.model.Employee;
import com.serpro.model.EmployeeBOImplementation;

@WebServlet("/employeecontroller")
public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		Employee e = new Employee(username,password);
		EmployeeBOImplementation emp = new EmployeeBOImplementation();
		int i = emp.save(e);
		
		if(i==1)
		{
			resp.sendRedirect("signin.html");
			
		}
		
		
		
		
		
	}
}

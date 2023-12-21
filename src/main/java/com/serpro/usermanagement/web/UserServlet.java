//package com.serpro.usermanagement.web;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.serpro.usermanagement.dao.UserDao;
//import com.serpro.usermanagement.model.User;
//import com.xadmin.usermanagement.dao.USerDAO;
//
//
//
//
//@WebServlet("")
//public class UserServlet extends HttpServlet {
//
//	
//	private static final long serialVersionUID = 1L;
//	private UserDao userDAO;
//	
//	@Override
//	public void init() throws ServletException {
//		userDAO = new UserDao();
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//			case "/new":
//				showNewForm(request, response);
//				break;
//			case "/insert":
//				insertUser(request, response);
//				break;
//			case "/delete":
//				deleteUser(request, response);
//				break;
//			case "/edit":
//				showEditForm(request, response);
//				break;
//			case "/update":
//				updateUser(request, response);
//				break;
//			default:
//				listUser(request, response);
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}	
//	}
//	
//	
//	private void listUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<User> listUser = userDAO.selectAllUsers();
//		request.setAttribute("listUser", listUser);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//		dispatcher.forward(request, response);
//	}
//	
//	
//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//		dispatcher.forward(request, response);
//	}
//	
//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		try
//		{
//			int id = Integer.parseInt(request.getParameter("id"));
//			User existingUser = userDAO.selectUser(id);
//			response.setContentType("text/html");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//			request.setAttribute("user", existingUser);
//			dispatcher.forward(request, response);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//
//	}
//	
//	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		String name = request.getParameter("name");
//		String unit = request.getParameter("unit");
//		String taluk = request.getParameter("taluk");
//		String district = request.getParameter("district");
//		String fatherName = request.getParameter("fatherName");
//		String address = request.getParameter("address");
//		String adhaarNo = request.getParameter("adhaarNo");
//		String mobNo = request.getParameter("mobNo");
//		User newUser = new User(name,unit,taluk,district,fatherName,address,adhaarNo,mobNo);
//		userDAO.insertUser(newUser);
//		response.sendRedirect("list"); 
//	}
//	
//	
//	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		String name = request.getParameter("name");
//		String unit = request.getParameter("unit");
//		String taluk = request.getParameter("taluk");
//		String district = request.getParameter("district");
//		String fatherName = request.getParameter("fatherName");
//		String address = request.getParameter("address");
//		String adhaarNo = request.getParameter("adhaarNo");
//		String mobNo = request.getParameter("mobNo");
//
//		User book = new User(id,name,unit,taluk,district,fatherName,address,adhaarNo,mobNo);
//		userDAO.updateUser(book);
//		response.sendRedirect("list");
//	}
//	
//	
//	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
//			throws SQLException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		userDAO.deleteUser(id);
//		response.sendRedirect("list");
//
//	}
//	
//	
//}

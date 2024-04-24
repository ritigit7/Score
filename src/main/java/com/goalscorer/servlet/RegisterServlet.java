package com.goalscorer.servlet;

import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.goalscorer.dao.User;
import com.goalscorer.dao.UserDao;
import com.goalscorer.dao.UserDaoImp;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		user.setUsername(request.getParameter("username"));
		user.setEmail(request.getParameter("Email"));
		user.setPassword(request.getParameter("password"));

		if (userDao.addUser(user)) {
			response.sendRedirect("login.jsp?registration=success");
		} else {
			response.sendRedirect("register.jsp?error=1");
		}
	}

}

package com.goalscorer.servlet;

// import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
// import java.io.PrintWriter;

import com.goalscorer.dao.UserDao;
import com.goalscorer.dao.UserDaoImp;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao = new UserDaoImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (userDao.isValidUser(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Match");
			// RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			// dispatcher.forward(request, response);
		} else {
			response.sendRedirect("login.jsp?error=1");
			System.out.println("Error ocuur.");
		}
	}

}

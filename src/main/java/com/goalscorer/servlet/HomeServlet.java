package com.goalscorer.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.goalscorer.servlet.Match;
import com.goalscorer.Util.MatchContainer;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Match ob=new Match();
		ResultSet resultSet2=ob.resultSetMain;
		ArrayList<MatchContainer> matchList = new ArrayList<>();
		 try {
			while (resultSet2.next()){
				MatchContainer container = new MatchContainer();
				
				container.setDate(resultSet2.getString("date"));
				container.setTeam1(resultSet2.getString("team1"));
				container.setTeam2(resultSet2.getString("team2"));
				container.setFirstInningsScore(resultSet2.getInt("first_ings_score"));
				container.setFirstInningsWickets(resultSet2.getInt("first_ings_wkts"));
				container.setSecondInningsScore(resultSet2.getInt("second_ings_score"));
				container.setSecondInningsWickets(resultSet2.getInt("second_ings_wkts"));
				container.setMatchWinner(resultSet2.getString("match_winner"));
				container.setWonBy(resultSet2.getString("won_by"));
				container.setMargin(resultSet2.getString("margin"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("matchList", matchList);

		// response.sendRedirect("home.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}

}

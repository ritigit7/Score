package com.goalscorer.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.util.ArrayList;

//import com.goalscorer.Util.MatchContainer;
//import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.goalscorer.Util.MatchContainer;


/**
 * Servlet implementation class HomeServlet
 */
public class Match extends HttpServlet {
	  String date ;
      String team1;
      String team2 ;
      int firstInningsScore;
      int firstInningsWickets;
      int secondInningsScore ;
      int secondInningsWickets ;
      String matchWinner;
      String wonBy;
      String margin ;
      public  ResultSet resultSetMain;
	private static final long serialVersionUID = 1L;
	private static String url = "jdbc:mysql://localhost:3306/temp";
    private static String username = "root";
    private static String password = "ritiksql";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establishing connection
            connection = DriverManager.getConnection(url, username, password);

            // Creating statement
            statement = connection.createStatement();

            // SQL query for SELECT operation
            String query = "select date ,team1,team2,first_ings_score,first_ings_wkts,second_ings_score,second_ings_wkts,match_winner,won_by,margin from book_ipl22_ver_33";

            // Executing query
            resultSet = statement.executeQuery(query);
    
            // Processing results
            ArrayList<MatchContainer> matchList = new ArrayList<>();
            while (resultSet.next()) {
            	
            	MatchContainer container = new MatchContainer();
                // Retrieve data from each row
                String date = resultSet.getString("date");
                String team1 = resultSet.getString("team1");
                String team2 = resultSet.getString("team2");
                int firstInningsScore = resultSet.getInt("first_ings_score");
                int firstInningsWickets = resultSet.getInt("first_ings_wkts");
                int secondInningsScore = resultSet.getInt("second_ings_score");
                int secondInningsWickets = resultSet.getInt("second_ings_wkts");
                String matchWinner = resultSet.getString("match_winner");
                String wonBy = resultSet.getString("won_by");
                String margin = resultSet.getString("margin");
                
                container.setDate(date);
				container.setTeam1(team1);
				container.setTeam2(team2);
				container.setFirstInningsScore(firstInningsScore);
				container.setFirstInningsWickets(firstInningsWickets);
				container.setSecondInningsScore(secondInningsScore);
				container.setSecondInningsWickets(secondInningsWickets);
				container.setMatchWinner(matchWinner);
				container.setWonBy(wonBy);
				container.setMargin(margin);
				matchList.add(container);

	                          
            }
            request.setAttribute("matchList", matchList);

			// response.sendRedirect("home.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

		
		
//		ArrayList<MatchContainer> matchList = new ArrayList<>();
//		for (int i = 0; i < 12; i++) {
//			MatchContainer container = new MatchContainer();
//			container.setStatus("Live");
//			container.setTeam1("RM");
//			container.setTeam2("BRA");
//			container.setT1Score(4);
//			container.setT2Score(2);
//			container.setTime("78'");
//			container.setTournament("La Liga");
//			matchList.add(container);
//
//		}
//
//		request.setAttribute("matchList", matchList);
//
//		// response.sendRedirect("home.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//		dispatcher.forward(request, response);
	}

}

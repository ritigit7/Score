package com.goalscorer.servlet;

import com.goalscorer.Util.MatchDataContainer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatchData extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String url = "jdbc:mysql://localhost:3306/temp";
    private static String username = "root";
    private static String password = "ritiksql";
//    private static int t=0;
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
//            t=Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String query = "SELECT * FROM ipl_data";

            resultSet = statement.executeQuery(query);

            ArrayList<MatchDataContainer> playerList = new ArrayList<>();
            
            while (resultSet.next()) {
                String playerName = resultSet.getString("players");
                int runs = resultSet.getInt("run");

                // Check if playerName is numeric, and skip if it is
                MatchDataContainer player = new MatchDataContainer();
//                if (!isNumeric(playerName)) {
                    player.setPlayerName(playerName);
                    player.setRuns(runs);
                    playerList.add(player);
//                }
//                else {
//                	
////                	player.setNo(t);
////                	System.out.print();
//                }
            }

            request.setAttribute("playerList", playerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("players.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

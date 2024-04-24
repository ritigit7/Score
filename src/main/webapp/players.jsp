<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.goalscorer.Util.MatchDataContainer" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>Player List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Player Performance List</h1>
<table border="1">
    <thead>
        <tr>
            <th>Player Name</th>
            <th>Runs Scored</th>
        </tr>
    </thead>
    <tbody>
        <% 
        ArrayList<MatchDataContainer> playerList = (ArrayList<MatchDataContainer>) request.getAttribute("playerList");
        if (playerList != null) {
            for (MatchDataContainer player : playerList) {
                out.println("<tr><td>"+ player.getPlayerName() + "</td><td>" + player.getRuns() + "</td></tr>");
            }
        }
        %>
    </tbody>
</table>
</body>
</html>

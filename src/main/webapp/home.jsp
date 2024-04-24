<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.goalscorer.Util.MatchContainer" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home-GoalScorer</title>
     <link rel="stylesheet" href="style.css">
    <style>
    	body{
    		margin-bottom: 100px;
    	}
    	
    	#imgLogin{
        	height:40px;
        	width:40px;
        	display:inline-block;
    		margin-top:17px;
    		padding-top:20px;
    		margin-left:340px;
    		margin-right:4px;
    		padding-right:1px;
        }
        
        .logout-link{
        	font-size:18px;
    		display:inline-block;
    		margin-top:38px;
    		margin-left:10px;
    		margin-right:0px;
    		margin-bottom:45px;
    		padding:6px;
    		padding-right:8px;
    		text-decoration:none;
    		border: 3px solid #7E8286;
    		border-radius: 5px;
    		background-color:#2D343C;
        	color:#fff;
        	font-weight:bold;
        	transition:color 0.3s ease;
        }
        
        .logout-link:hover {
            color: #d9e2f4;;
    		text-transform: uppercase;
        }
    
    	h5{
    		font-size:24px;
    		display:inline-block;
    		margin-top:24px;
    		padding-top:20px;
    		margin-left:4px;
    		margin-right:0px;
    		padding-right:1px;
    	}
    	
    	.match-container {

padding: 25px;
  margin-right: 4px;
  width: 270px;
  border: 3px solid #bdc2c8;
  border-radius: 12px;
  background-color: #222224ed;
  transition: transform 0.2s;
  display: inline-block;
  margin-left: 42px;
  margin-top: 40px;
}

.match-container:hover {
box-shadow: 0 0 20px rgba(0, 0, 0, 1);
    transform: scale(1.05);
}

.match-status {
padding-left: 15px;
padding-right: 15px;
   font-weight: bold;
  color: #e50a0a;
  font-size: 14px;
}

.match-info {
    margin-top: 25px;
  font-size: 20px;
  color: #fff;
  padding-left: 15px;
  word-spacing: 30px;
   display: grid;
    grid-template-columns: repeat(2, 1fr);
    gap: 10px;
}

.tour{
	margin-left: 100px;
  color: #f08d23;
  font-weight: bold;
  font-size: 25px;
}

.team-column, .score-column {
    display: flex;
    flex-direction: column;
}
.team-column div, .score-column div {
    padding: 5px; /* Adjust the padding as needed */
}
.alg {
    position: relative;
    left: -100px;
    top: 20px;
}

    </style>
</head>
<body>
    <header>
     <img  class="alg" src="images/ipl.png" style="height: 70px;" alt="Logo">
        <h1 style= "margin-top:40px;"></h1>
        <img id="imgLogin" src="images/login.png" alter="login">
         <%
        	// Retrieve the session object
        	HttpSession session1 = request.getSession(false);

        	// Check if the session is not null and the username attribute is set
        	if (session1 != null && session1.getAttribute("username") != null) {
            	// Get the username from the session
            	String username = (String) session1.getAttribute("username");
    	%>
        <h5> <%= username %></h5>
        <%
        	} else {
            	// Redirect to the login page if the session is not valid
            	response.sendRedirect("login.jsp");
        	}
    	%>
    	
    	
    	<form action="LogoutServlet" method="post">
    		<button class="logout-link" type="submit">LogOut</button>
    	</form>
    </header>

    <%
    	// Retrieve the ArrayList of MatchContainer from the request object
    	ArrayList<MatchContainer> matchList1 = (ArrayList<MatchContainer>) request.getAttribute("matchList");
    Map<String, String> teamLogoMap = new HashMap<>();
    teamLogoMap.put("Chennai", "images/csk.png");
    teamLogoMap.put("Delhi", "images/dc.png");
    teamLogoMap.put("Banglore", "images/rcb.png");
    teamLogoMap.put("Gujarat", "images/gt.png");
    teamLogoMap.put("Hyderabad", "images/srh.png");
    teamLogoMap.put("Kolkata", "images/kkr.png");
    teamLogoMap.put("Mumbai", "images/mi.png");
    teamLogoMap.put("Lucknow", "images/lsg.png");
    teamLogoMap.put("Punjab", "images/pbks.png");
    teamLogoMap.put("Rajasthan", "images/rr.png");
    	// Check if the ArrayList is not null and not empty
    	if (matchList1 != null && !matchList1.isEmpty()) {
        	// Iterate through the ArrayList and display its content
        		int vs=0;
        	for (MatchContainer match : matchList1) {
        		vs++;
        		String date = match.getDate();
        		String team1 = match.getTeam1();
        		String team2 = match.getTeam2();
        		int firstInningsScore = match.getFirstInningsScore();
        		int firstInningsWickets = match.getFirstInningsWickets();
        		int secondInningsScore = match.getSecondInningsScore();
        		int secondInningsWickets = match.getSecondInningsWickets();
        		String matchWinner = match.getMatchWinner();
        		String wonBy = match.getWonBy();
        		String margin = match.getMargin();	
        		String winner;
        		
        		if(firstInningsScore>secondInningsScore){
        			winner=team1;
        		}else{
        			winner=team2;
        		}
        		
        		%>
            	<div class="match-container">
   				 <div class="tour">Match <%=vs %></div>
    				<div class="match-status">
        		<span style="float: right;"><%= date %></span>
    			</div>
    			<div class="match-info">
    				<div class="team-column">
        			<div><%= team1 %></div>
        			<div><img src=<%=teamLogoMap.get(team1) %> class="team-logo"></div>
        			<div><%= firstInningsScore %>/<%= firstInningsWickets %></div>
    			</div>
    			<div class="score-column">
        			<div><%= team2 %></div>
        			<div><img src=<%=teamLogoMap.get(team2) %> class="team-logo"></div>
        			<div><%= secondInningsScore %>/<%= secondInningsWickets %></div>
        			
   				</div >
   
      	
</div>
    	 <div style="font-size: 15px; color: #fff; padding-left: 40px;">
           <div>	<%= winner %> won by <%= margin%> <%= wonBy%></div>
</div>		
			</div>
            	
	<%
        	}
    	} else {
	%>
        	<div class="match-container">No data available</div>
	<%
    	}
	%>

    <footer>
         &copy; 2022 IPL. All rights reserved.
    </footer>
</body>
</html>
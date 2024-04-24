<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>
    <link rel="stylesheet" href="style.css">
    <Style>
    
    	.container{
    		height:400px;
    		width:420px;
    	}
    	
    	.container p{
    		margin-top:0px;
    	}
    	
    	form{
    		padding:20px;
    	}
    	
    	input[type=text] ,input[type=password] {
  			width: 68%;
  			box-sizing: border-box;
  			border: 2px solid #ccc;
  			border-radius: 4px;
  			font-size: 15px;
  			background-color: white;
  			padding: 7px;
  			margin:16px;
		}
		
		.container button{
			width:32%;
			margin-top:20px;
		}
		.alg {
    position: relative;
    left: -100px;
    top: 20px;
}
    	
    </Style>
</head>
<body>
    <header>
        <img  class="alg" src="images/ipl.png" style="height: 70px;" alt="Logo">
        <h1 style= "margin-top:40px;">IPL Score Card</h1>
    </header>
`
    <div class="container">
        <h1>Log In</h1>
        <hr>
        <form  action="LoginServlet" method="post">
        	<label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="username" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="password" required><br>
            <button type="submit">LogIn</button>
        </form>
        
        <%-- Error message if login fails --%>
        <% String error=request.getParameter("error");
        		if(error!=null && error.equals("1")){ %>
        			<p style="color:red;">Invalid Username or Password</p>
        <% } %>

        <%-- Success message if register successful --%>
        <% String success=request.getParameter("registration");
        		if(success!=null && success.equals("success")){ %>
        			<p style="color:green;">User Registration Successful. Please LogIn.</p>
        <% } %>
        
        <hr>
        <a class="links" href="register.jsp">Register</a>
    </div>

    <footer>
         &copy; 2022 IPL. All rights reserved.
    </footer>
</body>
</html>

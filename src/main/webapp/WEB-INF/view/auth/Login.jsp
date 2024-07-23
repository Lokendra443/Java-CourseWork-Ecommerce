<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

    <div class="login-box">
        <h2>Login</h2>

        <form action="<%= request.getContextPath() %>/login" method="post">
            <div class="row">
                <div class="col">
                    <label for="email">User name</label>
                  	<% String username = request.getParameter("Username_l"); %>
                    
                    <input type="text" id="email" name="Username_l"  value="<%= (username!= null) ? username : "" %>">
                    <%
                    
                    String  error_user = (String)request.getAttribute("user_notfound");
                    	if(error_user !=null){
                     %>
							  <div class="error-message" style="text-align: center; margin-top:10px; color: red;" ><%=error_user %></div>
                     <%}
                    	
            		%>
                    
                    
                </div>
            </div>


            <div class="row">
                <div class="col">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="Password_l" > 
                    <%
                    
                    String  error_password = (String)request.getAttribute("incorrect_password");
                    	if(error_password !=null){
                     %>
							  <div class="error-message" style="text-align: center; margin-top:10px; color: red;" ><%=error_password %></div>
                     <%}
                    	
            		%>     
                </div>
               
            </div>


            <button type="submit">Login</button>
              <%
                    
                    String  logout = (String)request.getAttribute("logout");
                    	if(logout !=null){
                     %>
							  <div class="logout-message" style="text-align: center; margin-top:10px; color: green;" ><%=logout %></div>
                     <%}
                    	
            	%>

            <div class="register-link">
            <hr/>

                Don't have an account? <a href="<%= request.getContextPath() %>/register">Register</a>
            </div>
            
            </form>
            </div>
            
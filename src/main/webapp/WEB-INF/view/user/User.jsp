<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
</head>
   
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/userprofile.css"> 
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css" />
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
 	 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css" />
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-ZtnodjQi6r8FV/v8yNQz+F+GjH4d4MxLLFOK11F2HH6+O1SARw2z4ljVtR8px4z2wtbLE+Kf7sLXLZB9b/fYVQ==" crossorigin="anonymous" referrerpolicy="no-referrer" /> <!-- Link to Font Awesome for icons -->
 	<script src="https://kit.fontawesome.com/1165876da6.js" crossorigin="anonymous"></script> 	

<body>
<jsp:include page="/includes/header.jsp"></jsp:include>

    <div class="container">
       

        <div class="dashboard">

            <img src="${pageContext.request.contextPath}/assets/icons/png-transparent-avatar-user-computer-icons-software-developer-avatar-child-face-heroes-removebg-preview.png" alt="" srcset=""  width="200px" height="auto" style="margin-top: 20px; border-radius: 180px;">
            <h2 style="margin: 10px 0px">Welcome  <%= ((User)session.getAttribute("user")).getUsername()%> </h2>
            <div style="display: flex; align-items: center; font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;"  >
                    <div style="text-align: right; margin-left: 18%;" >
                            <label  class="dashboard_question" style="margin-left: 8%;">First name:</label>
                            <label  class="dashboard_question" style="margin-left: 8%;">Last name:</label>
                            <label  class="dashboard_question">Phone number:</label>
                            <label  class="dashboard_question" style="margin-left: 16%;">Email:</label>
                            <label  class="dashboard_question" style="margin-left: 18%;">Role:</label>
                            <label  class="dashboard_question" style="margin-left: 11%;">Address:</label>
                            <label  class="dashboard_question" style="margin-left: 17%;">Gender:</label>
                            <label  class="dashboard_question" style="margin-left: 8%;">Birth date:</label>
                    </div>
                    <div style="text-align: left; margin-left: 10%;  " >
                        <label  class="dashboard_Ans"><%= ((User)session.getAttribute("user")).getUsername()%> </label>
                        <label  class="dashboard_Ans"><%= ((User)session.getAttribute("user")).getLastname()%> </label>
                        <label  class="dashboard_Ans"><%= ((User)session.getAttribute("user")).getNumber()%> </label>
                        <label  class="dashboard_Ans" ><%= ((User)session.getAttribute("user")).getEmail()%> </label>
                        <label  class="dashboard_Ans" >User</label>
                        <label  class="dashboard_Ans" ><%= ((User)session.getAttribute("user")).getAddress()%> </label>
                        <label  class="dashboard_Ans" ><%= ((User)session.getAttribute("user")).getGender()%> </label>
                        <label  class="dashboard_Ans"><%= ((User)session.getAttribute("user")).getDob()%></label>
                </div>
            </div>  
        </div>



        <div class="main-content">
            <h1>Profile Settings</h1>
            <form action="<%=request.getContextPath()%>/user" method="post">
                <div class="row">
                    <!-- <div class="col">
                        <label for="id">ID</label>
                        <input type="text" id="id" name="id" required>
                    </div> -->

                    <div class="col">
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                    <div class="col">
                        <label for="dob">DOB</label>
                        <input type="date" id="dob" name="dob" required>
                    </div>
                    
                </div>


                <div class="row">
                    <div class="col">
                        <label for="firstName">First Name</label>
                        <input type="text" id="firstName" name="firstName" required>
                    </div>
    
                    <div class="col">
                        <label for="lastName">Last Name</label>
                        <input type="text" id="lastName" name="lastName" required>
                    </div>
                </div>
    
    
                <div class="row">
                    <div class="col">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" required>
                    </div>

                    <div class="col">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="tel" id="phoneNumber" name="phoneNumber" required>
                    </div>

                </div>
    
    
                <div class="row">
                    <div class="col">
                        <label for="gender">Gender</label>
                        <select id="gender" name="gender" required>
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="other">Other</option>
                        </select>
                    </div>
    
                    <div class="col">
                        <label for="address">Address</label>
                        <input type="text" id="address" name="address" required>
                    </div>
                </div>
    			
    
    
                <div class="row">
                   

                    <!-- <div class="col">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>
                    </div> -->

                </div>
    
    
                
    
                <button type="submit">Update </button>
                
        
            </form>



        </div>
    </div>
</body>
</html>

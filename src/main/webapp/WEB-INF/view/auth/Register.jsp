<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>

    <div class="container">
        <h2>Register your account</h2>

        <form action="<%= request.getContextPath() %>/register" method="post">
            <div class="row">
                <div class="col">
                    <label for="firstName">First Name</label>
                    <% String firstName = request.getParameter("Firstname"); %>
                    <input type="text" id="firstName" name="Firstname" minlength="3" value="<%= (firstName != null) ? firstName : "" %>" required>
                </div>

                <div class="col">
                    <label for="lastName">Last Name</label>
                    <% String lastName = request.getParameter("Lastname"); %>
                    <input type="text" id="lastName" name="Lastname" minlength="3" value="<%= (lastName != null) ? lastName : "" %>" required>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <label for="username">Username</label>
                    <% String username = request.getParameter("Username"); %>
                    <input type="text" id="username" name="Username" minlength="5" value="<%= (username != null) ? username : "" %>" required>
                </div>

                <div class="col">
                    <label for="email">Email</label>
                    <% String email = request.getParameter("Email"); %>
                    <input type="email" id="email" name="Email" value="<%= (email != null) ? email : "" %>" required>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <label for="phoneNumber">Phone Number</label>
                    <% String phoneNumber = request.getParameter("Number"); %>
                    <input type="text" id="phoneNumber" name="Number" minlength="10" pattern="[0-9]{10}" value="<%= (phoneNumber != null) ? phoneNumber : "" %>" required>
                </div>

                <div class="col">
                    <label for="address">Address</label>
                    <% String address = request.getParameter("Address"); %>
                    <input type="text" id="address" name="Address" minlength="5" value="<%= (address != null) ? address : "" %>" required>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <label for="gender">Gender</label>
                    <% String gender = request.getParameter("Gender"); %>
                    <select id="gender" name="Gender" required>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other" >Other</option>
                    </select>
                </div>

                <div class="col">
                    <label for="dob">DOB</label>
                    <% String dob = request.getParameter("Date"); %>
                    <input type="date" id="dob" name="Date" value="<%= (dob != null) ? dob : "" %>" required>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="Password" minlength="8" required>
                </div>
                <div class="col">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" minlength="8" required>
                </div>
            </div>

            <button type="submit">Register</button>

            	<% 
            		String sucess = (String)request.getAttribute("success"); 
                    String  error = (String)request.getAttribute("error");
            		if(sucess !=null){
            		
            	%>
            		         
            			   <div class="success-message" style="text-align: center; margin-top:10px; color: green; font-weight: 600" ><%=sucess %></div>
            	<%}
            		else if(error != null){%>
            			    <div class="success-message" style="text-align: center; margin-top:10px; color: red; font-weight: 600" ><%=error %></div>		
            							  <%}            			
            	%>

            <div class="login-link">
                <hr>
                Already have an account? <a href="<%= request.getContextPath() %>/login">Login</a>
            </div>
          
        </form>
    </div>

</body>
</html>

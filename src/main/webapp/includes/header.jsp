<%@page import="model.User"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/navbar.css"/>
 <script src="https://kit.fontawesome.com/1165876da6.js" crossorigin="anonymous"></script>

<nav>
        <div class="icon">
            <img src="${pageContext.request.contextPath}/assets/logo/logomain2.png"  alt="GigaCctv Logo" class="logo-main">
        </div>
        <div class="search_box">
        <form id="searchForm" action="${pageContext.request.contextPath}/home" method="get">
        		<input type="search" name="search_product" placeholder="Search here"></input>
        		<span class="fa fa-search" onclick="submitForm()"></span>
        </form>
           
           
        </div>
        <ol>
             <li><a href="<%= request.getContextPath() %>/home">Home</a></li>
             <li><a href="<%= request.getContextPath() %>/user">User</a></li>
            <li><a href="<%= request.getContextPath() %>/about-us">About us</a></li>

            <%
            		User user = (User)session.getAttribute("user");
            	if(user != null && user.getRoleId() == 1){
            	%>
                    <li><a href="<%= request.getContextPath() %>/user/cart">Cart</a></li>
            	<%} 
            %>
            <%
            	if((User)session.getAttribute("user") != null){
            	%>
					<li><a href="<%= request.getContextPath() %>/user/order">Orders</a></li>
            	<%}
            %>
            
                          <%
            	if((User)session.getAttribute("user") == null){
            	%>
                    <li><a href="<%= request.getContextPath() %>/login">Login here</a></li>
            	<%}
            	else{
            	%>
                    <li><a href="<%= request.getContextPath() %>/Logout">Logout here</a></li>
            	<%}
            
            %>
            	
            
                         
            
            
        </ol>
    </nav>
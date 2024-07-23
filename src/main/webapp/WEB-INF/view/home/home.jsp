<%@page import="model.User"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"> 
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css" />
 <script src="${pageContext.request.contextPath}/js/home.js" src="home.js"></script>
</head>
<body>
		<jsp:include page="/includes/header.jsp"></jsp:include>
    <div id="banner">
        <div class="middle-image">
            <img src="${pageContext.request.contextPath}/uploads/product_images/hikvisiontopimage.png" alt="Middle Image"> <!-- Middle image -->
        </div>
        <div>
            <h1 class="big-heading">Hikvision <span style="color: #675CDB">Ds Series</span> Camera</h1> <!-- Main heading -->
            <h2 class="another-heading">Your strongest wall of defence</h2> <!-- Subheading -->
            <div class="button-container">
                <button class="shop-button">SHOP NOW</button> <!-- Shop button -->
                <div>
                    <a href="#product-container" class="clickable-image"> <!-- Anchor tag to scroll to product container -->
                        <img src="${pageContext.request.contextPath}/assets/icons/downarrow.png" alt="Clickable Image" class="clickable-image"> <!-- Clickable image -->
                    </a>
                </div>
            </div>
        </div>
        
    </div>
    <div id="products">
        <span class="products-text">All Products</span> <!-- Text indicating all products -->
       
       <form action="<%=request.getContextPath()%>/home" method="get">
       
			<div id="popup" class="popup">
			       <h2>Search by Price</h2>
				    <div class="input-group">
				        <label for="min-price">Minimum Price:</label>
				        <input type="number" id="min-price" placeholder="Enter min price" name="min-price" required="required">
				    </div>
				    <div class="input-group">
				        <label for="max-price">Maximum Price:</label>
				        <input type="number" id="max-price" placeholder="Enter max price" name="max-price" required="required">
				    </div>
				    <button onclick="searchByPrice()">Search</button><br>
					<span style="margin-left: 42%; text-decoration: underline; cursor: pointer;" onclick="togglePopup()" >Close</span>
					
		    </div>   
	   
	    </form>
	        
            <img src="${pageContext.request.contextPath}/assets/icons/filterimage.png" alt="Clickable Image" class="products-image" onclick="togglePopup()"> <!-- Filter image -->
 
    	</div>
    <div id="product-container" class="product-container">
    <c:forEach var="product" items="${productList}">
    
	    	 <div class="product-card">
	    <a href="${pageContext.request.contextPath}/ViewProductController?product_ID=${product.id}" >
	         <div class="product-image">
				<img src="<%=request.getContextPath()%>/uploads/product_images/<c:out value="${product.image}"></c:out>">
	         </div>
	         <div class="product-details">
	             <h3 class="product-name">${product.title} </h3> <!-- Product name -->
	             <div style="display: flex; justify-content: center;">
	             <c:if  test= "${product.discountPercent != null}">
	             	<del style="color: red; margin: 0px 10px 0px 0px;" class="product-price" >Rs. ${product.actualPrice}</del>
	             	<p class="product-price">Rs. ${product.discountedPrice}</p> <!-- Product price -->
	             </c:if>
	             </div>
	        </div>
	    
	         <div class="add-to-cart" style="text-align: center;">
	             <label class="add-to-cart-button">Shop now</lable> <!-- Add to cart button -->
	         </div>
	  </a>
     </div>
    
    </c:forEach>
	
     
    
         
     

    </div>
    
	<jsp:include page="/includes/footer.jsp"></jsp:include>
</body>



</html>
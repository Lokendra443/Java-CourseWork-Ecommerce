<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${productDetail.title}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product-desc.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashboard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" />
    
    

</head>
<body>
				<jsp:include page="/includes/header.jsp"></jsp:include>

	    <div class="__detail-main">
        <div class="__detail-image-side">
            <div class="__thumbnail-image">
                <img src="${pageContext.request.contextPath}/uploads/product_images/${productDetail.image}" width="300" height="300" />
            </div>
        </div>
        <div class="__detail-desc-side">
            <div class="__detail-desc-header">
                <p class="__desc-new">New</p>
                <p class="__desc-model"></p>
                <p class="__desc-title">${productDetail.title}</p>
                <hr>
            </div>
            <div class="__detail-desc-body">
                <div class="__detail-text">
                <ul>
                	<li>
                		<p>Model number ${productDetail.modelNo}</p>
                	</li>
                	<li>
                		<p>${productDetail.description}</p>
                	</li>
                	<li>
                		<p>Made by ${productDetail.brand}</p>
                	</li>
                	
                	
                </ul>
                  
                </div>
                <div class="__pricing">
                    <p class="__pricing-text">
                        <span class="__text-danger">
                            <strike>Rs. ${productDetail.actualPrice}</strike>
                        </span>
                        <span>
                            Rs. ${productDetail.discountedPrice} /-
                        </span>
                    </p>
                </div>
                <div class="__add-cart-form" style="display: flex;">
                   
                         <%
			            	if((User)session.getAttribute("user") != null){
			            	%>
			            		 <form action="<%=request.getContextPath()%>/ViewProductController" method="post">
								 		<input type="hidden" value="${productDetail.id}" name="product_id">
								 		<button class="__btn __btn-success __add-to-card-btn">Add to cart</button>
								 </form>
			            	<%}
			            	else{
			            	%>
			                   <a class="__btn __btn-success __add-to-card-btn" style="background: #13A2D3;" href="<%=request.getContextPath()%>/login">Login to access</a>
			            	<%}
			            
           				 %>
                        
                        
                       
                    
                </div>
                <br>
				<p>Avaliable Stock  <strong style="color:black; font-weight: 800" >${productDetail.quantity}</strong></p>
            </div>
        </div>
    </div>
	<jsp:include page="/includes/footer.jsp"></jsp:include>



</body>
</html>
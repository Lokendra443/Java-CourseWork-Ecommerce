<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/cart.css"/>
    
</head>

<body>
    <jsp:include page="/includes/header.jsp"></jsp:include>
    <div class="__cart-container">
        <div class="__cart-header">
            <h1 class="f-raleway">
                Shopping Cart
            </h1>
        </div>
        
      <form action="<%=request.getContextPath()%>/user/order" method="post">
        <c:forEach var="products" items="${inCart}" varStatus="loop"> 
            <div class="__cart-body">
                <div class="__cart-item">
                    <div>${loop.index + 1}</div>
                    <img src="<%=request.getContextPath()%>/uploads/product_images/<c:out value="${products.image}"></c:out>">
                    <div>${products.modelNo}</div>
                    <div>${products.title}</div>
                    <div>
                        <label for="quantity_${loop.index}">QTY</label>
                        <input type="number" min="1" max="10" value="0" name="stocks[${loop.index}]" id="quantity${loop.index}" onchange="updateTotal(${loop.index}, ${products.discountedPrice})">
                    </div>
                    <div id="total${loop.index}" class="totalPrice">Total Price : Rs. ${products.discountedPrice}</div>
                    
                    <div><a href="${pageContext.request.contextPath}/user/cart?deleteCartID=${products.cartID}" style="color: #ff4052">Delete Items</a></div>
                
                <input type="hidden" name="total_${loop.index}" id="total_${loop.index}" value="">
                 <input type="hidden" name="product_${loop.index}"  value="${products.id}">
        		<input type="hidden" name="title_${loop.index}" value="${products.title}">
        		<input type="hidden" name="productID_${loop.index}" value="${products.cartID}">
								
				        		
        		
        		
        		
                </div>
            </div>
        </c:forEach>
     	<%
     		if(request.getAttribute("inCart") !=null && !((List)request.getAttribute("inCart")).isEmpty()){
     			%>
     			 <div class="__cart-footer">
                 <button>Confirm Order</button>
             	</div>
     			<% 
     			
     		}
     		else{
     			%>
     			<div style="display: flex; justify-content: center; flex-direction: row; text-align: center;" >
					<img alt="" src="${pageContext.request.contextPath}/assets/icons/empty-cart.png" style="width: 50%; height: 100%">   
     			</div>
 
     			<% 
     		}
     	
     	
     	%>
     
       
        </form>
        
        <script>
    function updateTotal(index, price) {
        var quantityInput = document.getElementById('quantity' + index);
        var totalPriceElement = document.getElementById('total' + index);
        var titleInput = document.getElementById('total_' + index); // Input field
        
        
        var quantity = parseInt(quantityInput.value);
        var totalPrice = quantity * price;
        totalPriceElement.textContent = 'Total Price : Rs. ' + totalPrice;
        
        titleInput.value = totalPrice;
    }
</script>
        
          
    </div>
</body>

</html>

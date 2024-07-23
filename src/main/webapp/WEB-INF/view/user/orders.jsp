<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <h1 class="f-raleway">Orders Items</h1>
        </div>
        <div style="display: flex; justify-content: center;">
        <table class="__cart-table">
            <thead>
                <tr>
                    <th>Index</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <!-- Add more header fields as needed -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td>${order.productName}</td>
                        <td>${order.quantity}</td>
                        <!-- Add more fields as needed -->
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
        </div>
        <div class="__cart-footer">
            <!-- Footer content here -->
        </div>
    </div>
</body>

</html>

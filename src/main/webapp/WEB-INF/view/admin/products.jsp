<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products | Admin</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/popup.css" />
<style>
.__danger-link {
	color: red;
	text-decoration: underline;
}

.__text-success {
	color: #32a852;
}
.__flex-with-gap{
	display:flex;
	gap: 0.5rem;
}
</style>
</head>
<body>
	<div class="__window">
		<div class="__nav">
			<jsp:include page="/includes/nav.jsp"></jsp:include>
		</div>
		<div class="__container">
			<div class="__container-header">
				<div class="__header">Manage Products</div>
			</div>
			<div class="__container-body">
				<div class="__container-body-header">
					<a href="<%=request.getContextPath()%>/admin/product/add"
						class="__btn __btn-primary">Add Product</a>
				</div>
				<%
				String successMessage = request.getParameter("success");
				if (successMessage != null && !successMessage.isEmpty()) {
				%>
				<p class="__text-success"></p>
				<div id="popup" class="popup">
					<div class="popup-content">
						<span class="close" id="closePopup">&times;</span>
						<h2>Done !</h2>
						<p style="margin-top: 2rem;"><%=successMessage%></p>
					</div>
				</div>
				<%
				}
				%>
				<%
				String errorMessage = request.getParameter("error");
				if (errorMessage != null && !errorMessage.isEmpty()) {
				%>
				<p class="__text-success"></p>
				<div id="popup" class="popup">
					<div class="popup-content">
						<span class="close" id="closePopup">&times;</span>
						<h2>Failed !</h2>
						<p style="margin-top: 2rem;"><%=errorMessage%></p>
					</div>
				</div>
				<%
				}
				%>
				<div class="__container-body-main">
					<table class="__table">
						<thead>
							<tr>
								<th>SN</th>
								<th>Image</th>
								<th>Title</th>
								<th>Brand</th>
								<th>Model</th>
								<th>Qty</th>
								<th>Actual Price</th>
								<th>Discounted Price</th>
								<th>Discount %</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="counter" value="1" />
							<c:forEach var="product" items="${listOfProduct}">
								<tr>
									<td><c:out value="${counter}" /></td>
									<td><img
										src="<%= request.getContextPath()%>/uploads/product_images/<c:out value="${product.image}"></c:out>"
										width="100" height="100" /></td>
									<td><c:out value="${product.title}"></c:out></td>
									<td><c:out value="${product.brand}"></c:out></td>
									<td><c:out value="${product.modelNo}"></c:out></td>
									<td><c:out value="${product.quantity}"></c:out></td>
									<td>Rs. <c:out value="${product.actualPrice}"></c:out></td>
									<td>Rs. <c:out value="${product.discountedPrice}"></c:out></td>
									<td><c:out value="${product.discountPercent}"></c:out>%</td>

									<td >
										<div class="__flex-with-gap">
											<a class="__btn __btn-primary" href="<%= request.getContextPath() %>/admin/product/edit?id=<c:out value="${product.id}"></c:out>">Edit
											</a>
	
											<form method="post"
												action="<%= request.getContextPath() %>/admin/product/delete?id=<c:out value="${product.id}"></c:out>">
												<button type="submit" class="__btn __btn-danger">Delete</button>
											</form>
										</div>
									</td>
								</tr>
								<c:set var="counter" value="${counter + 1}" />
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>
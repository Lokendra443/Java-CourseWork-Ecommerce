<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders | Admin</title>
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

.__flex-with-gap {
	display: flex;
	gap: 0.5rem;
}
.green-text {
    color: green;
    font-weight:600;
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
				<div class="__header">Orders</div>
			</div>
			<div class="__container-body">

				<div class="__container-body-main">
					<table class="__table">
						<thead>
							<tr>
								<th>Sn.</th>
								<th>Customer Name</th>
								<th>Product Name</th>
								<th>Quantity</th>
								<th>Ordered On</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="counter" value="1" />
							<c:forEach var="order" items="${listOfOrder}">
								<tr>
									<td><c:out value="${counter}" /></td>
									<td><c:out value="${order.customerName}" /></td>
									<td><c:out value="${order.productName}" /></td>
									<td><c:out value="${order.quantity}" /></td>
									<td><c:out value="${order.orderedon}" /></td>
									<td
										<c:if test="${order.status == 'delivered'}">class="green-text"</c:if>>
										<c:out value="${order.status}" />
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Messages | Admin</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />

<style>
.__danger-link {
	color: red;
	text-decoration: underline;
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
				<div class="__header">Contact Messages</div>
			</div>
			<div class="__container-body">
				<div class="__container-body-main">
					<table class="__table">
						<thead>
							<tr>
								<th>Sn.</th>
								<th>Name</th>
								<th>Email</th>
								<th>Phone Number</th>
								<th>Message</th>
								<th>Date</th>
								<th>Time</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="counter" value="1" />
							<c:forEach var="message" items="${listOfMessages}">
								<tr>
									<td><c:out value="${counter}" /></td>
									<td><c:out value="${message.name}"></c:out></td>
									<td><c:out value="${message.email}"></c:out></td>
									<td><c:out value="${message.phoneNumber}"></c:out></td>
									<td><c:out value="${message.message}"></c:out></td>
									<td><c:out value="${message.date}"></c:out></td>
									<td><c:out value="${message.time}"></c:out></td>
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
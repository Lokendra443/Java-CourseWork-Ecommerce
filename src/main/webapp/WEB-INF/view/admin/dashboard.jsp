<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard | Admin</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/dashboard.css" />
</head>
<body>
	<div class="__window">
		<div class="__nav">
			<jsp:include page="/includes/nav.jsp"></jsp:include>
		</div>
		<div class="__container">
			<div class="__container-header">
				<div class="__header">Dashboard</div>
			</div>
			<div class="__container-body">
				<h1>Hello, admin!</h1>
				<div class="__row">
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/products.png" width="60" height="60" />
							</div>
							<div>Total Products: ${totalProducts}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/product">Go to page</a>
						</div>
					</div>
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/orders.png" width="60" height="60" />
							</div>
							<div>Total Orders: ${totalOrders}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/orders">Go to page</a>
						</div>
					</div>
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/messages.png" width="60" height="60" />
							</div>
							<div>Total Messages: ${totalMessages}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/messages">Go to page</a>
						</div>
					</div>
				</div>
				<h1 style="margin-top: 2rem;">Track Orders</h1>
				<div class="__row">
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/pending.png" width="60" height="60" />
							</div>
							<div>Pending: ${totalPending}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/orders">Go to page</a>
						</div>
					</div>
					<div class="__box-card">
						<div class="__box-card-body">
							<div>
								<img src="${pageContext.request.contextPath}/assets/icons/delivery.png" width="60" height="60" />
							</div>
							<div>Delivered: ${totalDelivered}</div>
						</div>
						<div class="__box-card-footer">
							<a href="<%= request.getContextPath() %>/admin/orders">Go to page</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>
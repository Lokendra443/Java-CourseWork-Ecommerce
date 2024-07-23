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
				<div class="__header">Product details</div>
			</div>
			<div class="__container-body">

				<div class="__container-body-main">

					<%
					if (request.getAttribute("error") != null) {
					%>
						<p class="__text-danger"><%=request.getAttribute("error")%></p>
					<%
					}
					%>
					<form action="<%=request.getContextPath()%>/admin/product/add"
						method="post" enctype="multipart/form-data">
						<div class="__row">
							<div class="__col">
								<label class="__form-label">Brand <span
									class="__text-danger">*</span>
								</label> <input name="brand" class="__form-input"
									placeholder="Product Brand" />
							</div>
							<div class="__col">
								<label class="__form-label">Title <span
									class="__text-danger">*</span></label> <input name="title"
									class="__form-input" placeholder="Product Title" />
							</div>
							<div class="__col">
								<label class="__form-label">Model No. <span
									class="__text-danger">*</span></label> <input name="model"
									class="__form-input" placeholder="Product Model" />
							</div>
						</div>
						<div class="__row">
							<div class="__col">
								<label class="__form-label">Qty <span
									class="__text-danger">*</span></label> <input name="quantity"
									class="__form-input" placeholder="1" style="width: 80px;"
									min="1" />
							</div>
							<div class="__col">
								<label class="__form-label">Price <span
									class="__text-danger">*</span></label> <input name="actualPrice"
									class="__form-input" placeholder="1500" style="width: 150px;"
									id="price" min="1" />
							</div>
							<div class="__col">
								<label class="__form-label">Discount (%)</label> <input
									name="discountPercent" class="__form-input" placeholder="5"
									style="width: 150px;" id="discount" min="0" />
							</div>
							<div class="__col">
								<label class="__form-label">Discouted Price</label> <input
									class="__form-input" style="width: 150px;" disabled
									id="discountedprice" />
							</div>
						</div>
						<div class="__row">
							<div class="__col">
								<label class="__form-label">Description</label>
								<textarea name="description"
									placeholder="Product description ..." cols="30" rows="05"></textarea>
							</div>
						</div>
						<div class="__row">
							<div class="__col">
								<label class="__form-label">Image</label> <input
									class="__form-file" type="file" name="image" />
							</div>
						</div>
						<div class="__row">
							<a href="<%= request.getContextPath() %>/admin/product" class="__btn __btn-secondary">Back</a>
							<button type="submit" class="__btn __btn-success">Save
								Product</button>

						</div>
					</form>

				</div>
			</div>
		</div>

	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/admin.js"></script>
</body>
</html>
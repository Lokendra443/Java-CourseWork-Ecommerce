<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About us</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css"> 
<jsp:include page="/includes/header.jsp"></jsp:include>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/about.css" />
</head>
<body>
	<div class="container">
	
		<div class="contact_data">
			<h2>Contact Us</h2>
			<form action="<%=request.getContextPath()%>/about-us" method="post">
				<label for="">Name</label> <input type="text" name="name" required />
				<label for="">Email</label> <input type="email" name="email"
					required /> <label for="">Phone Number</label> <input type="text"
					name="phoneNumber" required /> <label for="">Message</label>
				<textarea name="message" id="" cols="30" rows="05"></textarea>
				<%
				if (request.getAttribute("error") != null) {
				%>

				<p style="color: red; margin-left: 10px;"><%=request.getAttribute("error")%></p>
				<%
				}
				%>
				<%
				if (request.getAttribute("success") != null) {
				%>
				<p style="color: green; margin-left: 10px;"><%=request.getAttribute("success")%></p>
				<%
				}
				%>
				<button>Send Message</button>
			</form>
		</div>
		<div class="contact_data2">
			<ul>
				<li><i class="fa-solid fa-location-dot"></i> <strong>Location:</strong>
					<p>Kathmandu, Durbarmarg</p></li>
				<li><i class="fa-solid fa-envelope"></i> <strong>Email:</strong>
					<p>gigacctv@info.com</p></li>
				<li><i class="fa-solid fa-phone"></i> <strong>Call:</strong>
					<p>+1 (432) 1907871</p></li>
			</ul>
			<div class="map">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3532.156625944391!2d85.31519597546756!3d27.71244997617962!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39eb19016c9d9fcb%3A0xd2291eee6917d60a!2sDurbar%20Marg%2C%20Kathmandu%2044600!5e0!3m2!1sen!2snp!4v1714229359120!5m2!1sen!2snp"
					width="600" height="450" style="border: 0" allowfullscreen=""
					loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
			</div>
		</div>
	</div>
	<section class="team">
		<div class="container">
			<div class="row">
				<div class="section-title">
					<h2>
						meet <span>creative</span> team
					</h2>
				</div>
			</div>
			<div class="row">
				<div class="team-item">
					<img
						src="${pageContext.request.contextPath}/assets/our-team/sumit.jpg"
						alt="team">
					<h3>
						Sumit Khadka <span>Full stack developer</span>
					</h3>
					<div class="social-links">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-github"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
				<div class="team-item">
					<img
						src="${pageContext.request.contextPath}/assets/our-team/rishav.jpg"
						alt="team">
					<h3>
						Rishav Karna <span>.NET developer</span>
					</h3>
					<div class="social-links">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-github"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
				<div class="team-item">
					<img
						src="${pageContext.request.contextPath}/assets/our-team/anjesh.png"
						alt="team">
					<h3>
						Anjesh Mainali <span>Java developer</span>
					</h3>
					<div class="social-links">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-github"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="team-item">
					<img
						src="${pageContext.request.contextPath}/assets/our-team/rijan.jpg"
						alt="team">
					<h3>
						Rijan Budhathoki <span>Full stack Developer</span>
					</h3>
					<div class="social-links">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-github"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
				<div class="team-item">
					<img
						src="${pageContext.request.contextPath}/assets/our-team/lokendra.jpg"
						alt="team">
					<h3>
						Lokendra Nath <span>UI/UX designer</span>
					</h3>
					<div class="social-links">
						<a
							href="#https://www.facebook.com/sumit.khadka.5439?mibextid=PlNXYD"><i
							class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-github"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="/includes/footer.jsp"></jsp:include>
</body>
</html>
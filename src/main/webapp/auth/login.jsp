<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="../templateAuth/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="../templateAuth/css/style.css">
<style>
.signin-content {
	padding-top: 56px !important;
	padding-bottom: 0 !important;
	margin-top: 85px;
}

.signin-form {
	margin-right: 90px;
	margin-left: 80px;
	margin-top: 43px;
}

body {
	font-size: 13px;
	line-height: 1.8;
	color: #222;
	background: #f8f8f8;
	font-weight: 400;
	font-family: Poppins;
	margin: 0 !important;
}
</style>

</head>
<body>

	<!-- Sing in  Form -->
	<section class="sign-in">
		<div class="container">
			<div class="signin-content">
				<div class="signin-image">
					<figure>
						<img src="../templateAuth/images/signin-image.jpg"
							alt="sing up image">
					</figure>
				</div>
				<%
				if (request.getAttribute("error") != null) {
				%>
				<p>
					Error:
					<%=request.getAttribute("error")%></p>
				<%
				}
				%>
				<div class="signin-form">
					<h2 class="form-title">Sign up</h2>
					<form action="../UserServlet" method="post" id="login-form">
						<div class="form-group">
							<label for="username"><i class="zmdi zmdi-lock-outline"></i></label>
							<input type="text" name="username" id="username"
								placeholder="username" />
						</div>
						<div class="form-group">
							<label for="password"><i class="zmdi zmdi-lock-outline"></i></label>
							<input type="password" name="password" id="password"
								placeholder="password" />
						</div>
						<div class="form-group form-button">
							<input value="Envoyer" type="submit" name="signup" id="signup"
								class="form-submit" />
						</div>
					</form>

			 
				</div>
			</div>
		</div>
	</section>



	<!-- JS -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../js/main.js"></script>
</body>
</html>

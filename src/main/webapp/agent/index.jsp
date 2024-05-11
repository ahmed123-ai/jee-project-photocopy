
<%@page import="model.utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
    
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>

  
  	<section class="sign-in">
		<div class="container">
			<div class="signin-content">
		 

				<div class="signin-form">
					<h2 class="form-title">Home Page</h2>

					<h2 class="form-title">
						<%
						utilisateur u = (utilisateur) session.getAttribute("userCourant");
						%>
		
						<p class="hello" >Bienvenu  :  <%=u.getUsername() %></p>
						</h2>
				</div>
			</div>
		</div>
	</section>
	
</body>
</html>
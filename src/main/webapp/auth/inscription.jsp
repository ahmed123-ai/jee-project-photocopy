<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
    
</head>
<body>

		    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form action="InscriptionController" method="post" id="register-form">
                      
                            <div class="form-group">
                                <label for="nom"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="nom" id="nom" placeholder="Your nam"/>
                            </div>
                            <div class="form-group">
                                <label for="prenom"><i class="zmdi zmdi-lock"></i></label>
                                <input type="text" name="prenom" id="pass" placeholder="prenom"/>
                            </div>
                            <div class="form-group">
                                <label for="login"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="text" name="login" id="login" placeholder="login"/>
                            </div>
                                <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="text" name="password" id="password" placeholder="password"/>
                            </div>
                            <div class="form-group form-button">
                                <input  value="Envoyer" type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="#" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>
 
      
    </div>
		
		
		    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
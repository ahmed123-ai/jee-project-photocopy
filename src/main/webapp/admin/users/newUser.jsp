
<%@page import="model.utilisateur"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
 <!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">

<title>Ample Admin Lite Template by WrapPixel</title>
<link rel="canonical"
	href="https://www.wrappixel.com/templates/ample-admin-lite/" />




<!-- Custom CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</style>
</head>

<body>

	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
	 
 	 
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb bg-white">
				<div class="row align-items-center">
				 

				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
 <div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
                <!-- Row -->
                <div class="row">
                    <!-- Column -->

                    <!-- Column -->
                    <!-- Column -->
                    <div class="col-lg-12 col-xlg-12 col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <form  action="insert" method="post"class="form-horizontal form-material">
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Pseudo</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input name="username" id="username"  type="text" placeholder="Johnathan Doe"
                                                class="form-control p-0 border-0"> </div>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label class="col-sm-12">Role</label>

                                        <div class="col-sm-12 border-bottom">
                                            <select  name="role_id" id="role_id"  class="form-select shadow-none p-0 border-0 form-control-line">
                                                <option value="2" >Enseignant</option>
                                                <option  value="3" >Agent</option>
                                              
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label for="example-email" class="col-md-12 p-0">Mot de passe</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input  name="password" id="password"    type="password" 
                                                class="form-control p-0 border-0"  
                                                >
                                        </div>
                                    </div>
                                
                                 
                                
                                    <div class="form-group mb-4">
                                        <div class="col-sm-12">
                                            <button type="submit"  value="Envoyer" type="submit" name="signup" id="signup" class="btn btn-success">Ajouter</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- Column -->
                </div>
                <!-- Row -->
                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Right sidebar -->
                <!-- ============================================================== -->
                <!-- .right-sidebar -->
                <!-- ============================================================== -->
                <!-- End Right sidebar -->
                <!-- ============================================================== -->
            </div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
		 
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
			crossorigin="anonymous"></script>
</body>

</html>
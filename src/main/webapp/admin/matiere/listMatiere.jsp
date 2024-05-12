<%@page import="model.matiere"%>
<%@page import="model.groupe"%>
<%@page import="java.util.List"%>
<%@page import="model.utilisateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">

    <title>Liste des Matières</title>
    <link rel="canonical"
        href="https://www.wrappixel.com/templates/ample-admin-lite/" />

    <!-- Custom CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">

    <style>
        .container-fluid {
            margin-bottom: 4rem !important;
        }

        th.border-top-0 {
            text-align: center !important;
        }

        td {
            text-align: center !important;
        }
              p.hello {
    text-align: center;
    margin-bottom: 35px;
    margin-top: 35px;
}
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
					<%
					utilisateur u = (utilisateur) session.getAttribute("userCourant");
					if (u != null) {
					%>
					<h2 class="form-title">
						<p class="hello">
							Bienvenue :
							<%=u.getUsername()%></p>
					</h2>
					<%
					}
					%>

				</div>
            </div>
            <!-- ============================================================== -->
            <!-- End Bread crumb and right sidebar toggle -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
            <div class="container-fluid">
             		<div class="row">
					<div class="col">
						<a type="button" href="<%=request.getContextPath()%>"
							class="btn btn-primary">Utilisateurs</a> <a
							href="<%=request.getContextPath()%>/listingGroupe"
							class="btn btn-primary">Groupes</a> <a
							href="<%=request.getContextPath()%>/listingMatiere"
							class="btn btn-primary">Matiers</a> 
							<a
							href="<%=request.getContextPath()%>/logout" class="btn btn-info" >Logout</a>

 
					</div>
				</div>
                <!-- ============================================================== -->
                <!-- RECENT SALES -->
                <!-- ============================================================== -->
                <div class="row">
                    <div class="col-md-12 col-lg-12 col-sm-12">
                        <div class="white-box">
                            <div class="d-md-flex mb-3">
                                <h3 class="box-title mb-0">Liste des Matières</h3>
                                <div class="col-md-3 col-sm-4 col-xs-6 ms-auto">					 
                                    <a href="<%=request.getContextPath()%>/newMatiere" class="btn btn-primary">Ajouter une nouvelle matière</a>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table class="table no-wrap">
                                    <thead>
                                        <tr>
                                            <th class="border-top-0">Label Matière</th>
                                            <th class="border-top-0">Groupe</th>
                                            <th class="border-top-0">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Iterate over the list of matières -->
                                        <%
                                        List<matiere> listMatieres = (List<matiere>) request.getAttribute("listMatieres");
                                        if (listMatieres != null) {
                                            for (matiere matiere : listMatieres) {
                                        %>
                                        <tr>
                                            <td><%=matiere.getLabel()%></td>
                                            <td><%=matiere.getGroup_id()%></td>
                                            <td>
                                                <button type="button" class="btn btn-success">
                                                    <a href="<%=request.getContextPath()%>/editMatiere?id=<%=matiere.getId()%>" class="text-white">Modifier</a>
                                                </button>
                                                <button type="button" class="btn btn-danger">
                                                    <a href="<%=request.getContextPath()%>/deleteMatiere?id=<%=matiere.getId()%>" class="text-white">Supprimer</a>
                                                </button>
                                            </td>
                                        </tr>
                                        <%
                                            }
                                        }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>

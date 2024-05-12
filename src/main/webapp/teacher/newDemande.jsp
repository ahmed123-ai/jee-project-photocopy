<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@page import="model.matiere"%>
<%@page import="model.groupe"%>
<%@page import="java.util.List"%>
<%@page import="model.utilisateur"%>

<!DOCTYPE html>
<html dir="ltr" lang="en">
<style>
h2.form-title {
    text-align: center;
    margin-bottom: 45px;
    margin-top: 45px;
}</style>
<head>
    <meta charset="utf-8">
    <title>Ajouter une nouvelle Demande de Tirage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full" data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
      
 <div class="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                	<%
					utilisateur u = (utilisateur) session.getAttribute("userCourant");
				 
					%>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <form action="insertDemande" method="post" class="form-horizontal form-material">
                                    <div class="form-group mb-4"  style="    background: white;
    color: white;"   >
                                        <label class="col-md-12 p-0">User ID</label>
                                        <div class="col-md-12 border-bottom p-0">
				<input hidden="true" value="<%= u.getId() %>" name="user_id" id="user_id" type="text"  class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Matiere ID</label>
										<div class="col-md-12 border-bottom p-0">
											<select name="matiere_id" id="matiere_id" class="form-select">
												<%
												List<matiere> listMatieres = (List<matiere>) session.getAttribute("listMatieres");
												if (listMatieres != null) {
													for (matiere matiere : listMatieres) {
												%>
												<option value="<%=matiere.getId()%>"><%=matiere.getLabel()%></option>
												<%
												}
												}
												%>
											</select>
										</div>
									</div>
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Date d'arrivée</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input name="dateArriver" id="dateArriver" type="datetime-local" placeholder="Date d'arrivée" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Nombre de copies</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input name="nbCopier" id="nbCopier" type="text" placeholder="Nombre de copies" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                          
                                    <div class="form-group mb-4">
                                        <div class="col-sm-12">
                                            <button type="submit" value="Envoyer"  class="btn btn-success">Ajouter</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>

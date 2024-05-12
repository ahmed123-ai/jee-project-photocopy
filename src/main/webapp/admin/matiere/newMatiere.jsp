<%@page import="model.groupe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.groupe"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <title>Ajouter une nouvelle Matière</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full" data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
        <div class="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <form action="insertMatiere" method="post" class="form-horizontal form-material">
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Nom de la Matière</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <input name="label" id="label" type="text" placeholder="Nom de la Matière" class="form-control p-0 border-0">
                                        </div>
                                    </div>
                                    <div class="form-group mb-4">
                                        <label class="col-md-12 p-0">Groupe</label>
                                        <div class="col-md-12 border-bottom p-0">
                                            <select name="groupe_id" id="groupe_id" class="form-select">
                                                <!-- Iterate over the list of groupes from session -->
                                                <%
                                                List<groupe> listGroupes = (List<groupe>) request.getAttribute("listGroupes");
                                                if (listGroupes != null) {
                                                    for (groupe groupe : listGroupes) {
                                                %>
                                                <option value="<%=groupe.getId()%>"><%=groupe.getLabel()%></option>
                                                <%
                                                    }
                                                }
                                                %>
                                            </select>
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

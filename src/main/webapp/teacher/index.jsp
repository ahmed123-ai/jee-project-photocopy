<%@page import="model.demandeTirage"%>
<%@page import="model.utilisateur"%>
<%@page import="java.util.List"%>
<%@page import="model.matiere"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">
<head>
    <meta charset="utf-8">
    <title>DemandeTirage List</title>
    <link rel="canonical" href="your_canonical_url_here" />
    <!-- Custom CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
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
    </style>
</head>
<body>
<%
    String roleId = "3"; // Set a default value for roleId
    utilisateur user = (utilisateur) session.getAttribute("userCourant");
    if (user != null) {
        roleId = user.getRole_id();
    }
%>
<div class="container-fluid">
    <div class="row">
        <% if (roleId.equals("2") ) { %>
        <div class="col">
            <a type="button" href="<%=request.getContextPath()%>/newDemande" class="btn btn-primary">New DemandeTirage</a>
        </div>
             <% } %>
    </div>
    <div class="row">
        <div class="col-md-12 col-lg-12 col-sm-12">
            <div class="white-box">
                <div class="d-md-flex mb-3">
                    <h3 class="box-title mb-0">Liste des demandes de tirage</h3>
                </div>
                <div class="table-responsive">
                    <table class="table no-wrap">
                        <thead>
                        <tr>
                            <th class="border-top-0">ID</th>
                            <th class="border-top-0">User ID</th>
                            <th class="border-top-0">Matiere ID</th>
                            <th class="border-top-0">Date Arriver</th>
                            <th class="border-top-0">Nombre de Copier</th>
                            <th class="border-top-0">Statu</th>
                            <th class="border-top-0">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<demandeTirage> listDemandeTirage = (List<demandeTirage>) request.getAttribute("listDemandeTirages");
                            if (listDemandeTirage != null) {
                                for (demandeTirage demandeTirage : listDemandeTirage) {
                                    %>
                                    <tr>
                                        <td><%=demandeTirage.getId()%></td>
                                        <td><%=demandeTirage.getUser_id()%></td>
                                        <%
                                            List<matiere> listMatieres = (List<matiere>) session.getAttribute("listMatieres");
                                            int matiereId = demandeTirage.getMatier_id();
                                            String matiereLabel = "Unknown";
                                            for (matiere matiere : listMatieres) {
                                                if (matiere.getId() == matiereId) {
                                                    matiereLabel = matiere.getLabel();
                                                    break;
                                                }
                                            }
                                        %>
                                        <td><%=matiereLabel%></td>
                                        <td><%=demandeTirage.getDateArriver()%></td>
                                        <td><%=demandeTirage.getNbCopier()%></td>
                                        <td>
                                            <%
                                                int statuValue = demandeTirage.getStatu();
                                                String statuText = "";
                                                if (statuValue == 0) {
                                                    statuText = "Non traité";
                                                } else if (statuValue == 1) {
                                                    statuText = "Traité";
                                                } else {
                                                    statuText = "Unknown";
                                                }
                                            %>
                                            <%=statuText%>
                                        </td>
                                        <td>
                                            <% if ( roleId.equals("2") && statuValue == 0) { %>
                                                <button type="button" class="btn btn-success">
                                                    <a href="<%=request.getContextPath()%>/demandeTirage/edit?id=<%=demandeTirage.getId()%>"
                                                       class="text-white">Modifier</a>
                                                </button>
                                                <button type="button" class="btn btn-danger">
                                                    <a href="<%=request.getContextPath()%>/demandeTirage/delete?id=<%=demandeTirage.getId()%>"
                                                       class="text-white">Supprimer</a>
                                                </button>
                                            <% } %>
                                            <% if (roleId.equals("3") && statuValue == 0) { %>
                                                <button type="button" class="btn btn-danger">
                                                    <a href="<%=request.getContextPath()%>/updateTo1?id=<%=demandeTirage.getId()%>"
                                                       class="text-white">Traité</a>
                                                </button>
                                            <% } %>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>

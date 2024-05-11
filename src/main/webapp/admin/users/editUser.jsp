<%@page import="model.utilisateur"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<title>Ample Admin Lite Template by WrapPixel</title>
<link rel="canonical" href="https://www.wrappixel.com/templates/ample-admin-lite/" />
<!-- Custom CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container mt-5">
        <h1>Edit User</h1>
        <form action="update" method="post" class="form-horizontal form-material">
            <% utilisateur user = (utilisateur) request.getAttribute("user"); %>
            <input type="hidden" name="id" value="<%= user.getId() %>">
            <div class="form-group mb-4">
                <label class="col-md-12 p-0">Pseudo</label>
                <div class="col-md-12 border-bottom p-0">
                    <input name="username" id="username" type="text" value="<%= user.getUsername() %>"
                        class="form-control p-0 border-0">
                </div>
            </div>
            <div class="form-group mb-4">
                <label class="col-sm-12">Role</label>
                <div class="col-sm-12 border-bottom">
                    <select name="role_id" id="role_id" class="form-select shadow-none p-0 border-0 form-control-line">
                        <option value="2" <%= user.getRole_id().equals("2") ? "selected" : "" %>>Enseignant</option>
                        <option value="3" <%= user.getRole_id().equals("3") ? "selected" : "" %>>Agent</option>
                    </select>
                </div>
            </div>
            <div class="form-group mb-4">
                <label for="example-email" class="col-md-12 p-0">Mot de passe</label>
                <div class="col-md-12 border-bottom p-0">
                    <input name="password" id="password" type="password" value="<%= user.getPassword() %>"
                        class="form-control p-0 border-0">
                </div>
            </div>
            <div class="form-group mb-4">
                <div class="col-sm-12">
                    <button type="submit" value="Envoyer" name="signup" id="signup" class="btn btn-success">Update</button>
                </div>
            </div>
        </form>
    </div>
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>

</html>

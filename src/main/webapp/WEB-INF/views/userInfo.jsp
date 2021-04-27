<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="style/style.css">
    <meta charset="UTF-8">
    <title>Infos</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<h1 class="text-center mt-5 mb-5">Tes infos mon petit canari : <%-- {produit} --%></h1>
<div class="container">
    <br>
    <h3>Ton prénom (celui donné par ta maman ♥):
        <p>${utilisateur.firstName}</p>
    </h3>
    <br>
    <h3>Ton Pseudo
        <p>${utilisateur.userName}</p>
    </h3>
    <br>
    <h3>Ton adresse mail
        <p>${utilisateur.mail}</p>
    </h3>
    <br>
    <h3>Ton adresse tout court (pour la blague)
        <p>${utilisateur.billingAddress}</p>
    </h3>
    <br>
    <h3>Ton mot de passe (pense à partager)
        <p>${utilisateur.password}</p>
    </h3>
</div>
</body>
</html>
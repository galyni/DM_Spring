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
        <title>ProStock</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <h1 class="text-center mt-5 mb-5">Accueil</h1>
        <div class="container d-flex justify-content-center">
            <br>
            <h4>ProStock vous permet de :</h4>
            <br>
        </div>
        <div class="container d-flex justify-content-center">
            <ul>
                <li>Afficher une liste de produit</li>
                <li>Créer un produit</li>
                <li>Modifier un produit</li>
                <li>Supprimer un produit</li>
                <li>Se connecter</li>
                <li>Créer un compte</li>
                <li>Stocker des informations dans un cookie</li>
            </ul>
        </div>
        <div class="container d-flex justify-content-center">
            <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn navbar-color btn-block align-center">Voir les produits</a>
        </div>
    </body>
</html>
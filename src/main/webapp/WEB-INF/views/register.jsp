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
    <title>Création d'un compte</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<h1 class="text-center mt-5 mb-5">Création d'un compte : <%-- {produit} --%></h1>
<div class="container d-flex justify-content-center">
    <form:form method="POST" action="/register" modelAttribute="utilisateur">
        <div class="form-row">
            <div class="mb-3">
                <form:label path="userName">Pseudo</form:label>
                <form:input type="text" class="form-control" text="${utilisateur.userName}" name="userName"  placeholder="Pseudonyme" path="userName"/>
            </div>
            <div class="mb-3">
                <form:label path="firstName">Prenom</form:label>
                <form:input type="text" class="form-control" text="${utilisateur.firstName}" name="firstName" placeholder="Prenom" path="firstName"/>
            </div>
            <div class="mb-3">
                <form:label path="mail">Email</form:label>
                <form:input type="email" class="form-control" text="${utilisateur.mail}" name="mail" placeholder="Adresse mail" path="mail"/>
            </div>
            <div class="mb-3">
                <form:label path="billingAddress">Adresse postale</form:label>
                <form:input type="text" class="form-control" text="${utilisateur.billingAddress}" name="billingAddress" placeholder="Adresse postale" path="billingAddress"/>
            </div>
            <div class="mb-3">
                <form:label path="password">Password</form:label>
                <form:input type="password" class="form-control" text="${utilisateur.password}" name="password"  placeholder="Password" path="password"/>
            </div>
        </div>
        <button class="btn navbar-color" type="submit">Valider la création du compte</button>
        <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn btn-danger btn-block">Annuler la création</a>
    </form:form>

</div>
</body>
</html>
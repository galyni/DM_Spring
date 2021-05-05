<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" required="true"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="style/style.css">
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>

<sec:authorize var="loggedIn" access="isAuthenticated()" />

<div class="navbar-color">
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid ">
            <a class="navbar-brand nav-link text-light font-weight-bold mr-5 boutons-menu" href="${pageContext.request.contextPath}/">Accueil</a>
            <div class="collapse navbar-collapse ml-5" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/GetProductsList">Liste des produits</a>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/CreateProduct">Créer un produit</a>
                    </sec:authorize>
                </div>
            </div>
            <c:if test="${not empty prenom}">
                <span>Bonjour ${prenom}</span>
            </c:if>
            <c:if test="${!loggedIn}">
                <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/login">Se connecter</a>
                <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/register">S'inscrire</a>
            </c:if>
            <c:if test="${loggedIn}">
                <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/userInfo">Mon compte</a>
                <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/disconnect">Se déconnecter</a>
            </c:if>
        </div>
    </nav>
</div>

<jsp:doBody/>

</body>
</html>
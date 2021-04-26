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
    <title>Modification d'un Produit</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
<h1 class="text-center mt-5 mb-5">Modification d'un produit du produit : <%-- {produit} --%></h1>
<div class="container">
    <form:form method="POST" action="/UpdateProduct" modelAttribute="product">
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <form:label path="nom">Nom</form:label>
                <form:input type="text" class="form-control" text="${product.nom}" name="name" placeholder="Nom" path="nom"/>
            </div>
            <div class="col-md-3 mb-3">
                <form:label path="code">EAN</form:label>
                <form:input type="text" class="form-control" text="${product.code}" name="EAN" placeholder="EAN" path="code" readonly="true"/>
            </div>
            <div class="col-md-3 mb-3">
                <form:label path="prix">Prix</form:label>
                <form:input type="number" class="form-control" text="${product.prix}" name="price"  placeholder="Prix" path="prix"/>
            </div>
            <div class="col-md-3 mb-3">
                <form:label path="quantite">Quantit&eacute;</form:label>
                <form:input type="number" class="form-control" text="${product.quantite}" placeholder="0" path="quantite" />
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Valider la modification</button>
        <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn btn-danger btn-block">Annuler la modification</a>
    </form:form>

</div>
</body>
</html>
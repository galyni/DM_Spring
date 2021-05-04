<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="style/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <meta charset="UTF-8">
        <title>Création d'un Produit</title>
    </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <h1 class="text-center mt-5 mb-5">Création d'un produit : <%-- {produit} --%></h1>
        <div class="container justify-content-center border border-2 rounded-3 col-md-3">
            <form:form method="POST" action="/CreateProduct" modelAttribute="product" class="mt-2 mb-3">
                <div class="form-row">
                    <div class="mb-3">
                        <form:label path="nom">Nom</form:label>
                        <form:input type="text" class="form-control" name="name" placeholder="Nom" path="nom"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="code">EAN</form:label>
                        <form:input type="text" class="form-control" name="EAN" placeholder="EAN" path="code"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="prix">Prix</form:label>
                        <form:input type="number" class="form-control" name="price"  placeholder="Prix" path="prix" step="0.01" min="0"/>
                            <%--            A voir pour enlever le form control du prix, il n'y était pas avant--%>
                    </div>
                    <div class="mb-3">
                        <form:label path="quantite">Quantit&eacute;</form:label>
                        <form:input type="number" class="form-control" placeholder="0" path="quantite" />
                            <%--            J'ai changé le quantity en quantité dans le path--%>
                    </div>
                    <div class="mb-3">
                        <form:label path="datePeremption">Date de p&eacute;remption</form:label>
                        <form:input type="date" class="form-control" path="datePeremption" />
                    </div>
                </div>
                <div class="text-align-center">
                    <button class="btn navbar-color" type="submit">Cr&eacute;er le produit</button>
                    <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn btn-danger btn-block">Annuler la modification</a>
                </div>
                <c:if test="${not empty error}">
                    <p id="error-message">${error}</p>
                </c:if>
            </form:form>
        </div>
    </body>

</html>

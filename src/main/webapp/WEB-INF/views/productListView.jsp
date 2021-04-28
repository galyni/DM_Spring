<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
     <head>
         <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
         <link type="text/css" rel="stylesheet" href="style/style.css">
         <meta charset="UTF-8">
         <title>Liste des produits</title>
     </head>
    <body>
        <jsp:include page="_menu.jsp"></jsp:include>
        <h1 class="text-center mt-5 mb-5">Liste des produits disponibles</h1>
        <div>
            <div class="container d-flex justify-content-center">
                <table class="table">
                    <thead>
                        <tr>
                            <th>EAN</th>
                            <th>Nom</th>
                            <th>Prix</th>
                            <c:if test="${connected}">
                                <th>Modifier</th>
                                <th>Supprimer</th>
                            </c:if>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productList}" var="product" >
                            <tr>
                                <td>${product.code}</td>
                                <td>${product.nom}</td>
                                <td>${product.prix}€</td>
                                <c:if test="${connected}">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/UpdateProduct?id=${product.code}" type="button" class="btn navbar-color btn-block">Modifier</a>
                                    </td>

                                    <td>
                                        <a href="${pageContext.request.contextPath}/DeleteProduct?id=${product.code}" type="button" class="btn btn-danger btn-block">Supprimer</a>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <c:if test="${connected}">
                <div class="block-center mt-5 d-flex justify-content-center">
                    <a href="${pageContext.request.contextPath}/CreateProduct" type="button" class="btn navbar-color btn-lg btn-block">Ajouter un produit</a>
                </div>
            </c:if>
        </div>
    </body>
</html>

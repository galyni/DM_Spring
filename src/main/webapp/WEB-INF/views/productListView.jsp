<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:common title="Liste des produits">
    <jsp:body>
        <h1 class="text-center mt-5 mb-5">Liste des produits disponibles</h1>
        <div>
            <div class="container d-flex justify-content-center">
                <table class="table">
                    <thead>
                        <tr>
                            <th>EAN</th>
                            <th>Nom</th>
                            <th>Prix</th>
                            <th>Date de P&eacute;remption</th>
                            <th>Nombre de jours</th>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <th>Modifier</th>
                                <th>Supprimer</th>
                            </sec:authorize>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productList}" var="product" >
                            <tr>
                                <td>${product.code}</td>
                                <td>${product.nom}</td>
                                <td>${product.prix}€</td>
                                        <fmt:parseDate value="${product.datePeremption}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />
                                        <td><fmt:formatDate pattern = "dd-MM-yyyy" value = "${parsedDate}" /></td>
                                        <c:if test="${hashDatePer[product.code] < 0}">
                                            <td>❌ Périmé depuis ${hashDatePer[product.code] * - 1} jours.</td>
                                        </c:if>
                                        <c:if test="${hashDatePer[product.code] > 0}">
                                            <td>✔ Il reste ${hashDatePer[product.code] } jours avant péremption.</td>
                                        </c:if>
                                        <c:if test="${hashDatePer[product.code] == 0}">
                                            <td>⚠ Ce produit périme aujourd'hui.</td>
                                        </c:if>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                    <td>
                                        <a href="${pageContext.request.contextPath}/UpdateProduct?id=${product.code}" type="button" class="btn navbar-color btn-block">Modifier</a>
                                    </td>

                                    <td>
                                        <a href="${pageContext.request.contextPath}/DeleteProduct?id=${product.code}" type="button" class="btn btn-danger btn-block">Supprimer</a>
                                    </td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <div class="block-center mt-5 d-flex justify-content-center">
                    <a href="${pageContext.request.contextPath}/CreateProduct" type="button" class="btn navbar-color btn-lg btn-block">Ajouter un produit</a>
                </div>
            </sec:authorize>
        </div>
        </jsp:body>
        </t:common>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:common title="Création d'un Produit">
    <jsp:body>
        <h1 class="text-center mt-5 mb-5">Création d'un produit<%-- {produit} --%></h1>
        <div class="container justify-content-center border border-2 rounded-3 col-md-3">
            <form:form method="POST" action="/CreateProduct" modelAttribute="product" class="mt-2 mb-3">
                <div class="form-row">
                    <div class="mb-3">
                        <form:label class="form-label" path="nom">Nom</form:label>
                        <form:input type="text" class="form-control" name="name" placeholder="Nom" path="nom" required="true"/>
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="code">EAN</form:label>
                        <form:input type="text" class="form-control" name="EAN" placeholder="EAN" path="code" required="true"/>
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="prix">Prix</form:label>
                        <form:input type="number" class="form-control" name="price"  placeholder="Prix" path="prix" step="0.01" min="0" required="true"/>
                            <%--            A voir pour enlever le form control du prix, il n'y était pas avant--%>
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="quantite">Quantit&eacute;</form:label>
                        <form:input type="number" class="form-control" placeholder="0" path="quantite" required="true" />
                            <%--            J'ai changé le quantity en quantité dans le path--%>
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="datePeremption">Date de p&eacute;remption</form:label>
                        <form:input type="date" class="form-control" path="datePeremption" required="true" />
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
    </jsp:body>
</t:common>

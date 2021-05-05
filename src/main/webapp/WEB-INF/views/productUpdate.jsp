<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:common title="Modification d'un Produit">
    <jsp:body>
<h1 class="text-center mt-5 mb-5">Modification d'un produit</h1>
<div class="container justify-content-center border border-2 rounded-3 col-md-3">
    <form:form method="POST" action="/UpdateProduct" modelAttribute="product" class="mt-2 mb-3">
        <div class="form-row">
            <div class="mb-3">
                <form:label path="nom">Nom</form:label>
                <form:input type="text" class="form-control" text="${product.nom}" name="name" placeholder="Nom" path="nom"/>
            </div>
            <div class="mb-3">
                <form:label path="code">EAN</form:label>
                <form:input type="text" class="form-control" text="${product.code}" name="EAN" placeholder="EAN" path="code" readonly="true"/>
            </div>
            <div class="mb-3">
                <form:label path="prix">Prix</form:label>
                <form:input type="number" class="form-control" text="${product.prix}" name="price"  placeholder="Prix" path="prix" step="0.01" min="0" />
            </div>
            <div class="mb-3">
                <form:label path="quantite">Quantit&eacute;</form:label>
                <form:input type="number" class="form-control" text="${product.quantite}" placeholder="0" path="quantite" />
            </div>
            <div class="mb-3">
                <form:label path="datePeremption">Date de p&eacute;remption</form:label>
                <form:input type="date" class="form-control" path="datePeremption" />
            </div>
        </div>
        <button class="btn navbar-color" type="submit">Valider</button>
        <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn btn-danger btn-block">Annuler la modification</a>
    </form:form>

</div>
</jsp:body>
</t:common>
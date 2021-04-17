<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" action="/CreateProduct" modelAttribute="product">
<%--  De base, la balise était :  form:form en haut et form:imput en bas--%>
    <div class="form-row">
        <div class="col-md-6 mb-3">
            <form:label path="nom">Nom</form:label>
            <form:input type="text" class="form-control" name="name" placeholder="Nom" path="nom"/>
        </div>
        <div class="col-md-3 mb-3">
            <form:label path="code">EAN</form:label>
            <form:input type="text" class="form-control" name="EAN" placeholder="EAN" path="code"/>
        </div>
        <div class="col-md-3 mb-3">
            <form:label path="prix">Prix</form:label>
            <form:input type="number" class="form-control" name="price"  placeholder="Prix" path="prix"/>
<%--            A voir pour enlever le form control du prix, il n'y était pas avant--%>
        </div>
        <div class="col-md-3 mb-3">
            <form:label path="quantite">Quantit&eacute;</form:label>
            <form:input type="number" class="form-control" placeholder="0" path="quantite" />
<%--            J'ai changé le quantity en quantité dans le path--%>
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Cr&eacute;er le produit</button>
</form:form>

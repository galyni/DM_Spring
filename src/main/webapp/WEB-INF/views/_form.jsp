<form:form method="POST" action="/CreateProduct" modelAttribute="Product">
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
            <form:input type="text" name="price" placeholder="Prix" path="prix"/>
        </div>
        <div class="col-md-3 mb-3">
            <form:label path="quantite">Quantit&eacute;</form:label>
            <form:input class="form-control" placeholder="0" path="quantity" />
        </div>
    </div>
    <button class="btn btn-primary" type="submit">Cr&eacute;er le produit</button>
</form:input>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<t:common title="ProStock">
    <jsp:body>
        <h1 class="text-center mt-5 mb-5">Accueil</h1>
        <div class="container d-flex justify-content-center">
            <br>
            <h4>ProStock vous permet de :</h4>
            <br>
        </div>
        <div class="container d-flex justify-content-center">
            <ul>
                <li>Afficher une liste de produit</li>
                <li>Créer un produit</li>
                <li>Modifier un produit</li>
                <li>Supprimer un produit</li>
                <li>Se connecter</li>
                <li>Créer un compte</li>
                <li>Stocker des informations dans un cookie</li>
            </ul>
        </div>
        <div class="container d-flex justify-content-center">
            <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn navbar-color btn-block align-center">Voir les produits</a>
        </div>
    </jsp:body>
</t:common>
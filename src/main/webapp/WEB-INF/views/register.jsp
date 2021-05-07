<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:common title="Création d'un compte">
    <jsp:body>
<h1 class="text-center mt-5 mb-5">Création d'un compte : <%-- {produit} --%></h1>
<div class="container d-flex justify-content-center">
    <form:form method="POST" action="/register" modelAttribute="utilisateur">
        <div class="form-row">
            <div class="mb-3">
                <form:label class="form-label" path="userName">Pseudo</form:label>
                <form:input type="text" class="form-control" text="${utilisateur.userName}" name="userName"  placeholder="Pseudonyme" path="userName"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="firstName">Prenom</form:label>
                <form:input type="text" class="form-control" text="${utilisateur.firstName}" name="firstName" placeholder="Prenom" path="firstName"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="mail">Email</form:label>
                <form:input type="email" class="form-control" text="${utilisateur.mail}" name="mail" placeholder="Adresse mail" path="mail"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="billingAddress">Adresse postale</form:label>
                <form:input type="text" class="form-control" text="${utilisateur.billingAddress}" name="billingAddress" placeholder="Adresse postale" path="billingAddress"/>
            </div>
            <div class="mb-3">
                <form:label class="form-label" path="password">Password</form:label>
                <form:input type="password" class="form-control" text="${utilisateur.password}" name="password"  placeholder="Password" path="password"/>
            </div>
        </div>
        <button class="btn navbar-color" type="submit">Valider la création du compte</button>
        <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn btn-danger btn-block">Annuler la création</a>
    </form:form>

</div>
    </jsp:body>
</t:common>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:common title="Création d'un compte">
    <jsp:body>
        <h1 class="text-center mt-5 mb-5">Connexion <%-- {produit} --%></h1>
        <div class="container d-flex justify-content-center">
            <form:form class="form-signin" method="POST" action="/login" modelAttribute="utilisateur">
                <div class="form-row">
                    <div class="mb-3">
                        <form:label path="mail">Email</form:label>
                        <form:input type="email" class="form-control" text="${utilisateur.mail}" name="mail" placeholder="Adresse mail" path="mail"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="password">Password</form:label>
                        <form:input type="password" class="form-control" text="${utilisateur.password}" name="password"  placeholder="Password" path="password"/>
                    </div>
                </div>
                <button class="btn navbar-color" type="submit">Se connecter</button>
                <a href="${pageContext.request.contextPath}/GetProductsList" type="button" class="btn btn-danger btn-block">Annuler</a>
            </form:form>
        </div>
    </jsp:body>
</t:common>

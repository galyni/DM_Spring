<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="navbar-color">
   <nav class="navbar navbar-expand-lg">
      <div class="container-fluid ">
         <a class="navbar-brand nav-link text-light font-weight-bold mr-5 boutons-menu" href="${pageContext.request.contextPath}/GetProductsList">Accueil</a>
         <div class="collapse navbar-collapse ml-5" id="navbarNavAltMarkup">
            <div class="navbar-nav">
               <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/GetProductsList">Liste des produits</a>
               <c:if test="${connected}">
                  <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/CreateProduct">Créer un produit</a>
               </c:if>
            </div>
         </div>
         <c:if test="${!connected}">
            <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/login">Se connecter</a>
            <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/register">S'inscrire</a>
         </c:if>
         <c:if test="${connected}">
            <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/userInfo">Mon compte</a>
            <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/disconnect">Se déconnecter</a>
         </c:if>
      </div>
   </nav>
</div>
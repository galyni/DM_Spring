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
               <c:if test="${!connected}">
                  <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/userInfo">Mes infos</a>
                  <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/CreateProduct">Créer un produit</a>
                  <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/login">Login</a>
               </c:if>
               <c:if test="${connected}">
                  <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/disconnect">Se deconnecter</a>
               </c:if>
               <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/register">S'enregistrer</a>
            </div>
         </div>
      </div>
   </nav>
</div>
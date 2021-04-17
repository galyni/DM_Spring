<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="navbar-color">
   <nav class="navbar navbar-expand-lg">
      <div class="container-fluid ">
         <a class="navbar-brand nav-link text-light font-weight-bold mr-5 boutons-menu" href="${pageContext.request.contextPath}/GetProductsList">Accueil</a>
         <div class="collapse navbar-collapse ml-5" id="navbarNavAltMarkup">
            <div class="navbar-nav">
               <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/GetProductsList">Liste des produits</a>
               <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/CreateProduct">Créer un produit</a>
               <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/userInfo">Mes infos</a>
               <a class="nav-link text-light font-weight-bold boutons-menu" href="${pageContext.request.contextPath}/">Login</a>
            </div>
         </div>
      </div>
   </nav>
</div>
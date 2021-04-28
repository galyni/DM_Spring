<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="style/style.css">
    <meta charset="UTF-8">
    <title>Infos</title>
</head>
<body>
<jsp:include page="_menu.jsp"></jsp:include>
    <h1 class="text-center mt-5 mb-5">Tes infos mon petit canari :

        <%--Ton prénom (celui donné par ta maman ♥):--%>

        <div class="container mt-5 d-flex justify-content-center">
            <div class="card p-3">
                <div class="d-flex align-items-center">
                    <div class="image"> <img src="https://www.zooplus.fr/magazine/wp-content/uploads/2017/10/Kanarienvogel-768x512.jpg" class="rounded" width="200"> </div>
                    <div class="marginLeft w-100" >
                        <h3 class="mb-0 mt-0 mb-3">${utilisateur.firstName}</h3>
                        <h4>Ton pseudo : ${utilisateur.userName}</h4>
                        <h4>Ton mail : ${utilisateur.mail}</h4>
                        <h4>Ton mot de passe : ${utilisateur.password}</h4>
                        <h6>(Pense bien à le partager)</h6>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
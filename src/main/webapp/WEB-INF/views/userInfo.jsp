<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<t:common title="Infos">
    <jsp:body>
    <h1 class="text-center mt-5 mb-5">Tes infos mon petit canari

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
        </jsp:body>
</t:common>
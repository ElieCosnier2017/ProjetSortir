<%@ page import="fr.eni.sortir.bo.Participant" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>

<c:if test="${!empty participant }">
        <title>Sortir.com - Profil de ${participant.pseudo}</title>
    </head>
    <body>
    <%@ include file="../layout/navbar.jsp"%>
        <div class="container emp-profile">
            <div class="row">
                <div class="col-md-4">
                    <img style="margin-left: 70px;" src="<%=request.getContextPath()%>/vendor/img/img.png">
                </div>
                <div class="col-md-5">
                    <h1>${participant.pseudo}</h1>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Prénom </label>
                        </div>
                        <div class="col-md-6">
                            <p>${participant.prenom}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Nom </label>
                        </div>
                        <div class="col-md-6">
                            <p>${participant.nom}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Téléphone </label>
                        </div>
                        <div class="col-md-6">
                            <p><c:if test="${!empty participant.telephone }"> ${participant.telephone} </c:if></p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Email </label>
                        </div>
                        <div class="col-md-6">
                            <p>${participant.mail}</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <label>Ville de rattachement </label>
                        </div>
                        <div class="col-md-6">
                            <p>${participant.nom}</p>
                        </div>
                    </div>
                </div>
                <div class="col-4 offset-4">
                    <a href="/" class="btn btn-primary btn-block">Retour</a>
                </div>
            </div>
        </div>

</c:if>
<%@ include file="../layout/footer.jsp"%>
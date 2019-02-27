<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
        <a href="/sortie/detail?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Consulter les sorties</a>
        <a href="/sortie/inscription?id=2" class="float-right btn btn-outline-danger" style="margin-left: 10px;">Inscription</a>
        <a href="/profilParticipant" class="float-right btn btn-outline-success" style="margin-left: 10px;">Profil</a>
        <a href="${pageContext.request.contextPath}/nouvelleSortie" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Consulter les sorties</a>
        <a href="${pageContext.request.contextPath}/editerSortie?idSortie=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Modifier les sorties</a>

<%@ include file="../layout/footer.jsp"%>
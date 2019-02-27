<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/sortie/detail?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Consulter les sorties</a>
        <a href="${pageContext.request.contextPath}/sortie/inscription?id=2" class="float-right btn btn-outline-danger" style="margin-left: 10px;">Inscription</a>
        <a href="${pageContext.request.contextPath}/profil" class="float-right btn btn-outline-success" style="margin-left: 10px;">Profil</a>
        <a href="${pageContext.request.contextPath}/sortie/ajouter" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Nouvelle sorties</a>
        <a href="${pageContext.request.contextPath}/sortie/desistement?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Desistement</a>

<%@ include file="../layout/footer.jsp"%>
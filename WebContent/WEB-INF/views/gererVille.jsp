<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp" %>

<title>Sortir.com - Gérer les villes</title>
<link rel="stylesheet"
      href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<%@ include file="../layout/navbar.jsp"%>
<div class="col-md-8" style="background-color: #ffffff;margin-left: 25em;">
    <div style="margin-top: 10%;">
        <div id="toolbar">
            <H3>Filtrer les villes</H3>
            <div class="form-inline" role="form">
                <div class="form-group">
                    <input name="search" class="form-control" type="text" placeholder="Search">
                </div>
                <button id="ok" type="submit" class="btn btn-primary">OK</button>
            </div>
        </div>
        <table border="1">
            <thead>
            <td>Nom de la ville</td>
            <td>Code postal</td>
            <td>Modifier</td>
            <td>Supprimer</td>
            </td>
            </thead>
            <tbody>
            <c:forEach items="${villes}" var="ville">
                <tr>
                    <td>${ville.nom}</td>
                    <td>${ville.codePostal}</td>
                    <td width="5%"><a href="${pageContext.request.contextPath}/ville/editer?idVille=${ville.idVille}" class="btn btn-lg btn-sortir" title="modifier la ville"><i class="fas fa-edit"></i></a></td>
                    <td width="5%"><a href="${pageContext.request.contextPath}/ville/supprimer?idVille=${ville.idVille}" class="btn btn-lg btn-danger" title="supprimer la ville"><i class="fas fa-trash-alt"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-md-2">
            <div class="form-group">
                <a href="/ville/creer" class="btn btn-success" style="margin-left: 10px;">Créer une ville</a>
            </div>
        </div>
        <div class="col-md-2">
            <div class="form-group">
                <button type="button" href="/" class="btn btn-primary btn-block">
                    Retour
                </button>
            </div>
        </div>
    </div>
</div>
<%@ include file="../layout/footer.jsp" %>

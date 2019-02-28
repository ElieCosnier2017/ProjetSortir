<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp" %>

<title>Sortir.com - Gérer les sites</title>
<link rel="stylesheet"
      href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<%@ include file="../layout/navbar.jsp"%>
<div style="background-color: #ffffff">
    <div style="margin-top: 10%;">
        <div id="toolbar">
            <H3>Filtrer les sites</H3>
            <div class="form-inline" role="form">
                <div class="form-group">
                    <input name="search" class="form-control" type="text" placeholder="Search">
                </div>
                <button id="ok" type="submit" class="btn btn-primary">OK</button>
            </div>
        </div>
        <table
                id="table"
                data-toggle="table"
                data-toolbar="#toolbar"
                data-url="/site/gererSite"
                style="background-color:#f7f7f7">
            <thead>
            <tr>
                <th data-field="nom" data-align="center">Nom du site</th>
                <th data-field="action" data-formatter="actionFormatter">Actions</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="row">
        <div class="col-md-2">
            <div class="form-group">
                <button type="button" href="/site/creerSite" class="btn btn-primary btn-block">
                    Créer un site
                </button>
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

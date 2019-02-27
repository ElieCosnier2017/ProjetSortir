<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
        <div style="margin-top: 10%;">
                <%--<div id="toolbar">--%>
                    <%--<div class="form-inline" role="form">--%>
                        <%--<div class="form-group">--%>
                            <%--<span>Offset: </span>--%>
                            <%--<input name="offset" class="form-control w70" type="number" value="0">--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<span>Limit: </span>--%>
                            <%--<input name="limit" class="form-control w70" type="number" value="5">--%>
                        <%--</div>--%>
                        <%--<div class="form-group">--%>
                            <%--<input name="search" class="form-control" type="text" placeholder="Search">--%>
                        <%--</div>--%>
                        <%--<button id="ok" type="submit" class="btn btn-primary">OK</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <table
                        id="table"
                        data-toggle="table"
                        data-toolbar="#toolbar"
                        data-show-refresh="true"
                        data-show-toggle="true"
                        data-show-columns="true"
                        data-url="/sorties"
                        style="background-color:#f7f7f7">
                    <thead>
                    <tr>
                        <th data-field="nom" data-align="center">Nom de la sortie</th>
                        <th data-field="dateDebut" data-align="center">Date de la sortie</th>
                        <th data-field="dateLimiteInscription" data-align="center">Clôture</th>
                        <th data-field="nbinscrit" data-formatter="inscritPlaceFormatter" data-align="center">Inscrit/Places</th>
                        <th data-field="libelleEtat" data-align="center">Etat</th>
                        <th data-formatter="isInscritFormatter" data-align="center">Inscrit</th>
                        <th data-field="organisateur" data-formatter="nomOrganisateurFormatter" data-align="center">Organisateur</th>
                        <th data-field="action" data-formatter="actionFormatter">Actions</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <a href="${pageContext.request.contextPath}/sortie/ajouter" class="btn btn-success" style="margin-left: 10px;">Créer une sortie</a>

<%@ include file="../layout/footer.jsp"%>
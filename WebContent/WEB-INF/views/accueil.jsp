<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/sortie/detail?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Consulter les sorties</a>
        <a href="${pageContext.request.contextPath}/sortie/inscription?id=2" class="float-right btn btn-outline-danger" style="margin-left: 10px;">Inscription</a>
        <a href="${pageContext.request.contextPath}/profilParticipant" class="float-right btn btn-outline-success" style="margin-left: 10px;">Profil</a>
        <a href="${pageContext.request.contextPath}/sortie/ajouter" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Nouvelle sorties</a>
        <a href="${pageContext.request.contextPath}/sortie/desistement?id=2" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Desistement</a>

        <div class="container">
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
                        data-url="/sorties">
                    <thead>
                    <tr>
                        <th data-field="nom">Nom de la sortie</th>
                        <th data-field="dateDebut">Date de la sortie</th>
                        <th data-field="dateLimiteInscription">Clôture</th>
                        <th data-field="nbinscrit" data-formatter="inscritPlaceFormatter">Inscrit/Places</th>
                        <th data-field="libelleEtat">Etat</th>
                        <th data-field="inscrit" data-formatter="isInscritFormatter">Inscrit</th>
                        <th data-field="organisateur" data-formatter="nomOrganisateurFormatter">Organisateur</th>
                        <th data-field="action">Actions</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>

        <script>

        </script>
<%@ include file="../layout/footer.jsp"%>
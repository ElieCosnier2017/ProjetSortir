<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Accueil</title>
    </head>
    <body>
    <a href="/ville/gerer" class="btn btn-success" style="margin-left: 10px;">Créer une ville</a>
    <a href="/site/gerer" class="btn btn-success" style="margin-left: 10px;">Créer un site</a>
    <c:if test="${sessionScope.participant != null}">
        <div class="row">
            <div class="col-md-4 offset-md-8">
                <span>Date du jour: ${date}</span><br>
                <span>Participant : ${sessionScope.participant.getPrenom()} ${sessionScope.participant.getNom()}</span>
            </div>
        </div>
        <div>
            <div id="toolbar">
                <div class="col-6">
                    <label>Site: </label>
                    <select class="selectpicker" id="selectSite">
                        <c:forEach var="site" items="${listeSite}">
                            <option value="${site.idSite}">${site.nom}</option>
                        </c:forEach>
                    </select>
                    <br><br>
                    <div class="form-group">
                        <input name="search" class="form-control" type="text" placeholder="Search">
                    </div>
                    <div class="form-inline">
                        <div class="form-group">
                            <span>Date debut: </span>
                            <input name="offset" class="form-control w70" type="date" value="0">
                        </div>
                        <div class="form-group">
                            <span>Date fin: </span>
                            <input name="limit" class="form-control w70" type="date" value="5">
                        </div>
                    </div>
                </div>
            </div>
            <table
                id="table"
                data-toggle="table"
                data-toolbar="#toolbar"
                data-url="/sortie?id=1"
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
        <a href="${pageContext.request.contextPath}/sortie/ajouter" class="btn btn-success" style="margin-left: 10px;">Créer une sortie</a>

    </c:if>
    <c:if test="${sessionScope.participant == null}">
    <div class="container">
        <h1 class="text-uppercase mb-0">Bienvenue sur Sortir.com</h1>
        <hr class="star-light" style="border-color: #fff;">
        <h2 class="font-weight-light mb-0">Le site pour trouver une sortie de l'ENI</h2>
    </div>
    </c:if>
<%@ include file="../layout/footer.jsp"%>
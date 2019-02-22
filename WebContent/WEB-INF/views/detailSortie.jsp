<%@ page import="fr.eni.sortir.bo.Sortie" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
<title>Sortir.com - Detail sortie</title>
</head>
<body>
<div class="container emp-profile">
    <%

        Sortie sortie = (Sortie) request.getAttribute("sortie");
    %>
    <form method="post">
        <div class="row">
            <div class="col-md-4">
                <h3>
                    <%= sortie.getNom() %>
                </h3>
            </div>
            <div class="col-md-6">
                <div class="tab-content profile-tab" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Date et heure de la sortie</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= sortie.getDateDebut() %></p>
                            </div>
                            <div class="col-md-6">
                                <label>Ville organisatrice</label>
                            </div>
                            <div class="col-md-6">
                                <p>a faire</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Date limite inscription</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= sortie.getDateLimiteInscription() %></p>
                            </div>
                            <div class="col-md-6">
                                <label>Lieu</label>
                            </div>
                            <div class="col-md-6">
                                <p>a faire</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Nombre de place</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= sortie.getNbInscriptionsMax() %></p>
                            </div>
                            <div class="col-md-6">
                                <label>Rue</label>
                            </div>
                            <div class="col-md-6">
                                <p>a faire </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Durée</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= sortie.getDuree() %></p>
                            </div>
                            <div class="col-md-6">
                                <label>Code postal</label>
                            </div>
                            <div class="col-md-6">
                                <p> a faire </p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Durée</label>
                            </div>
                            <div class="col-md-6">
                                <p>02 00 00 00 00</p>
                            </div>
                            <div class="col-md-6">
                                <label>Latitude</label>
                            </div>
                            <div class="col-md-6">
                                <p> a faire</p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Description et infos</label>
                            </div>
                            <div class="col-md-6">
                                <p><%= sortie.getInfosSortie() %></p>
                            </div>
                            <div class="col-md-6">
                                <label>Longitude</label>
                            </div>
                            <div class="col-md-6">
                                <p> a faire </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <a href="/sortie/add" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Créer une sortie</a>
</div>
<%@ include file="../layout/footer.jsp"%>
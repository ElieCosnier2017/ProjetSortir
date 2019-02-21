<%@ page import="fr.eni.sortir.bo.Participant" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
<%@ include file="../layout/navbar.jsp"%>
        <title>Sortir.com - Gestion du profil</title>
    </head>
    <body>
        <div class="container emp-profile">
            <%
                Participant participant = (Participant) request.getAttribute("participant");
            %>
            <div class="row">
                <div class="col-md-4">
                    <img src="">
                    <h5>
                        <%= participant.getNom() %> <%= participant.getPrenom() %>
                    </h5>
                    <input type="button" class="profile-edit-btn" data-toggle="modal" data-target="#editprofile" value="Modifier le Profil"/>
                </div>
                <div class="col-md-6">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Pseudo</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= participant.getPseudo() %></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Nom </label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= participant.getNom() %></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Prenom</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= participant.getPrenom() %></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= participant.getMail() %></p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Téléphone</label>
                                </div>
                                <div class="col-md-6">
                                    <p><%= participant.getTelephone() %></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="editprofile" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success">Modifier</button>
                        <button type="button" class="btn btn-danger">Annuler</button>
                    </div>
                </div>
            </div>
        </div>
<%@ include file="../layout/footer.jsp"%>
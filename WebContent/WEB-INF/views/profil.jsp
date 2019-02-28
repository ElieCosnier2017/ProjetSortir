<%@ page import="fr.eni.sortir.bo.Participant" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>

        <title>Sortir.com - Gestion du profil</title>
    </head>
    <body>
    <%@ include file="../layout/navbar.jsp"%>
        <div class="container emp-profile">
            <c:if test="${!empty participant }">
                <div class="row">
                    <div class="col-md-4">
                        <img src="">
                    </div>
                    <div class="col-md-5">
                        <form method="post">
                            <div class="form-group">
                                <label>Pseudo</label>
                                <input class="form-control" name="pseudo" placeholder="Pseudo" value="${participant.pseudo}" type="text" required>
                            </div>
                            <div class="form-group">
                                <label>Prénom</label>
                                <input class="form-control" name="prenom" placeholder="Prénom" value="${participant.prenom}" type="text" required>
                            </div>
                            <div class="form-group">
                                <label>Nom</label>
                                <input class="form-control" name="nom" placeholder="Nom" value="${participant.nom}"  type="text" required>
                            </div>
                            <div class="form-group">
                                <label>Téléphone</label>
                                <input class="form-control" name="telephone" placeholder="Téléphone" value="<c:if test="${!empty participant.telephone }"> ${participant.telephone} </c:if>"  type="tel">
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" name="email" placeholder="Email" value="${participant.mail}" type="email" required>
                            </div>
                            <div class="form-group">
                                <label>Nouveau mot de passe</label>
                                <input class="form-control" name="password" placeholder="Nouveau mot de passe" type="password">
                            </div>
                            <div class="form-group">
                                <label>Confirmation nouveau mot de passe</label>
                                <input class="form-control" name="confpassword" placeholder="Confirmation nouveau mot de passe" type="password">
                            </div>
                            <div class="form-group">
                                <label>Ville de rattachement</label>
                                <input class="form-control" name="ville" placeholder="" type="">
                            </div>
                            <div class="form-group">
                                <label>Photo</label>
                                <input class="form-control" name="photo" placeholder="" type="file">
                            </div>

                            <button type="submit" class="btn btn-success">Modifier</button>
                            <a href="/" class="btn btn-danger">Annuler</a>
                        </form>
                    </div>
                </div>
            </c:if>
        </div>

<%@ include file="../layout/footer.jsp"%>
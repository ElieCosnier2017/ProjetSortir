<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffffffbd">
    <a class="navbar-brand" href="/">Sortir.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <c:if test="${sessionScope.participant != null}">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="float-right nav-link" href="/ville/gerer">Villes</a>
                </li>
                <li class="nav-item">
                    <a class="float-right nav-link" href="/site/gerer">Sites</a>
                </li>
                <li class="nav-item active">
                    <a class="float-right nav-link" href="/">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="float-right nav-link" href="/profil?id=${sessionScope.participant.idparticipant}">Mon profil</a>
                </li>
                <li class="nav-item">
                    <a class="float-right nav-link" href="/deconnexion">Se deconnecter</a>
                </li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.participant == null}">
            <span class="navbar-text">
                <a href="/inscription" class="float-right btn btn-outline-primary" style="margin-left: 10px;">Inscription</a>
                <a href="/connexion" class="float-right btn btn-outline-primary">Connexion</a>
            </span>
        </c:if>

    </div>
</nav>

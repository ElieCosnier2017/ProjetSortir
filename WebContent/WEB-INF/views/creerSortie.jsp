<%@ page import="fr.eni.sortir.bo.Lieu" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<title>${title} sortie</title>
<link rel="stylesheet"
      href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light"
     style="background-color: #ffffffbd">
    <a class="navbar-brand" href="/">Sortir.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#navbarText" aria-controls="navbarText"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <%--<li class="nav-item active">--%>
            <%--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
            <%--</li>--%>
            <%--<a class="nav-link" href="#">Features</a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
            <%--<a class="nav-link" href="#">Pricing</a>--%>
            <%--</li>--%>
        </ul>
        <span class="navbar-text"> </span>
    </div>
</nav>
<div class="container">
    <div class="row justify-content-md-center" style="margin-top: 5%;">
        <div class="col-sm-10">
            <div class="card">
                <article class="card-body">
                    <h4 class="card-title mb-4 mt-1">Créer une sortie</h4>
                    <form method="post" action="<%=request.getContextPath()%>/${path}">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Nom de la sortie</label>
                                    <input class="form-control" name="nom" placeholder="Nom" type="text">
                                </div>
                                <div class="form-group">
                                    <label>Date et heure de la sortie</label>
                                    <input class="form-control" name="datedebut" type="datetime-local">
                                </div>
                                <div class="form-group">
                                    <label>Date limite d'inscription</label>
                                    <input class="form-control" name="datefin" type="date">
                                </div>
                                <div class="form-group">
                                    <label>Nombre d'inscription</label>
                                    <input class="form-control" name="nbinscription" type="number" min="1" style="width: 5em">
                                </div>
                                <div class="form-group">
                                    <label>Durée (minutes)</label>
                                    <input class="form-control" min="1" name="duree" type="number" style="width: 5em">
                                </div>
                                <div class="form-group">
                                    <label>Description et infos</label>
                                    <textarea class="form-control" name="infos" type="text" style="height: 128px;"></textarea>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Ville organisatrice</label>
                                    <input class="form-control" value="${villeOrga}" name="villeOrga" id="villeOrga" type="text" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Ville</label>
                                    <select id="idVille" name="ville" class="form-control" onchange="setCp()">
                                        <c:forEach var="ville" items="${listeVilles}">
                                            <option value="${ville.idVille}">${ville.nom}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Lieu</label>
                                    <select id="idLieu" name="lieu" class="form-control" onchange="setRue()">
                                        <c:forEach var="lieu" items="${listeLieux}">
                                            <option value="${lieu.idLieu}" >${lieu.nom}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Rue</label>
                                    <input class="form-control" name="rue" id="rue" type="text" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Code postal</label>
                                    <input class="form-control" name="cp" id="cp" type="text" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Latitude</label>
                                    <input class="form-control" name="latitude" id="latitude" type="text" readonly>
                                </div>
                                <div class="form-group">
                                    <label>Longitude</label>
                                    <input class="form-control" name="longitude" id="longitude" type="text" readonly>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-md-4 offset-2">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">
                                        Enregistrer
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <a href="/" type="button" class="btn btn-primary btn-block">
                                        Annuler
                                    </a>
                                </div>
                            </div>
                        </div>
                    </form>
                </article>
            </div>
        </div>
    </div>
</div>
<script>

    window.onload = function ()
    {
        var listLieux = [
            <c:forEach var="lieu" items="${listeLieux}">
            { id : ${lieu.idLieu}, rue :  "${lieu.rue}", latitude : ${lieu.latitude}, longitude : ${lieu.longitude}},
            </c:forEach>
        ];
        var lieu = listLieux.find(
            el => el.id == idLieu
    );
        document.getElementById("rue").value = listLieux[0].rue;
        document.getElementById("latitude").value = listLieux[0].latitude;
        document.getElementById("longitude").value = listLieux[0].longitude;

        var listVilles = [
            <c:forEach var="ville" items="${listeVilles}">
            { id : ${ville.idVille}, cp :  "${ville.codePostal}"},
            </c:forEach>
        ];
        document.getElementById("cp").value = listVilles[0].cp;
    };

    var listLieux = [
        <c:forEach var="lieu" items="${listeLieux}">
        { id : ${lieu.idLieu}, rue :  "${lieu.rue}", latitude : ${lieu.latitude}, longitude : ${lieu.longitude}},
        </c:forEach>
    ];

    var listVilles = [
        <c:forEach var="ville" items="${listeVilles}">
            { id : ${ville.idVille}, cp :  "${ville.codePostal}"},
        </c:forEach>
    ];

    function setRue() {
        var e = document.getElementById("idLieu");
        var idLieu = e.value;
        var rue = listLieux.find(
            el => el.id == idLieu
    );
        document.getElementById("rue").value = rue.rue;
        document.getElementById("latitude").value = rue.latitude;
        document.getElementById("longitude").value = rue.longitude;
    }

        function setCp() {
            var e = document.getElementById("idVille");
            var idVille = e.value;
            var cp = listVilles.find(
                el => el.id == idVille
        );
            document.getElementById("cp").value = cp.cp;
        }
</script>
<%@ include file="../layout/footer.jsp" %>

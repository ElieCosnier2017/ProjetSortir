<%@ page import="fr.eni.sortir.bo.Lieu" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.media.sound.SimpleSoundbank" %>
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
                    <h4 class="card-title mb-4 mt-1">${title} une sortie</h4>
                    <form method="post" action="<%=request.getContextPath()%>/${path}">
                       <div class="col-md-6">
                           <div class="row">
                               <div class="form-group">
                                   <label>Nom de la sortie: </label>
                                   <input class="form-control" name="nom" type="text" value="${sortie.nom}">
                               </div>
                           </div>
                           <div class="row">
                               <div class="form-group">
                                   <label>Date de la sortie :</label>
                                   <input class="form-control" name="datedebut" type="datetime-local" value="${villeOrga}">
                               </div>
                           </div>
                           <div class="row">
                               <div class="form-group">
                                   <label>Ville organisatrice :</label>
                                   <input class="form-control" name="villeOrga" type="text" value="${villeOrga}">
                               </div>
                           </div>
                           <div class="row">
                               <div class="form-group">
                                   <label>Lieu :</label>
                                   <input class="form-control" name="lieu" type="text" value="${lieu}">
                               </div>
                           </div>
                           <div class="row">
                               <div class="form-group">
                                   <label>Motif :</label>
                                   <textarea class="form-control" name="motif" type="text" style="height: 128px;"></textarea>
                               </div>
                           </div>
                       </div>
                        <br>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">
                                        Enregistrer
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <button type="button" href="/" class="btn btn-primary btn-block">
                                        Annuler
                                    </button>
                                </div>
                            </div>
                        </div>
                    </form>
                </article>
            </div>
        </div>
    </div>
</div>
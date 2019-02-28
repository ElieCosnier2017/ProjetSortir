<%@ page contentType="text/html;charset=UTF-8"
errorPage="errors.jsp" %>
<%@ include file="../layout/entete.jsp" %>
        <title>Sortir.com - Connexion</title>
    </head>
    <body>
    <%@ include file="../layout/navbar.jsp"%>
        <div class="container">
            <div class="row justify-content-md-center" style="margin-top: 10%;">
                <div class="col-sm-6">
                    <div class="card">
                        <article class="card-body">
                            <a href="/inscription" class="float-right btn btn-outline-primary">Inscription</a>
                            <h4 class="card-title mb-4 mt-1">Connexion</h4>
                            <form method="post">
                                <div class="form-group">
                                    <label>Votre email ou votre pseudo</label>
                                    <span>${ loginParticipant }</span>
                                    <input class="form-control" name="email" value="${ loginParticipant }" placeholder="Email ou Pseudo" type="text" autofocus required>
                                </div>
                                <div class="form-group">
                                    <label>Ton mot de passe</label>
                                    <input class="form-control" name="mdp" placeholder="******" type="password" required>
                                </div>
                                <div class="form-group">
                                    <div class="checkbox">
                                        <label><input type="checkbox" name="remember" id="remember"> Se souvenir de moi </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block"> Connexion </button>
                                </div>
                            </form>
                        </article>
                    </div>
                </div>
            </div>
        </div>
<%@ include file="../layout/footer.jsp"%>
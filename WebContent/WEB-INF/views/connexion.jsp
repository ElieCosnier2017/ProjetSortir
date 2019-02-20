<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
        <title>Sortir.com - Connexion</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffffffbd">
            <a class="navbar-brand" href="/">Sortir.com</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <%--<li class="nav-item active">--%>
                    <%--<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
                    <%--</li>--%>
                    <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="#">Features</a>--%>
                    <%--</li>--%>
                    <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="#">Pricing</a>--%>
                    <%--</li>--%>
                </ul>
                <span class="navbar-text">

                </span>
            </div>
        </nav>
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
                                    <input class="form-control" name="email" placeholder="Email ou Pseudo" type="text" required>
                                </div>
                                <div class="form-group">
                                    <label>Ton mot de passe</label>
                                    <input class="form-control" name="mdp" placeholder="******" type="password" required>
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
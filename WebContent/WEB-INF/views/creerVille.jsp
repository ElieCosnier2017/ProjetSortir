<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp" %>

title>Sortir.com - Créer une ville</title>
<link rel="stylesheet"
      href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<%@ include file="../layout/navbar.jsp"%>
<div class="container">
    <div class="row justify-content-md-center" style="margin-top: 5%;">
        <div class="col-sm-6">
            <div class="card">
                <article class="card-body">
                    <h4 class="card-title mb-4 mt-1">Créer une ville</h4>
                    <form method="post" action="/ville/creerVille">
                        <div style="display: inline-flex">
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Nom de la ville</label>
                                    <input class="form-control" name="nom" placeholder="Nom" type="text">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Code postal</label>
                                    <input class="form-control" name="cp" placeholder="code postal" type="text">
                                </div>
                            </div>
                        </div>
                        <div style="display: inline-flex; margin-left: 4em;">
                            <div class="col-md-8">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">
                                        Enregistrer
                                    </button>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="form-group">
                                    <button type="button" href="/ville/gererVille" class="btn btn-primary btn-block">
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
</body>
</html>

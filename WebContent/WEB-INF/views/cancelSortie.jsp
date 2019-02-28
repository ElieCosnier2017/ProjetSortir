<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>

<title>Sortir.com - Detail sortie</title>
</head>
<body>
<%@ include file="../layout/navbar.jsp"%>
<div class="container emp-profile">
    <form method="post">
        <div class="tab-content profile-tab" id="myTabContent">
            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">

                <div class="row">
                    <div class="col-md-6">
                        <label>Nom de la sortie</label>
                    </div>
                    <div class="col-md-6">
                        ${ sortie.getNom() }
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Date de la sortie</label>
                    </div>
                    <div class="col-md-6">
                        ${ sortie.getDateDebut() }
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Ville organisatrice</label>
                    </div>
                    <div class="col-md-6">
                        ${ site.getNom() }
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Lieu</label>
                    </div>
                    <div class="col-md-6">
                        ${ lieu.getNom() }
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Motif</label>
                    </div>
                    <div class="col-md-6">
                        <textarea name="motif" rows="5"></textarea>
                    </div>
                </div>
                <div>
                    <button type="submit" class="btn btn-primary">
                        Valider
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
<%@ include file="../layout/footer.jsp"%>
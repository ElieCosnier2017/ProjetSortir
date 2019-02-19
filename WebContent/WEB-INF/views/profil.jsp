<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sortir.com - Gestion du profil</title>
    <link href="<%=request.getContextPath() %>/vendor/bootstrap/css/bootstrap.css" rel="stylesheet" id="bootstrap-css">
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
    <script src="<%=request.getContextPath() %>/vendor/bootstrap/css/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath() %>/jquery/jquery.js"></script>
</head>
<body>
    <div class="container emp-profile">
        <form method="post">
            <div class="row">
                <div class="col-md-4">
                    <img src="">
                    <h5>
                        Kshiti Ghelani
                    </h5>
                    <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                </div>
                <div class="col-md-6">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Pseudo</label>
                                </div>
                                <div class="col-md-6">
                                    <p>Kshiti123</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Nom Prenom</label>
                                </div>
                                <div class="col-md-6">
                                    <p>Kshiti Ghelani</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <div class="col-md-6">
                                    <p>kshitighelani@gmail.com</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Téléhone</label>
                                </div>
                                <div class="col-md-6">
                                    <p>02 00 00 00 00</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>

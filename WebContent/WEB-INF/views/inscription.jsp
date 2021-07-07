<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
		<title>Sortir.com - Inscription</title>
	</head>
	<body>
	<%@ include file="../layout/navbar.jsp"%>
		<div class="container">
			<div class="row justify-content-md-center" style="margin-top: 5%;">
				<div class="col-sm-10">

                    <div class="card">
						<article class="card-body">
							<h4 class="card-title mb-4 mt-1">Inscription</h4>
							<form method="post">
								<div class="row">
									<div class="col-6">
										<div class="form-group">
											<label>Nom</label>
											<input class="form-control" name="nom" placeholder="Nom" type="text" required>
										</div>
										<div class="form-group">
											<label>Téléphone</label>
											<input class="form-control" name="telephone" placeholder="Téléphone" type="tel" >
										</div>
										<div class="form-group">
											<label>Pseudo</label>
											<input class="form-control" name="pseudo" placeholder="Pseudo" type="text"required>
										</div>
									</div>
									<div class="col-6">
										<div class="form-group">
											<label>Prénom</label>
											<input class="form-control" name="prenom" placeholder="Prénom" type="text" required>
										</div>
										<div class="form-group">
											<label>Email</label>
											<input class="form-control" name="email" placeholder="Email" type="email" required>
										</div>
										<div class="form-group">
											<label>Mot de passe</label>
											<input class="form-control" name="password" placeholder="*********" type="password" required>
										</div>
									</div>
								</div>
								<br>
								<div class="form-group">
									<button type="submit" class="btn btn-primary btn-block"> S'inscrire  </button>
								</div>
							</form>
						</article>
					</div>
				</div>
			</div>
		</div>
<%@ include file="../layout/footer.jsp"%>

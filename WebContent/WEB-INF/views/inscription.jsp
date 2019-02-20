<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../layout/entete.jsp"%>
		<title>Sortir.com - Inscription</title>
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
			<div class="row justify-content-md-center" style="margin-top: 5%;">
				<div class="col-sm-10">
					<div class="card">
						<article class="card-body">
							<h4 class="card-title mb-4 mt-1">Inscription</h4>
							<form method="post" action="inscription">
								<div class="row">
									<div class="col-6">
										<div class="form-group">
											<label>Nom</label>
											<input class="form-control" name="nom" placeholder="Nom" type="text">
										</div>
										<div class="form-group">
											<label>Téléphone</label>
											<input class="form-control" name="telephone" placeholder="Téléphone" type="tel">
										</div>
										<div class="form-group">
											<label>Pseudo</label>
											<input class="form-control" name="pseudo" placeholder="Pseudo" type="text">
										</div>
									</div>
									<div class="col-6">
										<div class="form-group">
											<label>Prénom</label>
											<input class="form-control" name="prenom" placeholder="Prénom" type="text">
										</div>
										<div class="form-group">
											<label>Email</label>
											<input class="form-control" name="mail" placeholder="Email" type="email">
										</div>
										<div class="form-group">
											<label>Mot de passe</label>
											<input class="form-control" name="password" placeholder="*********" type="password">
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

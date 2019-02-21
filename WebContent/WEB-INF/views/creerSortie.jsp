<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../layout/entete.jsp"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<title>Sortir.com - Créer sortie</title>
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
						<form method="post" action="/Sortir">
							<div class="row">
								<div class="col-6">
									<div class="form-group">
										<label>Nom</label> <input class="form-control" name="nom"
											placeholder="Nom" type="text">
									</div>
									<div style="display: inline-flex;">
										<div class="form-group">
											<label>Date de début</label> <input class="form-control"
												id="datepicker" name="datedebut" type="text"
												style="width: 7em;">
										</div>
										<div class="form-group" style="padding-left: 62px">
											<label>Durée</label> <input class="form-control" min="1"
												name="duree" type="number" style="width: 5em">
										</div>
										<div class="form-group" style="padding-left: 59px">
											<label>Date de fin</label> <input class="form-control"
												id="datepicker2" name="datefin" type="text"
												style="width: 7em;">
										</div>
									</div>
									<div class="form-group">
										<label>Organisateur</label> <input class="form-control"
											name="nom" placeholder="organisateur" type="text">
									</div>
								</div>
								<div class="col-6">
									<div class="form-group">
										<label>Nombre d'inscription</label> <input
											class="form-control" name="nbinscription" type="number"
											min="1" style="width: 5em">
									</div>
									<div class="form-group">
										<label>Infos</label> <input class="form-control" name="infos"
											placeholder="Infos" type="text">
									</div>
									<div class="form-group">
										<label>Photo</label> <input class="form-control" name="photo"
											accept="image/*" type="file">
									</div>
									<div class="form-group">

										2 ${requestScope.listeLieux.size()}
											<c:forEach items="${listeLieux}" var="item">
    											${item.nom}<br>
    											${item.getNom()}<br>
											</c:forEach>
										<select>

						
								
										</select>
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block">
									S'inscrire</button>
							</div>
						</form>
					</article>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document.ready(function(){
			$(function() {
				$("#datepicker").datepicker();
			});
			$(function() {
				$("#datepicker2").datepicker();
			});
		}))
	</script>
	<%@ include file="../layout/footer.jsp"%>
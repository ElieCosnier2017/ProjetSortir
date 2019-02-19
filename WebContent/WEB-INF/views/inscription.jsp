<%@ include file="../layout/entete.jsp"%>

<!-- Page Content -->
<div class="row"></div>
	<div class="form ">

		<div class="site-title col-md-4">
			<span>Sortir.com</span>
		</div>

		<c:if test="${param.message != null}">
			<div class="col-md-6 mb-2 alert alert-danger"
				role="alert">
				<strong>${param.message}</strong>
			</div>
		</c:if>

		<form method="post" action="InscriptionServlet" class="col-md-8">
			<label>Nom :</label>
			<input type="text" placeholder="Votre nom" name="nom"><br />
			<label>Prénom :</label> 
			<input type="text" placeholder="Votre prénom" name="prenom"><br />
			<label>Pseudo :</label>
			<input type="text" placeholder="Votre pseudo" name="mail"><br />
			<label>Téléphone :</label>
			<input type="text" placeholder="Votre téléphone" name="telephone"><br />
			<label>email :</label>
			<input type="text" placeholder="Votre mail" name="mail"><br />
			<label>Mot de passe :</label>
			<input type="password" placeholder="Votre mot de passe" name="password"><br />						
			<input type="submit" value="inscrire"><br />
		</form>
	</div>

<%@ include file="../layout/footer.jsp"%>

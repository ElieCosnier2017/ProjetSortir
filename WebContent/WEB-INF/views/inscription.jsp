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
			<label for="nom">Nom :</label>
			<input type="text" placeholder="Votre nom" name="nom"><br />
			<label for="prenom">Prénom :</label> 
			<input type="text" placeholder="Votre prénom" name="prenom"><br />
			<label for="pseudo">Pseudo :</label>
			<input type="text" placeholder="Votre pseudo" name="pseudo"><br />
			<label for="telephone">Téléphone :</label>
			<input type="text" placeholder="Votre téléphone" name="telephone"><br />
			<label for="mail">email :</label>
			<input type="text" placeholder="Votre mail" name="mail"><br />
			<label for="password">Mot de passe :</label>
			<input type="password" placeholder="Votre mot de passe" name="password"><br />
			<label for="actif">Actif :</label>
			<input type="checkbox" name="actif"><br />	
			<label for="admin">Administrateur :</label>
			<input type="checkbox" name="admin"><br />							
			<input type="submit" value="inscrire"><br />
		</form>
	</div>

<%@ include file="../layout/footer.jsp"%>

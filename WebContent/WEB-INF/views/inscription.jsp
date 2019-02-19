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
			<label for="prenom">Pr�nom :</label> 
			<input type="text" placeholder="Votre pr�nom" name="prenom"><br />
			<label for="pseudo">Pseudo :</label>
			<input type="text" placeholder="Votre pseudo" name="pseudo"><br />
			<label for="telephone">T�l�phone :</label>
			<input type="text" placeholder="Votre t�l�phone" name="telephone"><br />
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

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
			<input type="text" placeholder="Votre nom" name="nom"> 
			<input type="text" placeholder="Votre prénom" name="prenom">
			<input type="text" placeholder="Votre téléphone" name="telephone">
			<input type="text" placeholder="Votre mail" name="mail">						
			<input type="submit" value="inscrire"><br />
		</form>
	</div>

<%@ include file="../layout/footer.jsp"%>

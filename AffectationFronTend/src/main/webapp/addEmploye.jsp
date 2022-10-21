 <%@ include file="/static/headers.jsp" %>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="/AffectationEmploye/emp-add" method="POST">
					<span class="login100-form-title p-b-26">
						Ajouter un Employe
					</span>
					
					<div class="wrap-input100 ">
						<input class="input100" type="text" name="code" required>
						<span class="focus-input100" data-placeholder="CodeEmploye"></span>
					</div>

					<div class="wrap-input100 ">
						<input class="input100" type="text" name="nom" required>
						<span class="focus-input100" data-placeholder="Nom"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="text" name="prenom" required>
						<span class="focus-input100" data-placeholder="Prenom"></span>
					</div>

					<div class="wrap-input100 " >
						<input class="input100" type="text" name="poste" required>
						<span class="focus-input100" data-placeholder="Poste"></span>
					</div>

					
					
							<button class="btn btn-primary">
							Ajouter
							</button>
					

						<a href="/AffectationEmploye/employe"class="btn btn-default" role="button" style="margin-left: 190px; margin-top: -60px">Annuler</a>
				</form>
			</div>
		</div>
	</div>
	
	
	 <%@ include file="/static/footers.jsp" %>
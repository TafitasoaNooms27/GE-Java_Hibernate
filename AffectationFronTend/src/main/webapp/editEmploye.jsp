 <%@ include file="/static/headers.jsp" %>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="/AffectationEmploye/emp-update" method="POST">
					<span class="login100-form-title p-b-26">
						Modifier un Employe
					</span>
					<input value="${employe.idEmploye}" type="hidden" name="id">
					<div class="wrap-input100 ">
						<input class="input100" type="text"  value="${employe.codeEmploye}" name="code" required>
						<span class="focus-input100" "></span>
					</div>

					<div class="wrap-input100 ">
						<input class="input100" type="text" value="${employe.nom}" name="nom" required>
						<span class="focus-input100" ></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="text" value="${employe.prenom}" name="prenom" required>
						<span class="focus-input100" ></span>
					</div>

					<div class="wrap-input100 " >
						<input class="input100" type="text" value="${employe.poste}"  name="poste">
						<span class="focus-input100" ></span>
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
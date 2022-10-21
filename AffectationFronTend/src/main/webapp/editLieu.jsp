 <%@ include file="/static/headers.jsp" %>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="/AffectationEmploye/lieu-update" method="POST">
					<span class="login100-form-title p-b-26">
						Modifier un Lieu
					</span>
					<input value="${lieu.idLieu}" type="hidden" name="id">
					<div class="wrap-input100 ">
						<input class="input100" type="text"  value="${lieu.codeLieu}" name="code" required>
						<span class="focus-input100" ></span>
					</div>

					<div class="wrap-input100 ">
						<input class="input100" type="text" value="${lieu.designation}" name="designation" required>
						<span class="focus-input100" ></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="text" value="${lieu.province}" name="province" required>
						<span class="focus-input100" ></span>
					</div>
					
					
							<button class="btn btn-primary">
							Ajouter
							</button>

						<a href="/AffectationEmploye/lieu"class="btn btn-default" role="button" style="margin-left: 190px; margin-top: -60px">Annuler</a>
				</form>
			</div>
		</div>
	</div>
	
	
	 <%@ include file="/static/footers.jsp" %>
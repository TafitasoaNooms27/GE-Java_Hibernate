 <%@ include file="/static/headers.jsp" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="/AffectationEmploye/affec-add" method="POST">
					<span class="login100-form-title p-b-26">
						Ajouter une Affectation
					</span>
					
					<div class="input-group">
						<div class="rs-select2 js-select-simple select--no-search" style="width: 300px;">
							<select name="employe">
          							<c:forEach var ="employe" items="${employes}" >
  											  <option value="<c:out value="${employe.idEmploye}"/>"><c:out value="${employe.codeEmploye}  ${employe.nom}"/> </option>
  									</c:forEach>
						</select>
							<div class="select-dropdown"></div>
						</div>
					</div>

						<div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search" style="width: 300px;">
                                <select name="lieu">
  				 					 <c:forEach var ="lieu" items="${lieus}" >
    											 <option value="<c:out value="${lieu.idLieu}"/>"><c:out value="${lieu.codeLieu} ${lieu.designation} "/> </option>
    			  					</c:forEach>
 		 						</select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>

					
						<div class="row row-space">
                            <div class="wrap-input100 ">
                                
                                    <input class="input--style-1 js-datepicker"  type="text" name="date">
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                
                            </div>
                           
                        </div>
					
							<button class="btn btn-primary">
							Ajouter</button>
					
				
						<a href="/AffectationEmploye/affecter" role="button" class="btn btn-default" style="margin-left: 190px; margin-top: -60px">
							Annuler
						</a>
				</form>
			</div>
		</div>
	</div>
 
 
  <%@ include file="/static/footers.jsp" %>
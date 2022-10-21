 
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="com.projects.affectation.backend.dto.AffecterFullDTO,
	com.projects.affectation.backend.dto.EmployeFullDTO,
	com.projects.affectation.backend.dto.LieuFullDTO,
	com.projects.affectation.backend.service.AffecterService,
	com.projects.affectation.backend.service.EmployeService,
	com.projects.affectation.backend.service.LieuService,
	java.util.List , java.text.SimpleDateFormat,
java.util.Date,
 java.util.Scanner" %>
	
	<%@ include file="/static/headers.jsp" %>

 <div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="/AffectationEmploye/affec-update" method="POST">
				
				
					<span class="login100-form-title p-b-26">
						Modifier une Affectation
					</span>
					
					
				
				<%
				EmployeService employeService = new EmployeService();
				LieuService lieuService = new LieuService();
				AffecterService affecterService = new AffecterService();
	
				int id = Integer.valueOf(request.getParameter("id"));
				List<EmployeFullDTO> employes = employeService.getListTousEmployers();
				List<LieuFullDTO> lieus = lieuService.getListTousLieu();
				AffecterFullDTO affecter = affecterService.getAffecter(id);
	%>
				<input type="hidden" value="<%= affecter.getIdAffecter() %>" name="id">
					
					<div class="input-group">
						<div class="rs-select2 js-select-simple select--no-search" style="width: 300px;">
							<select name="employe">
          							<% for (EmployeFullDTO em: employes ) {%>
    											<option value="<%= em.getIdEmploye() %>" <% if (em.getIdEmploye() == affecter.getEmploye().getIdEmploye()){ %> selected <%} %>  ><%= em.getCodeEmploye()  %> <%= em.getNom()  %></option>
    								<%} %>
							</select>
							<div class="select-dropdown"></div>
						</div>
					</div>

						<div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search" style="width: 300px;">
                                <select name="lieu">
  													<% for (LieuFullDTO lieu: lieus) {%>
    														<option value="<%= lieu.getIdLieu() %>" <% if(lieu.getIdLieu() == affecter.getLieu().getIdLieu()){ %> selected <%} %>><%= lieu.getCodeLieu() %> <%= lieu.getDesignation() %> </option>
 		 											<% } %>
 									 </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>

							<%   SimpleDateFormat fDate=new SimpleDateFormat("dd/MM/yyyy");
				            %>
						<div class="row row-space">
                            <div class="wrap-input100 ">
                                	<label  class="input100"  >Date (yyy-MM-dd)</label>
                                    <input  class="input100" type="text"  value="<%= affecter.getDate().toString().substring(0, 10) %>" name="date">
                                    
                                
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
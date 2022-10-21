package com.eni.affecemploye.controller.employe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.EmployeFullDTO;
import com.projects.affectation.backend.service.EmployeService;

@SuppressWarnings("serial")
public class AddEmpServlet  extends HttpServlet{
	
public EmployeService employeService ;
	
	public AddEmpServlet() {
		
		this.employeService = new EmployeService();
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prenoms = req.getParameter("prenom");
		String poste = req.getParameter("poste");
		EmployeFullDTO emp = new EmployeFullDTO();
		emp.setCodeEmploye(code);
		emp.setNom(nom);
		emp.setPrenom(prenoms);
		emp.setPoste(poste);
		this.employeService.createEmploye(emp);
		res.sendRedirect("/AffectationEmploye/employe");
	}
}

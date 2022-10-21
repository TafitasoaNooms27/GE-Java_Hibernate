package com.eni.affecemploye.controller.employe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.service.EmployeService;

@SuppressWarnings("serial")
public class EmployeUpdateServlet extends HttpServlet {

	public EmployeService employeService ;
	
	public EmployeUpdateServlet() {
		
		this.employeService = new EmployeService();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		String code = req.getParameter("code");
		String nom = req.getParameter("nom");
		String prenoms = req.getParameter("prenom");
		String poste = req.getParameter("poste");
		this.employeService.modifierEmploye(id, code, nom, prenoms, poste);
		resp.sendRedirect("/AffectationEmploye/employe");
	}
}

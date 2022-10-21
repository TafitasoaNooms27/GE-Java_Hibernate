package com.eni.affecemploye.controller.affectation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.service.AffecterService;

public class DeleteAffecterServlet  extends HttpServlet{
	
	
public AffecterService  affecterService;
	
	public DeleteAffecterServlet() {
		
		this.affecterService = new AffecterService();
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int code = Integer.valueOf(req.getParameter("id"));
		this.affecterService.deleteAffectation(code);
		resp.sendRedirect("/AffectationEmploye/affecter");
	}
	
}

package com.eni.affecemploye.controller.employe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.service.EmployeService;

@SuppressWarnings("serial")
public class DeleteEmpServlet extends HttpServlet{
	public EmployeService employeService ;
	
	public DeleteEmpServlet() {
		
		this.employeService = new EmployeService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		this.employeService.deleteEmploye(id);
		resp.sendRedirect("/AffectationEmploye/employe");
	}
}

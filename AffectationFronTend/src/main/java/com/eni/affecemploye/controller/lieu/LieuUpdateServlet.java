package com.eni.affecemploye.controller.lieu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.service.LieuService;

@SuppressWarnings("serial")
public class LieuUpdateServlet extends HttpServlet{

	
public LieuService lieuService ;
	
	public LieuUpdateServlet() {
		
		this.lieuService = new LieuService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		String code = req.getParameter("code");
		String designation= req.getParameter("designation");
		String province = req.getParameter("province");
		this.lieuService.modifierLieu(id, code, designation, province);
		resp.sendRedirect("/AffectationEmploye/lieu");
	}
}

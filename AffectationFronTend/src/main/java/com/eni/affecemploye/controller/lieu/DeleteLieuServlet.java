package com.eni.affecemploye.controller.lieu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.service.LieuService;

@SuppressWarnings("serial")
public class DeleteLieuServlet extends HttpServlet{
	
public LieuService lieuService ;
	
	public DeleteLieuServlet() {
		
		this.lieuService = new LieuService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int code = Integer.valueOf(req.getParameter("id"));
		this.lieuService.deleteLieu(code);
		resp.sendRedirect("/AffectationEmploye/lieu");
	}

}

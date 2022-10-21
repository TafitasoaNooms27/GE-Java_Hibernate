package com.eni.affecemploye.controller.lieu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.service.LieuService;

@SuppressWarnings("serial")
public class EditLieuServlet  extends HttpServlet{
	
public LieuService lieuService ;
	
	public EditLieuServlet() {
		
		this.lieuService = new LieuService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.valueOf(req.getParameter("id"));
		LieuFullDTO lieu = this.lieuService.getLieu(id);
		req.setAttribute("lieu", lieu);
		req.getRequestDispatcher("editLieu.jsp").forward(req, resp);
	}

}

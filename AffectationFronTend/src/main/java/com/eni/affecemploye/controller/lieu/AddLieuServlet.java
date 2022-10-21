package com.eni.affecemploye.controller.lieu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.service.LieuService;


@SuppressWarnings("serial")
public class AddLieuServlet  extends HttpServlet{

public LieuService lieuService ;
	
	public AddLieuServlet() {
		
		this.lieuService = new LieuService();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html");
		String code = req.getParameter("code");
		String designation = req.getParameter("designation");
		String province = req.getParameter("province");
		LieuFullDTO lieu = new LieuFullDTO();
		lieu.setCodeLieu(code);
		lieu.setDesignation(designation);
		lieu.setProvince(province);
		this.lieuService.createLieu(lieu);
		res.sendRedirect("/AffectationEmploye/lieu");
	}
}

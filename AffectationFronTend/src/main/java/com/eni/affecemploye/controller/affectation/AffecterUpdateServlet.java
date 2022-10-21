package com.eni.affecemploye.controller.affectation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.AffecterFullDTO;
import com.projects.affectation.backend.dto.EmployeFullDTO;
import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.service.AffecterService;
import com.projects.affectation.backend.service.EmployeService;
import com.projects.affectation.backend.service.LieuService;

@SuppressWarnings("serial")
public class AffecterUpdateServlet extends HttpServlet{
	
	public  AffecterService affecterService;
	
	public AffecterUpdateServlet(){
		this.affecterService = new AffecterService();
		
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	
	try {
		
		
		res.setContentType("text/html");
	
	//	EmployeService employeService = new EmployeService();
		// LieuService lieuService = new LieuService();
		int id = Integer.valueOf(req.getParameter("id"));
		int idEmploye = Integer.valueOf(req.getParameter("employe"));
		int idLieu = Integer.valueOf(req.getParameter("lieu"));
		String sDate = req.getParameter("date");
		SimpleDateFormat fDate=new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date1 =fDate.parse(sDate);
        java.sql.Date date = new java.sql.Date(date1.getTime());
       // EmployeFullDTO em = employeService.getEmploye(idLieu);
       // LieuFullDTO li = lieuService.getLieu(idLieu);
        this.affecterService.modifierAffectation(id, idEmploye, idLieu, date);
        
		res.sendRedirect("/AffectationEmploye/affecter");

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} 
	}
	
}

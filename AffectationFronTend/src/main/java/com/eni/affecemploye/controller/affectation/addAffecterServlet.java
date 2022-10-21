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

@SuppressWarnings("serial")
public class addAffecterServlet  extends HttpServlet{

	public  AffecterService affecterService;
	
	public addAffecterServlet(){
		this.affecterService = new AffecterService();
		
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			res.setContentType("text/html");
			int idEmploye = Integer.valueOf(req.getParameter("employe"));
			int idLieu = Integer.valueOf(req.getParameter("lieu"));
			String sDate = req.getParameter("date");
			SimpleDateFormat fDate=new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date1 =fDate.parse(sDate);
            java.sql.Date date = new java.sql.Date(date1.getTime());
			AffecterFullDTO affecter = new AffecterFullDTO();
			affecter.setEmploye(new EmployeFullDTO());
			affecter.getEmploye().setIdEmploye(idEmploye);
			affecter.setLieu(new LieuFullDTO());
			affecter.getLieu().setIdLieu(idLieu);
			affecter.setDate(date);
			this.affecterService.createAffectation(affecter);
			res.sendRedirect("/AffectationEmploye/affecter");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}

package com.eni.affecemploye.controller.affectation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.AffecterFullDTO;
import com.projects.affectation.backend.service.AffecterService;

@SuppressWarnings("serial")
public class AffecterServlet extends HttpServlet {
	
	
public AffecterService  affecterService;
	
	public AffecterServlet() {
		
		this.affecterService = new AffecterService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
        List<AffecterFullDTO> listesAllAffecter = affecterService.getListTousAffectations();
        req.setAttribute("listesAllAffecter", listesAllAffecter);
        RequestDispatcher dispatcher = req.getRequestDispatcher("affecter.jsp");
        dispatcher.forward(req,res);
    
	}
	
}
	
	



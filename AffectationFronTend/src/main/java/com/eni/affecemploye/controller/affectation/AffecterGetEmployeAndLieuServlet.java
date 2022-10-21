package com.eni.affecemploye.controller.affectation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.EmployeFullDTO;
import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.entity.Employe;
import com.projects.affectation.backend.entity.Lieu;
import com.projects.affectation.backend.service.EmployeService;
import com.projects.affectation.backend.service.LieuService;

@SuppressWarnings("serial")
public class AffecterGetEmployeAndLieuServlet extends HttpServlet{
	
		public EmployeService employeService;
		public LieuService lieuService ;
			
			public AffecterGetEmployeAndLieuServlet() {
				this.employeService = new EmployeService();
				this.lieuService = new LieuService();
			}
			
			protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				
				
			List<EmployeFullDTO> employes = employeService.getListTousEmployers();
			List<LieuFullDTO> lieus = lieuService.getListTousLieu();
			
			req.setAttribute("lieus", lieus);
			req.setAttribute("employes", employes);
			RequestDispatcher disp = req.getRequestDispatcher("addAffecter.jsp");
			disp.forward(req, res);

			}
				
			
}

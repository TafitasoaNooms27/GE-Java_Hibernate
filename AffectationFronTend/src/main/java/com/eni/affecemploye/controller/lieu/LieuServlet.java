package com.eni.affecemploye.controller.lieu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.LieuFullDTO;
import com.projects.affectation.backend.service.LieuService;

@SuppressWarnings("serial")
public class LieuServlet  extends HttpServlet{
	
public LieuService lieuService ;
	
	public LieuServlet() {
		
		this.lieuService = new LieuService();
	}
	
	
	 @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


         List<LieuFullDTO> listesAllLieu = lieuService.getListTousLieu();

         req.setAttribute("listesAllLieu", listesAllLieu);

         RequestDispatcher dispatcher = req.getRequestDispatcher("lieu.jsp");
         dispatcher.forward(req,resp);
     }
}

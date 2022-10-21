package com.eni.affecemploye.controller.employe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projects.affectation.backend.dto.EmployeFullDTO;
import com.projects.affectation.backend.service.EmployeService;

@SuppressWarnings("serial")
public class EmployeServlet extends HttpServlet {

	public EmployeService employeService ;
	
	public EmployeServlet() {
		
		this.employeService = new EmployeService();
	}

     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


         List<EmployeFullDTO> listesAllEmploye = employeService.getListTousEmployers();

         req.setAttribute("listesAllEmploye", listesAllEmploye);

         RequestDispatcher dispatcher = req.getRequestDispatcher("employe.jsp");
         dispatcher.forward(req,resp);
     }


}

package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.CarDetails;


public class ServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String car_reg_no =request.getParameter("carRegistrationNo");
		CarDetails c= new CarDetails();
		c.setCar_registration_no(car_reg_no);
		
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		c.setUsername(username);
		int rows=c.serviceStatus();
		 
		if(rows==-1) {
			response.sendRedirect("/Car-service-system/statusfail.jsp");
		}
		else if(rows==0) {
			response.sendRedirect("/Car-service-system/statusfail.jsp");
		}
		else {
			session.setAttribute("service_status", c.getService_status());
			response.sendRedirect("/Car-service-system/statusSucess.jsp");
		}
	}
}

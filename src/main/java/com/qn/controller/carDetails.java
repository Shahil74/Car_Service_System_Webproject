package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.CarDetails;

public class carDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String car_model=request.getParameter("car_model");
		String car_type=request.getParameter("car_type");
		String car_registration_no=request.getParameter("car_registration_no");
		HttpSession session=request.getSession();
		String username =(String)session.getAttribute("username");
		CarDetails c=new CarDetails();
		c.setUsername(username);
		c.setCar_model(car_model);
		c.setCar_registration_no(car_registration_no);
		c.setCar_type(car_type);
		int rows=c.carDetails();
		if(rows==0) {
			response.sendRedirect("/Car-service-system/carDetailsFailure.jsp");
			
		}
		else {
			response.sendRedirect("/Car-service-system/carDetailsSuccess.jsp");
			
		}
	}
}

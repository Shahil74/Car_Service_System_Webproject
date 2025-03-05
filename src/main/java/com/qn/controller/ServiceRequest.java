package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.CarDetails;

public class ServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceRequest=request.getParameter("serviceRequest");
		String carRegNo=request.getParameter("car_reg_no");
		CarDetails c=new CarDetails();
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		c.setService_requested(serviceRequest);
		c.setUsername(username);
		c.setCar_registration_no(carRegNo);
		int status=c.serviceRequest();
		if(status==0) {
			response.sendRedirect("/Car-service-system/serviceRequestFailure.jsp");
		}
		else {
			response.sendRedirect("/Car-service-system/serviceRequestedSucess.jsp");
		}
	}
}

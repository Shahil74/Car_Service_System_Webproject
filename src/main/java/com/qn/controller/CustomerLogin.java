package com.qn.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Customer;

public class CustomerLogin extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Customer c= new Customer();
		c.setUsername(username);
		c.setPassword(password);
		String status=c.customerLogin();
		if(status=="0" ) {
			response.sendRedirect("/Car-service-system/invalidCustomerPassword.jsp");
		}
		else if(status=="-1") {
			response.sendRedirect("/Car-service-system/invalidCustomerUN.jsp");
			
		}
		else {
			HttpSession session=request.getSession(true);
			session.setAttribute("username", status);
			response.sendRedirect("/Car-service-system/customerLoginSucess.jsp");
		}
		

	}
	
}

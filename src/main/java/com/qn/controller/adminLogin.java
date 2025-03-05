package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.adminDetail;


public class adminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminusername=request.getParameter("adminusername");
		String adminpassword=request.getParameter("adminpassword");
		adminDetail ad=new adminDetail();
		ad.setAdminusername(adminusername);
		ad.setAdminpassword(adminpassword);
		int rows=ad.adminLogin();
		if(rows==-1) {
			response.sendRedirect("/Car-service-system/invalidusername.jsp");
		}
		else if(rows==-2) {
				response.sendRedirect("/Car-service-system/invalidpassword.jsp");
		}
		else if(rows== 0) {
			response.sendRedirect("/Car-service-system/invalidusername.jsp");
		}
		else {
			response.sendRedirect("/Car-service-system/adminloginsucess.jsp");
		}
			
		
	}
}

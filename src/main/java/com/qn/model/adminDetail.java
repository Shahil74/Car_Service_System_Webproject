package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class adminDetail {
	private String adminusername;
	private String adminpassword;
	Connection con=null;
	
	public adminDetail() {
		super();
	}

	public adminDetail(String adminusername, String adminpassword) {
		super();
		this.adminusername = adminusername;
		this.adminpassword = adminpassword;
	}

	@Override
	public String toString() {
		return "adminDetail [adminusername=" + adminusername + ", adminpassword=" + adminpassword
				+ ", getAdminusername()=" + getAdminusername() + ", getAdminpassword()=" + getAdminpassword()
				+ ", adminLogin()=" + adminLogin() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system", "root", "shahil74");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public int adminLogin() {
		try {
			String s="select * from admin where username=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, adminusername);
			ResultSet res =pstmt.executeQuery();
			if(res.next()) {
				if(adminpassword.equals(res.getString(2))) {
				return 1;
			}
				else {
					return -2;//invalid password
				}
			}
			else {
				return -1;//in valid username
			}
		}
		catch(Exception e) {
			
		}
		return 0;
		
	}

}

package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CarDetails {
	private String username;
	private String car_model;
	private String car_type;
	private String car_registration_no;
	private String service_requested;
	private String service_status;
	Connection con=null;
	
	public CarDetails(String username, String car_model, String car_type, String car_registration_no,
			String service_requested, String service_status, Connection con) {
		super();
		this.username = username;
		this.car_model = car_model;
		this.car_type = car_type;
		this.car_registration_no = car_registration_no;
		this.service_requested = service_requested;
		this.service_status = service_status;
		this.con = con;
	}
	@Override
	public String toString() {
		return "CarDetails [username=" + username + ", car_model=" + car_model + ", car_type=" + car_type
				+ ", car_registration_no=" + car_registration_no + ", service_requested=" + service_requested
				+ ", service_status=" + service_status + ", con=" + con + ", getUsername()=" + getUsername()
				+ ", getCar_model()=" + getCar_model() + ", getCar_type()=" + getCar_type()
				+ ", getCar_registration_no()=" + getCar_registration_no() + ", getService_requested()="
				+ getService_requested() + ", getService_status()=" + getService_status() + ", getCon()=" + getCon()
				+ ", carDetails()=" + carDetails() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCar_model() {
		return car_model;
	}
	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_registration_no() {
		return car_registration_no;
	}
	public void setCar_registration_no(String car_registration_no) {
		this.car_registration_no = car_registration_no;
	}
	public String getService_requested() {
		return service_requested;
	}
	public void setService_requested(String service_requested) {
		this.service_requested = service_requested;
	}
	public String getService_status() {
		return service_status;
	}
	public void setService_status(String service_status) {
		this.service_status = service_status;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public CarDetails() {
		super();
	}
	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system", "root", "shahil74");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int carDetails() {
		try {
		String s="insert into car values(?,?,?,?,?,?)";
		PreparedStatement pstmt =con.prepareStatement(s);
		pstmt.setString(1, username);
		pstmt.setString(2, car_model);
		pstmt.setString(3, car_type);
		pstmt.setString(4, car_registration_no);
		pstmt.setString(5, "NA");
		pstmt.setString(6, "NA");
		int rows=pstmt.executeUpdate();
		return rows;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return 0;}
	public int serviceRequest() {
		try {
			String s="update car set service_requested=?,service_status=? where username=? and car_registration_no=?";
			PreparedStatement pstmt =con.prepareStatement(s);
			pstmt.setString(1, service_requested);
			pstmt.setString(2, "Pending");
			pstmt.setString(3, username);
			pstmt.setString(4, car_registration_no);
			int rows=pstmt.executeUpdate();
			return rows;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int serviceStatus() {
		try {
			String s="select * from car where car_registration_no=? and username=?";
			PreparedStatement pstmt =con.prepareStatement(s);
			pstmt.setString(1, car_registration_no);
			pstmt.setString(2, username);
			ResultSet res =pstmt.executeQuery();
			if(res.next()) {
				service_status=res.getString(6);
				return 1;
			}else {
				return -1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

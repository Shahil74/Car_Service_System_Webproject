<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String username=(String)session.getAttribute("username");

%>
<h1 style="color:pink;text-align:center;"><%= username %> Logged In SuccessFully......! </h1><br><br>
<a href="carDetails.html">Enter Your Car Details</a><br>
<a href="">Edit Car Details</a><br>
<a href="serviceRequest.html">Request For a Service</a><br>
<a href="serviceStatus.html">Check Service Status</a><br>
</body>
</html>
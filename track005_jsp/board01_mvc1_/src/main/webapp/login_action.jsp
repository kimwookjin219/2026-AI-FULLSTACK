<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
try{
	request.setCharacterEncoding("UTF-8");
	String bemail = request.getParameter("bemail");
	String bpass = request.getParameter("bpass");
	Connection conn = null; PreparedStatement pstmt = null;
	ResultSet rset = null;
	String url = "jdbc:mysql://localhost:3306/mbasic",id="root",pass="1234";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,id,pass);
	
}catch(Exception e){ e.printStackTrace(); }
%>
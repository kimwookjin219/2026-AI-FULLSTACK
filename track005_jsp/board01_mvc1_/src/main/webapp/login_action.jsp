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
	String sql = "select * from users where email=? and bpass=?";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,id,pass);
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, bemail);
	pstmt.setString(2, bpass);
	
	rset = pstmt.executeQuery();
	
	if(rset.next()){
		out.println("<script> alert('로그인 완료!'); location.href='list.jsp'; </script>");
	}
	else{ 
		out.println("<script> alert('관리자에게 문의해주세요'); location.href='login.jsp'; </script>");
	}
	if(rset!=null){ rset.close(); }
	if(pstmt!=null){ pstmt.close(); }
	if(conn!=null){ conn.close(); }	
}catch(Exception e){ e.printStackTrace(); }
%>
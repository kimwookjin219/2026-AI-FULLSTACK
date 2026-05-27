<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
//1. 데이터 넘겨받기
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email") , bpass = request.getParameter("bpass");

try{
	Connection conn = null; ResultSet rset = null;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	
	//2. sql 구문처리
	PreparedStatement pstmt = conn.prepareStatement("select * from users where email=? and bpass=?");
	
	pstmt.setString(1,email);
	pstmt.setString(2, bpass);
	
	rset = pstmt.executeQuery();
	
	if(rset.next()){
		//email = rset.getString("email");  bpass = rset.getString("bpass");
		
		// 로그인 성공시 - session 설정 (session.setAttribute) / jsp016_login.jsp 페이지로 넘어가기
		session.setAttribute("email", email);
		out.println("<script> alert('로그인성공!'); location.href='jsp016_login.jsp'; </script>");
	}
	
	
	if(rset!=null){ rset.close(); }
	if(pstmt!=null){ pstmt.close(); }
	if(conn!=null){ conn.close(); }
}catch(Exception e){ e.printStackTrace(); }
%>

<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("UTF-8");

String bpass = request.getParameter("bpass");
int bno = Integer.parseInt(request.getParameter("bno"));

Connection conn = null; PreparedStatement pstmt = null;

String url = "jdbc:mysql://localhost:3306/mbasic";
String id = "root", pass = "1234";

String sql = "delete from mvcboard1 where bno=? and bpass=?";
// select = executeQuery / insert,delete,update = executeUpdate
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,id,pass);
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, bno);
	pstmt.setString(2, bpass);
	
	int result = pstmt.executeUpdate();
	
	if(result>0){
		out.println("<script> alert('삭제완료!'); location.href='list.jsp'; </script>");
	}
	else{ 
		out.println("<script> alert('비밀번호 확인해주세요'); history.go(-1); </script>");
	}
	
	if(pstmt!=null){pstmt.close();}
	if(conn!=null){conn.close();}
}catch(Exception e){ e.printStackTrace(); }
%>
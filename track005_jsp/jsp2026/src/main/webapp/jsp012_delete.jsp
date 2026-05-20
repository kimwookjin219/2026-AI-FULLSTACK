<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
//jsp012_delete.jsp
	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	//2. request.getParameter() 이용해서 데이터받기
	String oname = request.getParameter("oname");
	int ono = Integer.parseInt(request.getParameter("ono"));
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
		PreparedStatement pstmt = conn.prepareStatement("delete from milk_order where ono = ? and oname = ?");
		
		pstmt.setInt(1, ono);
		pstmt.setString(2, oname);
		
		int result = pstmt.executeUpdate();
		
		if(result>0){
			out.println("<script> alert('주문삭제 성공'); location.href='jsp012_milks.jsp'; </script>");
		}
		else{ 
			out.println("<script> alert('관리자에게 문의하세요'); location.href='jsp012_milks.jsp'; </script>");
		}
		
		if(pstmt!=null){ pstmt.close(); }
		if(conn!=null){ conn.close(); }
	
	}catch(Exception e){ e.printStackTrace(); }
%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
//1. 데이터 넘겨받기
//2. sql 처리
// select : executeQuery / insert,update,delete : executeUpdate
try{
	request.setCharacterEncoding("UTF-8");
	
	 String bname = request.getParameter("bname");
	 String bpass = request.getParameter("bpass");
	 String btitle = request.getParameter("btitle");
	 String bcontent = request.getParameter("bcontent");
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	PreparedStatement pstmt = conn.prepareStatement("insert into mvcboard1 (bname,bpass,btitle,bcontent,bip) values (?,?,?,?,?)");
	
	pstmt.setString(1, bname);
	pstmt.setString(2, bpass);
	pstmt.setString(3, btitle);
	pstmt.setString(4, bcontent);
	pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
	
	int result = pstmt.executeUpdate();
	
	if(result>0){ out.println("<script> alert('글쓰기 성공'); location.href='list.jsp'; </script>");  }
	else { out.println("<script> alert('관리자에게 문의바랍니다.'); location.href='list.jsp'; </script>"); }
	
	if(pstmt!=null){ pstmt.close(); }
	if(conn!=null){ conn.close(); }
}catch(Exception e){ e.printStackTrace(); }
%>
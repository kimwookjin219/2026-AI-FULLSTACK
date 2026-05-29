<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
String bpass= request.getParameter("bpass");
String btitle= request.getParameter("btitle");
String bcontent= request.getParameter("bcontent");

String sql = "update mvcboard1 set btitle=? , bcontent=? where bno=? and bpass=?";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1,btitle);
	pstmt.setString(2,bcontent);
	pstmt.setInt(3,bno);
	pstmt.setString(4,bpass);
	
	if(pstmt.executeUpdate() > 0){ 
		out.println("<script> alert('수정완료!'); location.href='detail.jsp?bno="+bno+"'; </script>"); 
		}
	else {
		out.println("<script> alert('비밀번호를 확인해주세요!'); history.go(-1); </script>");
	}
	
	if(pstmt!= null){pstmt.close();}
	if(conn!= null){conn.close();}	
	
}catch(Exception e){ e.printStackTrace(); }
%>
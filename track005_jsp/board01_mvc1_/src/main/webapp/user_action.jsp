<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%

try{
	request.setCharacterEncoding("UTF-8");
	String nickname = request.getParameter("bnickname");
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("bemail");
	String mobile = request.getParameter("bmobile");
	Connection conn = null; PreparedStatement pstmt = null;
	String url = "jdbc:mysql://localhost:3306/mbasic" , id="root" , pass="1234";
	String sql = "insert into users(nickname,bpass,email,mobile,bip) values (?,?,?,?,?)";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url,id,pass);
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, nickname);
	pstmt.setString(2, bpass);
	pstmt.setString(3, email);
	pstmt.setString(4, mobile);
	pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
	
	int result = pstmt.executeUpdate();
	
	if(result>0){
		out.println("<script> alert('회원가입 완료!'); location.href='user.jsp'; </script>");
	}
	else{
		out.println("<script> alert('관리자에게 문의바랍니다.'); location.href='user.jsp'; </script>");
	}
	if(pstmt!=null){ pstmt.close(); }
	if(conn!=null){ conn.close(); }	
}catch(Exception e){ e.printStackTrace(); }
%>
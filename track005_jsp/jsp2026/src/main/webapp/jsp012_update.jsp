<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<% 
//jsp012_update.jsp

	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	//2. request.getParameter() 이용해서 데이터받기
	int ono = Integer.parseInt(request.getParameter("ono"));
	String oname = request.getParameter("oname");
	int onum = Integer.parseInt(request.getParameter("onum"));
	//3. insert 구문처리
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
		PreparedStatement pstmt = conn.prepareStatement("update milk_order set oname= ?, onum = ? where ono = ?");
		
		pstmt.setString(1, oname);
		pstmt.setInt(2, onum);
		pstmt.setInt(3, ono);
		
		int result = pstmt.executeUpdate();
		//4. jsp012_milks.jsp로 돌아가기
		if(result>0){
			out.println("<script> alert('주문수정 성공!'); location.href='jsp012_milks.jsp'; </script>");
		}
		else{
			out.println("<script> alert('관리자에게 문의해주세요'); location.href='jsp012_milks,jsp'; </script>");
		}
		if(pstmt!=null){ pstmt.close(); }
		if(conn!=null){ conn.close(); }
		
	}catch(Exception e){ e.printStackTrace(); }
	

%>
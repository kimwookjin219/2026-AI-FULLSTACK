<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
String nickname = "" , email = "" , mobile = "" , udate = "" , bip = "";

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	PreparedStatement pstmt = conn.prepareStatement("select * from users where bno=?");
	
	pstmt.setInt(1,bno);
	
	ResultSet rset = pstmt.executeQuery();
	
	if(rset.next()){
		nickname = rset.getString("nickname"); email = rset.getString("email");
		mobile = rset.getString("mobile"); udate = rset.getString("udate");
		bip = rset.getString("bip");
	}
	
}catch(Exception e){ e.printStackTrace(); }

%>


<body>
   <div class="container card my-5">
      <h3 class="card-header">마이페이지</h3>
      
      <table class="table table-striped">
		<tbody>
		   <tr><th scope="row">닉네임</th> <td><%=nickname%></td></tr>
		   <tr><th scope="row">이메일</th> <td><%=email%></td></tr>
		   <tr><th scope="row">휴대폰</th> <td><%=mobile%></td></tr>
		   <tr><th scope="row">가입일</th> <td><%=udate%></td></tr> 
		   <tr><th scope="row">가입IP</th> <td><%=bip%></td></tr>         
		</tbody>
	  </table>
	  
   </div>
<%@include file="./inc/footer.jsp"%>
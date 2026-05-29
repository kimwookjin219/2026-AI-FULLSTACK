<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
String bname="" , btitle="", bcontent=""; int bhit=0;
try{
	
	String sql1 = "update mvcboard1 set bhit=bhit+1 where bno=?";
	String sql2 = "select * from mvcboard1 where bno=?";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	
	PreparedStatement pstmt = conn.prepareStatement(sql1);	
	pstmt.setInt(1,bno);
	if(pstmt.executeUpdate() > 0){ pstmt.close(); }
	
    pstmt = conn.prepareStatement(sql2);	
	pstmt.setInt(1,bno);	
	ResultSet rset = pstmt.executeQuery();
	
	if(rset.next()){
		bname=rset.getString("bname");    btitle = rset.getString("btitle");
		bcontent = rset.getString("bcontent"); bhit = rset.getInt("bhit");
	}
	
	if(rset!= null){rset.close();}
	if(pstmt!= null){pstmt.close();}
	if(conn!= null){conn.close();}
}catch(Exception e){ e.printStackTrace(); }

%>

   <div class="container card my-5">
      <h3 class="card-header">QNA 상세보기</h3>
      <form action="#" method="post">
      	<div class="my-3">
      		<label for="bname" class="form-label">이름</label>
      		<input type="text" class="form-control" value="<%=bname%>" id="bname" name="bname" readonly>
      	</div>
      	<div class="my-3">
      		<label for="bpass" class="form-label">비밀번호</label>
      		<input type="password" class="form-control"  id="bpass" name="bpass">
      	</div>
      	<div class="my-3">
      		<label for="btitle" class="form-label">제목</label>
      		<input type="text" class="form-control" value="<%=btitle%>" id="btitle" name="btitle" readonly> 
      	</div>
      	<div class="my-3">
      		<label for="bcontent" class="form-label">내용</label>
      		<textarea class="form-control" id="bcontent"  name="bcontent" readonly><%=bcontent%></textarea>
      	</div>
      	<div class="my-3 text-end">
			<a href="edit.jsp?bno=<%=bno %>" class="btn btn-primary" title="수정">수정</a>
			<a href="delete.jsp?bno=<%=bno %>" class="btn btn-outline-primary" title="삭제">삭제</a>
			<a href="list.jsp" class="btn btn-primary" title="목록보기">목록보기</a>
		</div>
      </form>
   </div>
<%@include file="./inc/footer.jsp" %>
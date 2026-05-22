<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
<% 
request.setCharacterEncoding("UTF-8");
int bno = Integer.parseInt(request.getParameter("bno"));
String btitle="", bcontent="" , bpass="" ,bname="";

try{
	String sql1 = "select * from mvcboard1 where bno=?";
	String sql2 = "update mvcboard1 set btitle=? , bcontent=? where bno=? bpass=?";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");
	
	PreparedStatement pstmt = conn.prepareStatement(sql1);
	pstmt.setInt(1,bno);
	ResultSet rset = pstmt.executeQuery();
	if(rset.next()){
	    bname = rset.getString("bname");		 
	}
	
	pstmt = conn.prepareStatement(sql2);	
	pstmt.setString(1,btitle);
	pstmt.setString(2,bcontent);
	pstmt.setInt(3,bno);
	pstmt.setString(4,bpass);
	
	if(pstmt.executeUpdate() > 0){ pstmt.close(); }
	
	if(rset!= null){rset.close();}
	if(pstmt!= null){pstmt.close();}
	if(conn!= null){conn.close();}	
}catch(Exception e){ e.printStackTrace(); }
%>

   <div class="container card my-5">
      <h3 class="card-header">QNA 상세보기</h3>
      <form action="#" method="post" onsubmit="return checkForm()">
		<div class="my-3">
			<label for="bname" class="form-label">이름</label>
			<input type="text" class="form-control" value="<%=bname %>" id="bname" name="bname" readonly>
		</div>
		<div class="my-3">
			<label for="bpass" class="form-label">비밀번호</label>
			<input type="password" class="form-control" id="bpass" name="bpass">
		</div>
		<div class="my-3">
			<label for="btitle" class="form-label">제목</label>
			<input type="text" class="form-control" id="btitle" name="btitle">
		</div>
		<div class="my-3">
			<label for="bcontent" class="form-label">내용</label>
			<textarea class="form-control" id="bcontent" name="bcontent"></textarea>
		</div>
		<div class="my-3 text-end">
			<a href="list.jsp" class="btn btn-primary" title="글수정">수정</a>
			<a href="list.jsp" class="btn btn-primary" title="수정취소">취소</a>
			<a href="list.jsp" class="btn btn-primary" title="목록보기">목록보기</a>
		</div>        
      </form>
      <script>
      function checkForm(){
    	  let name = document.getElementById("bname");
    	  let pass = document.getElementById("bpass");
    	  let title = document.getElementById("btitle");
    	  let content = document.getElementById("bcontent");
    	  
    	  if(name.value.trim()==""){
    		  alert("이름을 입력해주세요");
    		  name.focus();
    		  return false;
    	  }
    	  if(pass.value.trim()==""){
    		  alert("비밀번호를 입력해주세요");
    		  pass.focus();
    		  return false;
    	  }
    	  if(title.value.trim()==""){
    		  alert("제목을 입력하시오");
    		  title.focus();
    		  return false;
    	  }
    	  if(content.value.trim()==""){
    		  alert("내용을 입력하시오");
    		  content.focus();
    		  return false;
    	  }
    	  return true;
      }
      </script> 
   </div>
<%@include file="./inc/footer.jsp" %>
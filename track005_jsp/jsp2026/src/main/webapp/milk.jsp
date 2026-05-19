<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!--         header        -->
	<div class="p-5 bg-secondary text-white">
		  <h1>MILK ORDER PROJECT</h1>
		  <p>MVC1 - PreparedStatement Ex</p>
	</div>
	<!--         header        -->
	
	<!--         메뉴판 테이블       -->
   <div class="container card my-5 bg-secondary text text-white">
   	 
      <h2 class="card-header">Milk Menu</h2>
       <table class="table table-striped table-bordered table-hover">
       	<caption>우유메뉴</caption>
       <thead>
	       	<tr>
	       		<th scope="col">NO</th>
	       		<th scope="col">NAME</th>
	       		<th scope="col">PRICE</th>
	       	</tr>
       	</thead>
       	<tbody>
 		<%
	       try{
	       	//1. 드라이브 연동
	       	Class.forName("com.mysql.cj.jdbc.Driver");
	       	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	       	//2. JDBC 연동
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic","root","1234");	       	
	       	//3. PreparedStatement pstmt 이용해서 milk 테이블의 데이터 가져오기
	       	// 가격이 낮은 순으로
	       	pstmt = conn.prepareStatement("select * from milk order by mprice asc"); 
			
	       	rset = pstmt.executeQuery(); // 표
	       	while(rset.next()){
	       		out.println("<tr><td>" + rset.getInt("mno") + "</td><td>" + rset.getString("mname") + "</td><td>" + rset.getInt("mprice") + "</td></tr>");
	       	}
	       	//4. JDBC 끊기
	       	if(rset!=null){ rset.close(); }
	       	if(pstmt!=null){ pstmt.close(); }
	       	if(conn!=null){ conn.close(); }
	       }catch(Exception e){ e.printStackTrace(); }
 		/*
 		alter table milk modify mnum int null;
 		alter table milk modify mtotal int null;
 		
 		insert into milk (mno,mname,mprice) values (1,'white',1500);
 		*/
       %>
       	</tbody>
       </table>
	  
   </div>
   <!--         메뉴판 테이블       -->
   
   <!--         주문 현황표       -->
   <div class="container card my-5 bg-secondary text text-white">
  	  
      <h2 class="card-header">MILK ORDER</h2>
      
       <table class="table table-striped table-bordered table-hover">
       <caption>우유메뉴</caption>
       <thead>
	       	<tr>
	       		<th scope="col">NO</th>
	       		<th scope="col">NAME</th>
	       		<th scope="col">NUM</th>
	       		<th scope="col">주문날짜</th>
	       	</tr>
       	</thead>
       	<tbody>
	       	<tr>
	       		<td></td>
	       		<td></td>
	       		<td></td>
	       		<td></td>
	       	</tr>
       	</tbody>
       </table>
   </div>
   <!--         주문 현황표       -->
   
   <!--         주문 삽입,수정,삭제       -->
   <div class="container card my-5 bg-secondary text text-white">
   	  
      <h2 class="card-header">MILK 주문하러가기</h2>
       <div class="container card my-5 text text-white">
      		<h3 class="card-header bg-dark">주문하기</h3>
      		<form action="" method="get" onsubmit="return check()">
      			<div class="my-3">
      				<label class="form-label text text-dark">주문할 우유이름</label>
      				<input type="text" class="form-control" id="milk" name="milk" placeholder="주문할 우유이름을 적어주세요!">
      			</div>
      			<div class="my-3">
      				<label class="form-label text text-dark">주문할 우유갯수</label>
      				<input type="number" class="form-control" id="milknum" name="milknum" placeholder="우유 갯수를 적어주세요!">
      			</div>
      			<button type="submit" class="btn btn-secondary my-3 d-block">주문하기</button>
      		</form>   		
   		</div>
   		
   		<div class="container card text text-white">
   			<h3 class="card-header bg-dark">주문수정</h3>
   		</div>
   		
   		<div class="container card text text-white">
   			<h3 class="card-header bg-dark">주문삭제</h3>
   		</div>
   		
   	</div>
   <!--         주문 삽입,수정,삭제       -->
   
</body>
</html>
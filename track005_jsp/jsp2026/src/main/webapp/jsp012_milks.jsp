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
	   <div class="card-body">
	   <h2 class="card-header">MILK 찾기</h2>
	  		<form action="jsp012_search.jsp" method="get" onsubmit="return msearch()">
	  			<div class="my-3">
	  				<label for="sono" class="form-label">우유번호</label>
	  				<input type="number" class="form-control" id="sono" name="ono" placeholder="번호를 입력해주세요!">
	  			</div>
	  			<button type="submit" class="btn btn-dark my-3 d-block">milk검색</button>
	  		</form>
	  		<script>
	  			function msearch(){
	  				let sono = document.getElementById("sono");
	  				
	  				if(sono.value.trim()==""){
	  					alert("번호를 입력해주세요");
	  					sono.focus();
	  					return false;
	  				}
	  				return true;
	  			}
	  		</script>
	  	</div>	
   </div>
   <!--         메뉴판 테이블       -->
   
   <!--         주문 현황표       -->
   <div class="container card my-5 bg-secondary text text-white">
  	  
      <h2 class="card-header">MILK ORDER</h2>
      
       <table class="table table-striped table-bordered table-hover">
       <caption>주문현황표</caption>
       <thead>
	       	<tr>
	       		<th scope="col">NO</th>
	       		<th scope="col">NAME</th>
	       		<th scope="col">NUM</th>
	       		<th scope="col">DATE</th>
	       	</tr>
       	</thead>
       	<tbody>
			<%
			try{
				//1. 드라이버 연동 Class.forName()
			 Class.forName("com.mysql.cj.jdbc.Driver");
				//2. jdbc 연동 DriverManager.getConnection()
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
				//3. pstmt 사용 sql - 처리 pstmt.executeQuery()
			 PreparedStatement pstmt = conn.prepareStatement("select * from milk_order order by ono desc");
				
			 ResultSet rset = pstmt.executeQuery();	// 표(select) / executeUpdate(insert,update,delete)
			 
			 while(rset.next()){ // 줄
				 out.println("<tr><td>"+rset.getInt("ono") 
				            +"</td><td>"+ rset.getString("oname") 
				            +"</td><td>"+rset.getInt("onum") 
				            +"</td><td>"+rset.getDate("odate") +"</td></tr>"); } //칸
			 	//4. jdbc close()
			 if(rset!=null){rset.close();}
			 if(pstmt!=null){pstmt.close();}
			 if(conn!=null){conn.close();}
			}catch(Exception e){ e.printStackTrace(); } 
			%>
       	</tbody>
       </table>
   </div>
   <!--         주문 현황표       -->
   
   <!--         주문 삽입,수정,삭제       -->
   <div class="container card my-5 bg-secondary text text-white">
   	  <h2 class="card-header bg-secondary text-white my-3"> MILK 주문,수정,삭제</h2>
   	  <div id="accordion">
		  <div class="card">
		    <div class="card-header bg-dark">
		      <a class="btn text text-white" data-bs-toggle="collapse" href="#collapseOne">
		        주문하기
		      </a>
		    </div>
		    <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
		      <div class="card-body">
		      
		        <form action="jsp012_insert.jsp" method="post" onsubmit="return order()">
	      			<div class="my-3">
	      				<label for="oname" class="form-label text text-dark">주문할 우유이름</label>
	      				<input type="text" class="form-control" id="oname" name="oname" placeholder="주문할 우유이름을 적어주세요!">
	      			</div>
	      			<div class="my-3">
	      				<label for="onum" class="form-label text text-dark">주문할 우유갯수</label>
	      				<input type="number" class="form-control" id="onum" name="onum" placeholder="우유 갯수를 적어주세요!">
	      			</div>
      				<button type="submit" class="btn btn-secondary my-3 d-block">주문하기</button>
      			</form>
    
      			 <script>
		      		function order(){
		      			let oname = document.getElementById("oname");
		      			let onum = document.getElementById("onum");
		      			
		      			if(oname.value.trim()==""){ 
		      				alert("우유이름을 입력해주세요");
		      				oname.focus();
		      				return false;
		      				}
		      			if(onum.value.trim()==""){
		      				alert("우유갯수를 입력해주세요");
		      				onum.focus();
		      				return false;
		      			} 
		      			return true;
		      		}
	      		</script> 

		      </div>
		    </div>
		  </div>
		
		  <div class="card">
		    <div class="card-header  bg-dark">
		      <a class="collapsed btn text text-white" data-bs-toggle="collapse" href="#collapseTwo">
		        주문수정
		      </a>
		    </div>
		    <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body">
		        
				<form action="jsp012_update.jsp" method="post" onsubmit="return up()">
				
					<div class="my-3">
	      				<label for="uono" class="form-label text text-dark">수정할 주문번호</label>
	      				<input type="text" class="form-control" id="uono" name="ono" placeholder="수정할 주문번호를 적어주세요!">
	      			</div>
				
	      			<div class="my-3">
	      				<label for="uname" class="form-label text text-dark">수정할 우유이름</label>
	      				<input type="text" class="form-control" id="uname" name="oname" placeholder="수정할 우유이름을 적어주세요!">
	      			</div>
	      			<div class="my-3">
	      				<label for="unum" class="form-label text text-dark">수정할 우유갯수</label>
	      				<input type="number" class="form-control" id="unum" name="onum" placeholder="우유 갯수를 적어주세요!">
	      			</div>
      				<button type="submit" class="btn btn-secondary my-3 d-block">수정하기</button>
      			</form>
      			
       			<script>
		      		function up(){
		      			let uono = document.getElementById("uono");
		      			let uname = document.getElementById("uname");
		      			let unum = document.getElementById("unum");
		      			
		      			if(uono.value.trim()==""){ 
		      				alert("주문번호를 입력해주세요");
		      				uono.focus();
		      				return false;
		      				}
		      			
		      			if(uname.value.trim()==""){ 
		      				alert("우유이름을 입력해주세요");
		      				uname.focus();
		      				return false;
		      				}
		      			if(unum.value.trim()==""){
		      				alert("우유갯수를 입력해주세요");
		      				unum.focus();
		      				return false;
		      			} 
		      			return true;
		      		}
	      		</script>   

		      </div>
		    </div>
		  </div>
		
		  <div class="card">
		    <div class="card-header  bg-dark">
		      <a class="collapsed btn text text-white" data-bs-toggle="collapse" href="#collapseThree">
		        주문삭제
		      </a>
		    </div>
		    <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
		      <div class="card-body">
		        
		        <form action="jsp012_delete.jsp" method="post" onsubmit="return del()">
		        	
		        	<div class="my-3">
	      				<label for="ono" class="form-label text text-dark">삭제할 주문번호</label>
	      				<input type="text" class="form-control" id="ono" name="ono" placeholder="삭제할 주문번호를 적어주세요!">
	      			</div>
		        	
	      			<div class="my-3">
	      				<label for="dname" class="form-label text text-dark">삭제할 우유이름</label>
	      				<input type="text" class="form-control" id="dname" name="oname" placeholder="삭제할 우유이름을 적어주세요!">
	      			</div>

      				<button type="submit" class="btn btn-secondary my-3 d-block">삭제하기</button>
      			</form>
      			
       			<script>
		      		function del(){
		      			let ono = document.getElementById("ono");
		      			let dname = document.getElementById("dname");
		      			
		      			if(ono.value.trim()==""){ 
		      				alert("주문번호를 입력해주세요");
		      				ono.focus();
		      				return false;
		      				}
		      			
		      			if(dname.value.trim()==""){ 
		      				alert("우유이름을 입력해주세요");
		      				dname.focus();
		      				return false;
		      				}
		      			return true;
		      		}
	      		</script>   

		      </div>
		    </div>
		  </div>
		
		</div>

   	</div>
   <!--         주문 삽입,수정,삭제       -->
   
</body>
</html>
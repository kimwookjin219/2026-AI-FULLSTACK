<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">001. 내장객체</h3>
      <pre class="alert alert-info">
      1. jsp 페이지가 웹컨테이너에 의해
      2. 고정된 이름의 객체 컨테이너를 자동으로 구현
      3. request(요청) , response(응답) , session(정보저장) , out(출력) 
      </pre>
      
      <h4>002. request</h4>
      <pre class="alert alert-info">
      1. 처리해주는 해결사 : action="jsp013_1.jsp"
      2. 요청방식 : 주소표시창 노출
      3. 보관용기 이름 : query
      =getParameter("name")
      4. 출력내용 : 
      검색어 : 입력한 값
      </pre>
      <form action="jsp013_1.jsp" method="get" onsubmit="return check()">
      	<div class="my-3">
      		<label for="query" class="form-header">검색어</label>
      		<input type="text" class="form-control" id="query" name="query">
      		<button type="submit" class="btn btn-primary mt-3 d-block">검색</button>
      	</div>
      </form>
      
      <br/> <!--    줄바꿈      -->
      <br/>
      <!--          -->
      <!--          -->
      <pre class="alert alert-info">
	      1. 처리해주는 해결사 : action="jsp013_2.jsp"
	      2. 요청방식        : 주소표시창 노출
	      3. 보관용기이름     :  username / checkbox: option1
	      = getParameterValues("name")
	      4. 출력내용 :  
	      검색어 : 입력한값
      </pre>
      
      <form action="jsp013_2.jsp"  method="get"  onsubmit="return checkbox()"  >
	        <div class="mb-3 mt-3">
	          <label for="username" class="form-label">NAME:</label> 
	          <input  type="text" class="form-control" id="username"
	               placeholder="Enter email" name="username">
	         </div><!-- user name -->
	         <div class="form-check">
	           <input class="form-check-input" type="checkbox" 
	                  id="check1" name="option1" value="dog" >
	           <label class="form-check-label" for="check1">DOG</label>
	         </div>
	         <div class="form-check">
	           <input class="form-check-input" type="checkbox" 
	                  id="check2" name="option1" value="cat" >
	           <label class="form-check-label"  for="check2" >CAT</label>
	         </div>   
	         <div class="form-check">
	           <input class="form-check-input" type="checkbox" 
	                  id="check3" name="option1" value="pig"   >
	           <label class="form-check-label"  for="check3">PIG</label>
	         </div>
	         <div class="my-3">
	              <button  type="submit"  class="btn btn-primary" >전송</button>
	         </div>                  
      </form>
      	  
      <hr/>   <!--    문단나눔(선)      -->  
      <h4>003. response</h4>	
      <pre class="alert alert-info">
      1. http 요청에 대한 응답 저장하는 객체
      2. jsp에서 다른페이지로 이동
      	(1) sendRedirect - 브라우저 url을 변경 , request/ response 객체가 유지안됨
      	(2) RequestDispatcher - 위임(요청전달)       
      						    브라우저 url을 변경 X , request/ response 객체가 유지가 됨
      </pre>
      <%
      //ver-1 알림창 처리 안됨
      //out.println("<script> alert('안녕?'); </script>"); // 알림창 X
      //response.sendRedirect("http://www.naver.com");
      %>
      
      <%
      //ver-2 
      //jsp013_3.jsp 
      //request.getRequestDispatcher("jsp012_milks.jsp")이용해서 여기서 처리해주세요
      //response.sendRedirect("jsp013_3.jsp");
      %>
      
      <br/>
      <br/>
      <pre class="alert alert-info">
		jsp013_implicit.jsp (1) →  jsp013_4.jsp  처리 (2)
		 나이 입력받는 폼(form)           
		                 
		19세 미만이라면 -   jsp013_child.jsp
		19세 이상이라면 -  보여주는 주소표시창줄은   jsp013_4.jsp  
		               보이는화면은   jsp013_adult.jsp
      </pre>
      <form action="jsp013_4.jsp" method="get" onsubmit="return check()">
      	<div class="my-3">
      		<label for="userage" class="form-header">나이입력</label>
      		<input type="text" class="form-control" id="userage" name="userage">
      		<button type="submit" class="btn btn-primary mt-3 d-block">성인여부</button>
      	</div>
      </form> 
      
      
      <hr/>
      <h4>004. scope (내장객체 유효범위)</h4> 
      <pre class="alert alert-info">
      1. application (웹애플리케이션이 실행되고 있는 동안 , 서버가 꺼질때까지 유지) 
      		> session (특정 브라우저와 연결된 세선, 브라우저 종료 시 소멸)
      			> request(요청 : 폼, a요청) 
      				> page (해당 jsp 페이지에서만)    
      2. 객체.setAttribute("속성","값")  /  객체.getAttribute("속성")				
      </pre> 
      <%
      application.setAttribute("name","D. application-웹애플리케이션 실행");
      session.setAttribute("name","C. session-브라우저 종료 / 로그인 후 아이디 유지");
      request.setAttribute("name","B. request-a.jsp → b.jsp 요청할때");
      pageContext.setAttribute("name","A. 현재 페이지에서만 유지");
      %>
      
      <table class="table table-striped">
		<caption>SCOPE- 내장객체 유효범위</caption>
		<tbody>
		   <tr><th scope="row">page</th>       <td><%=pageContext.getAttribute("name") %></td></tr>
		   <tr><th scope="row">request</th>    <td><%=request.getAttribute("name") %></td></tr>
		   <tr><th scope="row">session</th>     <td><%=session.getAttribute("name") %></td></tr>
		   <tr><th scope="row">application</th> <td><%=application.getAttribute("name") %></td></tr>         
		</tbody>
	  </table>
	  <p><a href="jsp013_5.jsp" class="btn btn-danger">SCOPE2</a></p>
      
      <hr/>
      <h4>005. error</h4>
      <pre class="alert alert-info">
      error
      1. 4XX : 클라이언트 오류
      		404 (페이지 없음) / 400 (bad quest)
      2. 5XX : 서버 오류
      		500 (내부서버 오류) / 502 (서버 과부하)
      
      * 해결방안
      1. error 페이지 만들기
      2. [src] - [main] - [webapp] - [WEB-INF] - web.xml 에러처리 설정		
      </pre>
      
      <h4 class="card-haeder">1. ERROR 404 </h4>
      <p><a href="no.jsp" class="btn btn-danger">NO PAGE</a></p>
      
      <h4 class="card-haeder">2. ERROR 500 </h4>
      <%-- <%   int i=40/0;  %> --%>
      
      
   </div>
</body>
</html>
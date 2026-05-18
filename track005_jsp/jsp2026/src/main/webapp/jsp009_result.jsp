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
   <h3>결과 확인</h3>
   
   <% 
  	   int kor = Integer.parseInt(request.getParameter("kor")); 
	   int eng = Integer.parseInt(request.getParameter("eng"));
	   int math = Integer.parseInt(request.getParameter("math"));
	   int total = kor+eng+math;
	   String avg = String.format("%.2f", total/3.0);
   %>
	<table class="table table-striped table-bordered table-hover">
	   	<tr>
	   		<th scope="col">국어점수</th>
	   		<th scope="col">영어점수</th>
	   		<th scope="col">수학점수</th>
	   		<th scope="col">총점</th>
	   		<th scope="col">평균</th>
	   	</tr>
	    <tr>
	    	<td><%=kor %></td>
	    	<td><%=eng %></td>
	    	<td><%=math %></td>
	    	<td><%=total %></td>
	    	<td><%=avg %></td>
	    </tr>  

      <p><a href="javascript:history.go(-1)" class="btn btn-primary">BACK</a></p>
     </table> 
   </div>
</body>
</html>
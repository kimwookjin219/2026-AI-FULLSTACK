<%@page import="java.sql.*"%>
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
      <h3 class="card-header">Milks</h3>
       <table>
       	<thead>
       		<tr>
       			<th>MNO</th>
       			<th>MNAME</th>
       			<th>MPRICE</th>
       		</tr>
       	</thead>
       	<tbody>
       		<%
       		try{
       			Class.forName("com.mysql.cj.jdbc.Driver");
       			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
       			PreparedStatement pstmt = conn.prepareStatement("select mno,mname,mprice from milk");
		
       			ResultSet rset = pstmt.executeQuery();
       			
       			while(rset.next()){
       				out.print("<tr><td>"+ rset.getInt("mno") +"</td><td>"+ rset.getString("mname") +"</td><td>"+rset.getInt("mprice")+"</td></tr>");
       			}
       			if(rset!=null){ rset.close(); }
       			if(pstmt!=null){ pstmt.close(); }
       			if(conn!=null){ conn.close(); }
       		}catch(Exception e){ e.printStackTrace(); }
       		%>
       	</tbody>
       </table>
        <p><a href="javascript:history.go(-1)" class="btn btn-primary">BACK</a></p>
   </div>
</body>
</html>
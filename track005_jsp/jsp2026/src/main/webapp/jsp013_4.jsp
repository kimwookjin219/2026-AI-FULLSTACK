<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<% 
//1. utf-8
	request.setCharacterEncoding("UTF-8");
//2. userage 넘어오는 데이터 확인 (getParameter)
	int userage = Integer.parseInt(request.getParameter("userage"));
//3. 만약 19세 미만이라면 jsp013_child 파일 넘기기(sendRedirect)
	if(userage<19){ response.sendRedirect("jsp013_child.jsp?userage="+userage); } // 나이 null 값을 받으려면 ?name= value&name2= value2
//4. 아니라면 jsp013_adult 파일 넘기기(경로 안보이게 숨기기 - dispatch 이용)
	else { request.getRequestDispatcher("jsp013_adult.jsp").forward(request, response); } // 나이
%>
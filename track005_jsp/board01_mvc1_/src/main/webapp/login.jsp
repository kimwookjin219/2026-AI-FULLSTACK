<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="./inc/header.jsp" %>

   <div class="container card my-5">
      <h3 class="card-header">로그인</h3>
      <form action="login_action.jsp" method="post" onsubmit="return checkform()">
      	<div class="my-3">
      		<label for="bemail" class="form-label">이메일</label>
      		<input type="email" class="form-control" id="bemail" name="bemail">
      	</div>
      	<div class="my-3">
      		<label for="bpass" class="form-label">비밀번호</label>
      		<input type="password" class="form-control" id="bpass" name="bpass">
      	</div>
      	<div>
      		<button type="submit" class="btn btn-primary" title="로그인">로그인</button>
      		<a href="list.jsp" class="btn btn-primary" title="취소">취소</a>
      	</div>
      </form>
      <script>
      	function checkform(){
      		let bemail = document.getElementById("bemail");
      		let bpass = document.getElementById("bpass");
      		
      		if(bemail.value.trim()==""){
      			alert('이메일을 입력하시오.');
      			bemail.focus();
      			return false;
      		}
      		if(bpass.value.trim()==""){
      			alert('비밀번호를 입력하시오.');
      			bpass.focus();
      			return false;
      		}
      		return true;
      	}
      </script> 
   </div>
<%@ include file="./inc/footer.jsp" %>
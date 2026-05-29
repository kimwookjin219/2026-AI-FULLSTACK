<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="./inc/header.jsp" %>
   <div class="container card my-5">
      <h3 class="card-header">회원가입</h3>
      
      <form action="JoinAction" method="post" onsubmit="return checkform()">
     	<div>
	        <label for="nickname" class="form-label">닉네임</label>
	      	<input type="text" class="form-control" id="nickname" name="nickname">
      	</div>
      	<div>
	        <label for="bpass" class="form-label">비밀번호</label>
	      	<input type="password" class="form-control" id="bpass" name="bpass">
      	</div>
      	<div>
	        <label for="email" class="form-label">이메일</label>
	      	<input type="email" class="form-control" id="email" name="email">
      	</div>
      	<div>
	        <label for="mobile" class="form-label">휴대전화</label>
	      	<input type="text" class="form-control" id="mobile" name="mobile">
      	</div>
      	<div class="text-end my-3">
      		<button type="submit" class="btn btn-primary" title="회원가입">회원가입</button>
      		<button type="reset" class="btn btn-outilne-primary" title="취소">취소</button>
      	</div>
      </form>
      <script>
      	function checkform(){
      		let nickname = document.getElementById("nickname");
      		let bpass = document.getElementById("bpass");
      		let email = document.getElementById("email");
      		let mobile = document.getElementById("mobile");
      		
      		if(nickname.value.trim()==""){
      			alert('닉네임을 입력해주세요');
      			nickname.focus();
      			return false;
      		}
      		if(bpass.value.trim()==""){
      			alert('비밀번호를 입력해주세요');
      			bpass.focus();
      			return false;
      		}
      		if(email.value.trim()==""){
      			alert('이메일을 입력해주세요');
      			email.focus();
      			return false;
      		}
      		if(mobile.value.trim()==""){
      			alert('전화번호를 입력해주세요');
      			mobile.focus();
      			return false;
      		}
      		return true;     		
      	}
      </script> 
   </div>
<%@ include file="./inc/footer.jsp" %>
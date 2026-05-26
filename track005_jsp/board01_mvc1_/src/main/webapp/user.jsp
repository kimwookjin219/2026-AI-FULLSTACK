<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="./inc/header.jsp" %>

   <div class="container card my-5">
      <h3 class="card-header">회원가입</h3>
      <form action="user_action.jsp" method="post" onsubmit="return checkform()">
      	<div class="my-3">
      		<label for="bnickname" class="form-label">닉네임</label>
      		<input type="text" class="form-control" id="bnickname" name="bnickname">
      	</div>
      	<div class="my-3">
      		<label for="bpass" class="form-label">비밀번호</label>
      		<input type="password" class="form-control" id="bpass" name="bpass">
      	</div>
      	<div class="my-3">
      		<label for="bemail" class="form-label">이메일</label>
      		<input type="email" class="form-control" id="bemail" name="bemail">
      	</div>
      	<div class="my-3">
      		<label for="bmobile" class="form-label">휴대폰</label>
      		<input type="text" class="form-control" id="bmobile" name="bmobile">
      	</div>
      	<div class="my-3 text-end">
	      <button type="submit" class="btn btn-primary" title="가입하기">가입하기</button> 
	      <a href="list.jsp" class="btn btn-primary" title="취소">취소</a>
        </div>
      </form>
      
	  <script>
	   	function checkform(){
	   		let bnickname = document.getElementById("bnickname");
	   		let bpass = document.getElementById("bpass");
	   		let bemail = document.getElementById("bemail");
	   		let bmobile = document.getElementById("bmobile");
	   		
	   		if(bnickname.value.trim()==""){
	   			alert('닉네임을 입력해주세요');
	   			bnickname.focus();
	   			return false;
	   		}
	   		if(bpass.value.trim()==""){
	   			alert('비밀번호을 입력해주세요');
	   			bpass.focus();
	   			return false;
	   		}
	   		if(bemail.value.trim()==""){
	   			alert('이메일을 입력해주세요');
	   			bemail.focus();
	   			return false;
	   		}
	   		if(bmobile.value.trim()==""){
	   			alert('전화번호를 입력해주세요');
	   			bmobile.focus();
	   			return false;
	   		}
	   		return true;
	   	}
   </script>			
   
   </div>
   
<%@ include file="./inc/footer.jsp" %>
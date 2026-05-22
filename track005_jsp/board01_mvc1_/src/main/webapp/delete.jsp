<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>
   <div class="container card my-5">
      <h3 class="card-header">QNA 삭제</h3>
      <form action="#" method="post" onsubmit="return checkForm()">
	      <div class="my-3">
	     	 <label for="bpass" class="form-label">비밀번호</label>
	     	 <input type="password" class="form-control" id="bpass" name="bpass">
	     	 <caption> (*)수정,삭제시 필수입니다.</caption>
	      </div>
	      <div class="my-3">
	      	<button type="submit" class="btn btn-primary" title="확인">확인</button>
	      	<button type="reset" class="btn btn-primary" title="취소">취소</button>
	      	<a href="" class="btn btn-primary" title="목록보기">목록보기</a>
	      </div>
      </form> 
      <script>
      function checkForm(){
    	  let pass = document.getElementById("bpass");
    	  
    	  if(pass.value.trim()==""){
    		  alert("비밀번호를 입력해주세요");
    		  pass.focus();
    		  return false;
    	  }
    	  return true;
      }
      </script>
   </div>
<%@include file="./inc/footer.jsp" %>
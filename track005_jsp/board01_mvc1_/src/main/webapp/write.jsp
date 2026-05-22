<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@include file="./inc/header.jsp" %>

   <div class="container card my-5">
      <h3 class="card-header">QNA 등록</h3>
      <form action="write_action.jsp" method="post" onsubmit="return checkForm()">
		<div class="my-3">
			<label for="bname" class="form-label">이름</label>
			<input type="text" class="form-control" id="bname" name="bname">
		</div>
		<div class="my-3">
			<label for="bpass" class="form-label">비밀번호</label>
			<input type="password" class="form-control" id="bpass" name="bpass">
		</div>
		<div class="my-3">
			<label for="btitle" class="form-label">제목</label>
			<input type="text" class="form-control" id="btitle" name="btitle">
		</div>
		<div class="my-3">
			<label for="bcontent" class="form-label">내용</label>
			<textarea class="form-control" id="bcontent" name="bcontent"></textarea>
		</div>
		<div class="my-3 text-end">
			<button type="submit" class="btn btn-primary" title="압력">입력</button>
			<button type="reset" class="btn btn-primary" title="취소">취소</button>
			<a href="list.jsp" class="btn btn-primary" title="목록보기">목록보기</a>
		</div>        
      </form>
      <script>
      function checkForm(){
    	  let name = document.getElementById("bname");
    	  let pass = document.getElementById("bpass");
    	  let title = document.getElementById("btitle");
    	  let content = document.getElementById("bcontent");
    	  
    	  if(name.value.trim()==""){
    		  alert("이름을 입력해주세요");
    		  name.focus();
    		  return false;
    	  }
    	  if(pass.value.trim()==""){
    		  alert("비밀번호를 입력해주세요");
    		  pass.focus();
    		  return false;
    	  }
    	  if(title.value.trim()==""){
    		  alert("제목을 입력하시오");
    		  title.focus();
    		  return false;
    	  }
    	  if(content.value.trim()==""){
    		  alert("내용을 입력하시오");
    		  content.focus();
    		  return false;
    	  }
    	  return true;
      }
      </script> 
   </div>
<%@include file="./inc/footer.jsp" %>
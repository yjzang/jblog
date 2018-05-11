<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<body>
	<div class="center-content">
		
		<!-- 메인해더 -->
		<c:import url= "/WEB-INF/views/includes/header.jsp"></c:import>
		
		
		<form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath }/user/join">
			<input type="hidden" id="name_check" class=check value=false >
			<input type="hidden" id="id_check" class=check value=false >
			<input type="hidden" id="pw_check"  class=check value=false >
			<input type="hidden" id="agree_check"  class=check value=false >
			
			
			<label class="block-label" for="name">이름</label>
			<input type="text" name="username"  id="name" value="" />
			<div id="msg_name"> </div>	
			
			<label class="block-label" for="id">아이디</label>
			<input type="text" name="id"  id="id" value="" />
			<input id="btn-checkid" type="button" value="id 중복체크">
			<p id="checkid-msg" class="form-error">
			&nbsp;
			</p>
			
			<label class="block-label" for="password">패스워드</label>
			<input type="password" id= "password" name="password"  value=""  style="height:15px;"/>
			<div id="msg_pw"> </div>
			
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
				<div id="msg_agree"> </div>
			</fieldset>
			<div id="msg_final"> </div>
			<input type="submit" id="join"  value="가입하기">

		</form>
	</div>

</body>
<script type="text/javascript">
	
	$("#btn-checkid").on("click", function(){
		
		id_check();
		
	});
	
	$("#id").on("change", function(){
		
		id_check();
		
	});
			
	function id_check(){
		
	  var id = $("#id").val();
	  console.log(id);
	  
	  if(id==""||id==null){
		  	
			 $("#checkid-msg").html("아이디를 입력해주세요.");
			 $("#checkid-msg").css("color","red");
			 $("#checkid-msg").css("margin","5px");
			 $("#id_check").val(false);
			 
	  } else{
		  $.ajax({
			  
			  url : "${pageContext.request.contextPath}/user/idcheck",
			  type : "POST",
			  data : {id,id},
			  dataType : "json",
			  success : function(result){
				  console.log(result);
				  if(result){
					  
							 $("#checkid-msg").html("멋진 아이디입니다.");
							 $("#checkid-msg").css("color","green");
							 $("#checkid-msg").css("margin","5px");
							 $("#id_check").val(true);
						  
				
				  } else{ 
					 $("#checkid-msg").html("이미 사용중인 아이디입니다.");
					 $("#checkid-msg").css("color","red");
					 $("#checkid-msg").css("margin","5px");
					 $("#id_check").val(false);
				  }
			 },
			  
			  error : function(XHR, status, error){
		
				 console.error(XHR+status+error);
			  }
		  });
	  }
	  
	}
	
	$("#name").on("blur", function(){
		
		name_check();
		
	});
			
	function name_check(){
	
		  var name_val = $("#name").val();
		  
		  if(name_val==""||name_val==null){
			  
				 $("#msg_name").html("이름을 입력하세요.");
				 $("#msg_name").css("color","red");
				 $("#msg_name").css("margin","5px");
				 $("#name_check").val(false);
				 
		  } else {
			  
			  $("#msg_name").html("");
			  $("#name_check").val(true);
			
		  }
		  
	}
	
	
	$("#password").on("blur",function(){
		pw_check();
	});
		
	function pw_check(){
	

		  var pw_val = $("#password").val();
		  
		  if(pw_val==""||pw_val==null){
			  
			  $("#msg_pw").html("비밀번호를 입력하세요.");
			  $("#msg_pw").css("color","red");
		   	  $("#msg_pw").css("margin","5px");
		   	  $("#pw_check").val(false);
			  	
		  } else {
			  $("#msg_pw").html("");
			  $("#pw_check").val(true);
			
		
		  }
		  
	}  
	
	
	$("fieldset").on("change", "input[type=checkbox]", function() {
			agree_check();
    });
	
	function agree_check(){

		 var check = $("[type='checkbox']").is(":checked");
		  var check_val = $("[type='checkbox']").val();
		  
		 
		  
		  if(!check){
			  
				 $("#msg_agree").html("약관 동의는 필수 사항입니다.");
				 $("#msg_agree").css("color","red");
				 $("#msg_agree").css("margin","5px");
				 $("#agree_check").val(false);
				 
		  } else {
			  
			  $("#msg_agree").html("");	
			  $("#agree_check").val(true);
				  
		  }
		  
	}  
	
	$("#join").on("click",function(){

		
		console.log("-------------");
		console.log($("#name_check").val());
		console.log($("#id_check").val());
		console.log($("#pw_check").val());
		console.log($("#agree_check").val());

		var val1= $("#name_check").val(); 
		var val2= $("#id_check").val(); 
		var val3= $("#pw_check").val(); 
		var val4= $("#agree_check").val();

	
			
		 if(val1=="true"&&val2=="true"&&val3=="true"&&val4=="true"){
			 
			 return true;
			 
		 } else {
			 
			 name_check();
			 id_check();
			 pw_check();
			 agree_check();
			 $("#msg_final").html("<br>입력하신 정보를 다시 확인하세요.").css("color","red").css("margin","5px").css("text-align","center");
			 return false;
			 
		 }  
	});
</script>


</html>
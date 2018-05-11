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

	<div id="container">
		
		<!-- 블로그 해더 -->
		<c:import url= "/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="${pageContext.request.contextPath}/${authVO.id}/admin/basic">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath}/${authVO.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/${authVO.id}/admin/write">글작성</a></li>
				</ul>
				
				<form action="${pageContext.request.contextPath}/${authVO.id}/upload" method="post" enctype="multipart/form-data">
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="blogtitle" id ="blogtitle" value=""></td>
			      		
			      		</tr>
			      		<tr>
			      		 	<td></td>
			      			 <td><span id="msg" style="color:red;"></span></td>
			      			 <td></td>
			      		</tr>
			      		
			      		<tr>
			      			<td class="t">로고이미지</td>
			      				<c:if test="${vo.logofile==null||vo.logofile==''}">
										<td><img id="logo" src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg"></td>
								</c:if>
								
								<c:if test="${vo.logofile!=null&&vo.logofile!=''}">
									<td><img id="logo" src="${pageContext.request.contextPath}/upload/${vo.logofile}"></td>
								</c:if>		
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="file" onchange="loadFile(event);"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t" ></td>
			      			<td class="s"><input type="submit" value="기본설정 변경"></td>
			      		</tr>           		
			      	</table>
			      	 	
				</form>
				
			</div>
		</div>
		

		<!-- 푸터-->
		<c:import url= "/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	</div>
</body>
<script>
  var loadFile = function(event) {
    var logo = document.getElementById('logo');
    logo.src = URL.createObjectURL(event.target.files[0]);
  };
  
  $("[type=submit]").on("click",function check(){
	  
	  if($("#blogtitle").val()==""){
		  
		  	$("#msg").text(" 블로그 제목을 입력하세요");
		    return false;	  
	  }
		
  });
  
  $("#blogtitle").on("blur",function empty_check(){
	 
	  $("#msg").text("");
	  
  });
  
</script>
</html>
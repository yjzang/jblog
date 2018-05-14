<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

</head>
<body>
	<div class="center-content">
		
		<!-- 메인해더 -->
		<c:import url= "/WEB-INF/views/includes/header.jsp"></c:import>
		
		<form class="login-form" method="post" action="${pageContext.request.contextPath}/user/login">
      		<label>아이디</label> 
      		<input type="text" name="id" value="">
      		
      		<label>패스워드</label> 
      		<input type="password" name="password" style="width:240px;height:26px;">
      		<br>
      		<c:if test="${result=='fail'}">
      		<p class="form-error" style="color:red;">
				로그인 실패<br>
				아이디/패스워드를 확인해 주세요
			</p>
			</c:if>
      		<br>
      		<input type="submit" value="로그인">
		</form>
		
	</div>
</body>

</html>
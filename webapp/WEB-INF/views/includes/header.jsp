<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">

	#goMain{text-decoration:none;}
    a:visited {color: #79B30B;}
    
</style>
    	<!-- 메인해더 -->
	 	<a href="${pageContext.request.contextPath}/main">
			<img class="logo" src="${pageContext.request.contextPath}/assets/images/logo.jpg">
		</a>
		<ul class="menu">
		
			<c:if test="${authVO==null}">
				<!-- 로그인 전 메뉴 -->
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/joinform">회원가입</a></li>
			</c:if>
			
			<c:if test="${authVO!=null}">
				<!-- 로그인 후 메뉴 -->
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				<li><a href="${pageContext.request.contextPath}/${authVO.id}">내블로그</a></li> 
			</c:if>
				
 		</ul>

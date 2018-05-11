<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 블로그 해더 -->
		<div id="header">
			<h1><a href="${pageContext.request.contextPath}/${vo.id}"> ${vo.blogtitle}</a></h1>
			<ul>
				<c:if test="${authVO==null}">
					<!-- 로그인 전 메뉴 -->
					<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
				</c:if>
				
				<c:if test="${authVO!=null}">
					<!-- 로그인 후 메뉴 -->
					<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
					<c:if test="${authVO.id==vo.id}">
					<li><a href="${pageContext.request.contextPath}/${authVO.id}/admin/basic">내블로그 관리</a></li>
					</c:if>
				</c:if>	
			</ul>
		</div>
</body>
</html>
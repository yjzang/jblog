<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>
<body>
	<div class="center-content">
		
		<!-- 메인해더 -->
		<c:import url= "/WEB-INF/views/includes/header.jsp"></c:import>
		
		<form class="search-form" action="${pageContext.request.contextPath}/search" method="post">
			<fieldset>
				<input type="text" name="keyword" value="${kwd}"/>
				<input id="submit" type="submit" value="검색" />
			</fieldset>
			<fieldset>
				<input type="radio" name="which" value="blog-title" checked="checked"> <label>블로그 제목</label>
				<input type="radio" name="which" value="blog-user"> <label>블로거</label>
			</fieldset>
		</form>
	</div>
	<div>
			<c:if test="${empty list}">
				<c:if test="${!empty kwd}">
					<h4 style="color:#2041b7;">"찾으시는 검색 결과가 없습니다."</h4>
				</c:if>
			</c:if>
			<c:forEach var="vo" items="${list}">
				<h4><a style="border:solid 2px;padding:1%;color:#2041b7;" href="${pageContext.request.contextPath}/${vo.id}"> 
					${vo.username}의 "${vo.blogtitle}" 로 이동 </a> </h4><br><br><br> 
			</c:forEach>
	
	</div>
</body>


</html>
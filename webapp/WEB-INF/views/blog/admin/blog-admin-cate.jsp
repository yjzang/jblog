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
					<li><a href="${pageContext.request.contextPath}/${authVO.id}/admin/basic">기본설정</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath}/${authVO.id}/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath}/${authVO.id}/admin/write">글작성</a></li>
				</ul>
				
		      	<table class="admin-cat">
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		<tbody id=cateList>
					
					</tbody>
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
		      	<table id="admin-cat-add" >
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input type="text" id="catName" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input type="text" id="catDesc" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input id="btnAddCate" type="button" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	
			</div>
		</div>
		
		<!-- 푸터-->
		<c:import url= "/WEB-INF/views/includes/blog-footer.jsp"></c:import>

	</div>
</body>

<script type="text/javascript">


$(document).ready(function(){
	
	fetchList();
	
});


function fetchList(){

	$.ajax({
	  
	  url : "${pageContext.request.contextPath}/${authVO.id}/admin/category/getList",
	  type : "POST",
	  dataType : "json",
	
	  success : function(list){
		  
		  $.each(list, function(idx, val) {
			  
				console.log(idx + " " + val.no); 
				render(val,"down");
					  
		  });
		  
	  
	  },
	  
	  error : function(XHR, status, error){

		 console.error(XHR+status+error);
	  }
	  
  });
  
}



$("#btnAddCate").on("click",function(){
 	
	var cateName = $("#catName").val();
	var desc = $("#catDesc").val();
	console.log("버튼 작동함"+cateName + desc
			);
	$.ajax({
		  
		  url : "${pageContext.request.contextPath}/${authVO.id}/admin/category/add",
		  type : "POST",
		  data : {cateName:cateName, desc:desc},
		  dataType : "json",	
		
		  success : function(vo){
			  
				 render(vo,"up");
				 $("[name=catName]").val("");	  
				 $("[name=catDesc]").val("");	  
				
		
		  },
		  
		  error : function(XHR, status, error){

			 console.error(XHR+status+error);
		  }
		  
	  });
	
 		
 		
 	});
 	
 	
$("tbody").on("click","#img_del",function(){
	
	console.log($(this));
	var cateNo = $(this).data("no");
	console.log(cateNo);
	

	$.ajax({
		  
		  url : "${pageContext.request.contextPath}/${authVO.id}/admin/category/delete",
		  type : "POST",
		  data : {cateNo: cateNo},
		  dataType : "json",
		
		  success : function(result){
			  
			 if(result=="true"){
			  
				 remove(cateNo);
				 
			 } else{
				 
				 alert("삭제할 수 없습니다.");
			 }
		  
		  },
		  
		  error : function(XHR, status, error){
			  
			 
			 console.error(XHR+status+error);
		  }
		  
	  });
	
	
});
 	
 	

function render(vo,updown){
	
	  str= " ";
	  str+= "	<tr id='tr_"+vo.cateNo+"'>";
	  str+= "	<td>"+vo.cateNo+"</td>";
	  str+= "	<td>"+vo.cateName+"</td>";
	  str+= "	<td>"+vo.postCount+"</td>";
	  str+= "	<td>"+vo.desc+"</td>";
	  str+= "	<td><img id='img_del' data-no='"+vo.cateNo+"' src='${pageContext.request.contextPath}/assets/images/delete.jpg' style='cursor:pointer;'></td>";
	  str+= "	</tr>";
	  str+= "	";
	  
	  if(updown=="up"){
		  
		  $("#cateList").prepend(str);
		  
	  } else{
		  
		  $("#cateList").append(str);
	  }
		  
}
 	
function remove(no){
	
	  $("#tr_"+no).remove();
	  
}
</script>


</html>
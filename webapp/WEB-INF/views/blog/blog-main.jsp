<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>
<style type="text/css">

	.relative2 {
 		  position: relative;
 		  top: -20px;
 		  left: 20px;
 		  width: 500px;
 		}

</style>

<body>

	<div id="container">
		<!-- 블로그 해더 -->
		<c:import url= "/WEB-INF/views/includes/blog-header.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content" >
				<div class="blog-content" style="padding:20px;">
				
				</div>
				<br><br><br>
				<div>
					 <input type="hidden" id="postNo_hdn">
					 <table id="cmt_tbl" style="border: 1px #538aef solid; width:86%; margin:10px; ">
		                <tr >
		                	
		                    <td align="center"
		                        style="border: 1px #538aef solid; width:10%; padding:5px; "><strong style="color:#484848;">${authVO.username}</strong></td>
		                    <td style="border: 1px #538aef solid; width:100%; padding:5px;">
		                    
		                    	<input type="text" name="cmtContent" id="cmtContent"
		                    	                   value="" placeholder="댓글 내용을 입력하세요."  style="width:100%; border:none; ">
		                    </td>
		                    <td colspan="2" align="center" style="border: 1px #538aef solid; width:10%; padding:5px;">
		                    	<input type="button" id="btn_cmt" style="border: solid 1px grey;border-radius: 5px; width:60px; cursor:pointer ; background-color: #b7d0ff; outline:none;color:#484848;" value="저장">
		                    </td>
		                    
		                </tr>
		                 
		                 <tr align="center" style ="border: 1px #538aef solid;">
		                    <td style=" width:10%; padding:5px;">이 름</td>
		                    <td style=" width:65%; padding:5px;">
		                        <pre style="font-size: 13px">내   용</pre>
		                    </td>
		                    <td  style=" width:20%; padding:5px;">날 짜</td>
		                    <td  style=" width:5%; padding:5px;"><img src="${pageContext.request.contextPath }/assets/images/delete.jpg"></td>
		                </tr>
		                  <tr align="center" style ="border: 1px #538aef solid;">
		                    <td style=" width:10%; padding:5px;">이 름</td>
		                    <td style=" width:65%; padding:5px;">
		                        <pre style="font-size: 13px">내   용</pre>
		                    </td>
		                    <td  style=" width:20%; padding:5px;">날 짜</td>
		                    <td  style=" width:5%; padding:5px;"><img src="${pageContext.request.contextPath }/assets/images/delete.jpg"></td>
		                </tr>
		                  <tr align="center" style ="border: 1px #538aef solid;">
		                    <td style=" width:10%; padding:5px;">이 름</td>
		                    <td style=" width:65%; padding:5px;">
		                        <pre style="font-size: 13px">내   용</pre>
		                    </td>
		                    <td  style=" width:20%; padding:5px;">날 짜</td>
		                    <td  style=" width:5%; padding:5px;"><img src="${pageContext.request.contextPath }/assets/images/delete.jpg"></td>
		                </tr>
		                
		            </table>
		
		           
		               
		            
		            <br>
					<ul class="blog-list">
						<li><span id="cateTitle"></span></li>
					</ul>
           		 </div>
				
				
				
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				
				<c:if test="${vo.logofile==null||vo.logofile==''}">
				<img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
				</c:if>
				
				
				<c:if test="${vo.logofile!=null&&vo.logofile!=''}">
				<img src="${pageContext.request.contextPath}/upload/${vo.logofile}">
				</c:if>			
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach var="cateVO" items="${cateList}">
				<li><a style="cursor:pointer;" class="cateName" data-cateno="${cateVO.cateNo}">${cateVO.cateName}(${cateVO.postCount})</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<!-- 푸터-->
			<c:import url= "/WEB-INF/views/includes/blog-footer.jsp"></c:import>

		
	</div>
	
</body>
<script type="text/javascript">

	$(document).ready(function(){
		var cateNo =  ${cateList[0].cateNo};
		fetchPostList(cateNo);
		fetchCmtList(postNo);
		
	});
		

	
 	$("ul").on("click",".cateName",function(){
 		
		
			var cateNo=$(this).data("cateno");
			console.log("카테넘버"+cateNo+"디스"+$(this));
		
 			fetchPostList(cateNo);
 		
 	});
 			
 	function fetchPostList(cateNo){
 			
			
			console.log("카테넘버"+cateNo);
			$(".cateName").css("font-weight", "" );
			$("[data-cateno="+cateNo+"]").css("font-weight", "bold" );
			$(".blog-list").empty();
	
	
			$.ajax({
				  
				  url : "${pageContext.request.contextPath}/${vo.id}/getPostList",
				  type : "POST",
				  data : {cateNo: cateNo},
				  dataType : "json",
				
				  success : function(list){
					  
					  	if(list.length==0){
					  		console.log("리스트 length가 0이다");
							 $(".blog-content").html(
									"<h4>등록된 글이 없습니다.</h4><p></p>"
									) ;
							 $(".blog-list").attr("style","");
							/*  $("#cmt_tbl").empty();
							 $("#cmt_tbl").attr("style",""); */
					  	 } else{
					  		 
							
							 $.each(list, function(idx, val) {
								console.log(idx + " " + val.postNo);
								render_postList(val,"down");
							
								  });
							 fetchPost(list[0].postNo);
								
							 $(".blog-list").attr("style","border:1.5px dashed #538aef;width:80%;"
							  						+"padding:20px; position:relative; bottom: 20px;") ;
							  
							  console.log("카테 클릭을 했고 포스트목록 중 1번 객체에 대한정보:" + list[0]);
					  	 }
					 
					  
				 }, 
				 
				  error : function(XHR, status, error){
					  
						console.error(XHR+status+error);
				  }
				  
		 	 });
 	 		 }
 		
 			
 			
 
	

 	$("ul").on("click",".postTitle",function (){

		var postNo=$(this).data("postno");
		console.log("포스트넘버"+postNo+" 디스"+$(this));
 		fetchPost(postNo);
 		
 	});
 	
 			
 	function fetchPost(postNo){
 		
 			
 		var postNo = postNo;	
 		$(".postTitle").css("font-weight", "" );
		$("[data-postno='"+postNo+"']").css("font-weight", "bold" );
 		console.log("포스트넘버 페치포스트"+postNo);
 		$("#postNo_hdn").val(postNo);

 		$.ajax({
 			  
 			  url : "${pageContext.request.contextPath}/${vo.id}/getPost",
 			  type : "POST",
 			  data : {postNo: postNo},
 			  dataType : "json",
 			
 			  success : function(list){
 				  
 				  
	 				  $.each(list, function(idx, val) {
							console.log(idx + " " + val.postNo);
							render_post(val);
								  
							  });
 			  },
 			  
 			  error : function(XHR, status, error){
 				  

				
 				 console.error(XHR+status+error);
 			  }
 			  
 			  });
 		}
 	
 	
 	function render_postList(vo,updown){
	 		  str= " ";
	 		  str+= "	<li style='width:100%;cursor:pointer;' data-postno="+vo.postNo+" class='postTitle' >";
	 		  str+= "	<a>"+vo.postTitle+"</a> ";
	 		  str+= "	<span>"+vo.regDate+"</span>";
	 		  str+= "	</li>";
	 		  str+= "	";
	 		  
	 		  if(updown=="up"){
	 			  
	 			  $(".blog-list").prepend(str);
	 			  
	 		  } else{
	 			  
	 			  $(".blog-list").append(str);
	 		  }
 			  
 		}
 	
 	function render_post(vo){
 		
 		
			  str= " ";
			  str+= "	<h4>"+vo.postTitle+"</h4>";
			  str+= "	<p>";
			  str+= "	"+vo.postContent+"";
			  str+= "		</p>";
			  str+= "	";
			  
				  
			  $(".blog-content").html(str);
			  
		}
 	
 	
 	$("#btn_cmt").on("click",function(){
 		
 		var postNo= $("#postNo_hdn").val();
 		var cmtContent = $("#cmtContent").val();
 		var writerId = ${authVO.id};
 		
 		$.ajax({
			  
			  url : "${pageContext.request.contextPath}/${vo.id}/cmt/add",
			  type : "POST",
			  data : {postNo: postNo,cmtContent:cmtContent,writerId:writerId},
			  dataType : "json",
			
			  success : function(list){
				  
				  
	 				  $.each(list, function(idx, val) {
							console.log(idx + " " + val.postNo);
							render_post(val);
								  
							  });
			  },
			  
			  error : function(XHR, status, error){
				  
				 console.error(XHR+status+error);
				 
			  }
			  
			  });
 	});
 	
 	
 	
</script>
</html>
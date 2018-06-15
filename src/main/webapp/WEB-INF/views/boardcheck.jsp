<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file="include/header.jsp"%>
<style>
	#delete{
		margin-top:70px;
	}
	.password_div{
		text-align: center;
		padding-top:150px;
	}
	#delete_password{
		width: 40%;
		display: inline;
	}  
	
</style>

<div class="w3-content" style="max-width:1000px; min-height: 760px;">
	<div id="delete">
		<form method="get" id="f1">  
			<input type="hidden" name="bno" value="${bno }">
			<input type="hidden" name="page" value="${page }">
			<input type="hidden" name="searchType" value="${cri.searchType }">
			<input type="hidden" name="keyword" value="${cri.keyword }">
			<input type="hidden" name="imgs" value="${imgs }">
			<input type="hidden" name="pass" value="" id="pass">
			<input type="hidden" name="check" value="${check }">		
		</form>
		<div class="form-group password_div">  
			<h3>비밀번호를 입력하세요</h3>
			<input type="text" name="pass" class="form-control" id="delete_password">		
			<input type="submit" class="btn btn-default" id="delete_btn" value="입력">
			<input type="submit" class="btn btn-default" id="cancel_btn" value="취소">		
		</div>
		
		
		<script>
		
			$("#delete_btn").click(function(){
				
				var num = $("#delete_password").val();				
				$("input[name='pass']").val(num);
				var check = $("input[name='check']").val();
				
				if(check == 1){
					
					$("#f1").attr("action","removePage");
					$("#f1").submit();	
					
				}else{
					$("#f1").attr("method","post");
					$("#f1").attr("action","boardcheck");
					$("#f1").submit();	
					
				}				
					
			})  
			$("#cancel_btn").click(function(){
				var bno = $("input[name='bno']").val();
				var page = $("input[name='page']").val();
				var searchType = $("input[name='searchType']").val();
				var keyword = $("input[name='keyword']").val();
				
				location.href = "${pageContext.request.contextPath}/readPage?bno="+bno+"&page="+page+"&searchType="+searchType+"&keyword="+keyword+"&mod=mod"; 
			})  
						
						
				
						
						
						

						
			</script>
	
	
	</div>
</div>

<%@ include file="include/footer.jsp"%>
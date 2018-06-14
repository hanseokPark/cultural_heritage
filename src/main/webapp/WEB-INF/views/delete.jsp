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
			<input type="hidden" name="bno" value="${bno }" id="bno">
			<input type="hidden" name="page" value="${page }">
			<input type="hidden" name="searchType" value="${searchType }">
			<input type="hidden" name="keyword" value="${keyword }">
			<input type="hidden" name="imgs" value="${imgs }" id="imgs">
			<input type="hidden" name="pass" value="" id="pass">		
		</form>
		<div class="form-group password_div">  
			<h3>비밀번호를 입력하세요</h3>
			<input type="text" name="pass" class="form-control" id="delete_password">		
			<input type="submit" class="btn btn" id="delete_btn" value="입력">
			<input type="submit" class="btn btn-default" id="back_btn" value="취소">		
		</div>
		
		
		<script>
			$("#delete_btn").click(function(){
				
				var num = $("#delete_password").val();				
				$("#pass").val(num);
			
				
				$("#f1").attr("action","removePage");
				$("#f1").submit();								
					
			})  
						
						
				
						
						
						

						
			</script>
	
	
	</div>
</div>

<%@ include file="include/footer.jsp"%>
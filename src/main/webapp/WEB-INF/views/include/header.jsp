<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">	
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- Bootstrap 3.3.4 -->
    <link href="${pageContext.request.contextPath }/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons -->
</head>
<style>
	.dropdown{
		width:100%;   
	}
</style> 
<body>  
	<!-- Links (sit on top) -->
	<div class="w3-top"> 
		<div class="w3-row w3-medium w3-light-grey">
			<div class="w3-col s3">
				<a href="${pageContext.request.contextPath}/" class="w3-button w3-block">홈</a>
			</div>   
			<div class="w3-col s3">
				<a href="#plans" class="w3-button w3-block">사이트 소개</a>
			</div>  
			<div class="w3-col s3 w3-dropdown-hover">				  
				<a href="search" class="w3-button w3-block">문화재 분류 및 검색</a>				
				<div class="w3-dropdown-content w3-border dropdown">  
    				<a href="#" class="w3-bar-item w3-button">시대별</a> 
  		 			<a href="#" class="w3-bar-item w3-button">종목별</a>
    				<a href="AreaList?ctrdCd=11" class="w3-bar-item w3-button">지역별</a> 
				</div>
			</div>
			<div class="w3-col s3">
				<a href="#contact" class="w3-button w3-block">게시판</a>
			</div>
		</div>
	</div>	
	
</body>
</html>
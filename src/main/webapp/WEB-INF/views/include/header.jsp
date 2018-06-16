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
	
	<!-- include libraries(jQuery, bootstrap) -->
	<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

	<!-- include summernote css/js-->
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
	<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
	
	
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
	#top{
		margin-top:80px;
	}
	#introduction h2{
		border-bottom: 1px solid #ddd;
	}
	.introduction_padding{
		padding-left:60px;		
	}
	.w3-top{
		min-width:960px;
	}
	
	/* --------------------------- home --------------------------- */	
	#home_body{
		min-width:960px;
	}
	
	/* --------------------------- introductionView --------------------------- */
	
	#introduction_div{
		margin-top:80px;
	}
	
	/* --------------------------- board --------------------------- */
	section.w3-content{
		min-width:650px;
	}
	section.w3-content .row{
		margin-top:70px;		
	}
	
	.box-body{
		margin-bottom:10px;
	} 
	.box-body table tr th,.td{
		text-align: center;
	} 
	/* .box-body table tr .td_title a span{
		text-overflow: ellipsis;
		overflow: hidden;
		white-space:nowrap;
		width: 400px;
		display: inline-block;
	} */
	
	#searchType{
		height:22px;
	}
	#keyword{
		height:22px;
	}
	#btn_span{		
		position: absolute;
		right:0;		  
	}	

	/* --------------------------- register --------------------------- */
	section.content .row{
		margin:0 auto;
		margin-top:70px;
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
				<a href="introductionView" class="w3-button w3-block">사이트 소개</a>
			</div>  
			<div class="w3-col s3 w3-dropdown-hover">				  
				<a href="search" class="w3-button w3-block">문화재 검색 및 우리 지역 문화재</a>				
				<div class="w3-dropdown-content w3-border dropdown">  
    				<!-- <a href="#" class="w3-bar-item w3-button">시대별</a> 
  		 			<a href="#" class="w3-bar-item w3-button">종목별</a> -->
  		 			<a href="search" class="w3-bar-item w3-button">문화재 검색</a>
    				<a href="areaList?ctrdCd=11&itemCd=0" class="w3-bar-item w3-button">우리 지역 문화재</a> 
				</div>    
			</div>   
			<div class="w3-col s3">
				<a href="board" class="w3-button w3-block">게시판</a>
			</div>
		</div>
	</div>		
</body>
</html>
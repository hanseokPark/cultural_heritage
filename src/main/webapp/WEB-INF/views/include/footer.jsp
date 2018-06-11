<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	footer{
		height:130px;
		min-width:1240px;
	} 
	#footer_wrap{
		padding:30px 0 30px 0;
	}
	
	#footer_select{
		margin-left:40px;
	
	}
</style>
</head>
<body>
	  
<!-- Footer -->
 
<footer class="w3-container w3-padding-25 w3-light-grey w3-center">  
	<div id="footer_wrap"> 	 
		<div>본 저작물은 문화재청에서 2010년 작성하여 공공누리 제1유형으로 개방한 open api을 이용하였으며,해당 저작물은 <a href="http://www.cha.go.kr/">문화재청</a>에서 무료로 다운받으실 수 있습니다.
		<select id="footer_select"> 
   			<option value="">관련 사이트 바로가기</option>
  			<option value="http://www.cha.go.kr/">문화재청</option>
  			<option value="http://www.museum.go.kr/site/main/home">국립 중앙박물관</option>  
  			<option value="http://www.culture.go.kr/index.do">문화포털</option>
  			<option value="https://www.data.go.kr/">공공데이터포털</option>  		
		</select>
	</div>
	</div>
	<div><img alt="공공누리" src="${pageContext.request.contextPath }/resources/images/img_opentype01.png"></div>
</footer>
    
    
  <script>
  	$("#footer_select").change(function(){
  		var vv= $("#footer_select option:selected").val();
  		
  		if(vv != ""){
  			window.open("about:blank").location.href= vv;
  		}
  	})
  </script>
</body>
</html>
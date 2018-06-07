<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/header.jsp"%>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1cfc26da8cc242c14f4132e03ece9b02"></script>

<style>
	.table tr th{
		text-align: center;
		
	}
	#tr1_th1{
		border-bottom: 1px solid #ddd;
		font-size: 20px;
		color:black;
	}
	.table tr td{   
		text-align: center; 	
		vertical-align: middle !important;
		
	}
	
	#main_table tr td{
		border-top: 0 !important;  
	}
	
	
</style>  

<div class="w3-content" style="max-width:1000px;margin-top:80px;margin-bottom:80px">
	<div class="w3-row w3-container">
		<div id="selectwrap">  
			<div>				<%-- <img src="${cultural.imageUrl } "> --%> <%-- ${cultural.critdDc }   --%>
				<table class="table">
					<tr> 
						<c:if test="${cultural.crltsNmChcrt != null }">							
							<th style="width:150px;" id="tr1_th1">
								${cultural.itemNm } ${cultural.crltsNoNm}호<br> ${cultural.crltsNm }<br>(${cultural.crltsNmChcrt })
							</th>							
						</c:if>								
						<c:if test="${cultural.crltsNmChcrt  == null }">		  				      				
                 			 <th style="width:150px;" id="tr1_th1">
								${cultural.itemNm } ${cultural.crltsNoNm}호<br> ${cultural.crltsNm }
							</th>				
                 		</c:if>											
					</tr>
				</table>
				<table class="table" id="main_table">
					<tr>
						<td style="width:280px;">
							<c:if test="${cultural.imageUrl != null }">
								<img src="${cultural.imageUrl }" >
							</c:if>							
						</td>
						<td>
							<table class="table table-bordered">
								<tr>
									<th style="width:150px;">이미지</th>
									<th style="width:150px;">종목</th>
									
								</tr>
								<tr>
									<th style="width:150px;">이미지</th>
									<th style="width:150px;">종목</th>
									
								</tr>
								<tr>
									<th style="width:150px;">이미지</th>
									<th style="width:150px;">종목</th>
									
								</tr>
								<tr>
									<th style="width:150px;">이미지</th>
									<th style="width:150px;">종목</th>
									
								</tr>
							</table>
						</td>
					</tr>  
					
				</table>		
			</div>
			
		</div>	  
		  
		<div class="box-body">  		
			<!-- 이미지 지도를 표시할 div 입니다 -->	
			<c:if test="${cultural.XCnts != '0'}">		
				<div id="staticMap" style="width:968px;height:350px;"></div>
			</c:if>  
			<input type="hidden" value="${cultural.crltsNm }" id="crltsNm">
			<input type="hidden" value="${cultural.XCnts }" id="XCnt">
			<input type="hidden" value="${cultural.YCnts }" id="YCnt">
			<script>
				// 이미지 지도에 표시할 마커입니다
				// 이미지 지도에 표시할 마커를 아래와 같이 배열로 넣어주면 여러개의 마커를 표시할 수 있습니다 
				var x = $("#XCnt").val();
				var y = $("#YCnt").val();
				var culturalname = $("#crltsNm").val();
			
				var markers = [{	
					position: new daum.maps.LatLng(y, x)
				},
   				{  
    				position: new daum.maps.LatLng(y, x), 
    				text: culturalname // text 옵션을 설정하면 마커 위에 텍스트를 함께 표시할 수 있습니다     
   				}
				];
				
				var staticMapContainer  = document.getElementById('staticMap'), // 이미지 지도를 표시할 div  
   					 staticMapOption = { 
    				    center: new daum.maps.LatLng(y, x), // 이미지 지도의 중심좌표
     				 	level: 3, // 이미지 지도의 확대 레벨
      				  	marker: markers // 이미지 지도에 표시할 마커 
  				 };    	

				// 이미지 지도를 생성합니다
				var staticMap = new daum.maps.StaticMap(staticMapContainer, staticMapOption);
			</script>
			
			
			
			
			
			
		</div>  		
	</div>
</div>

<%@ include file="include/footer.jsp"%>
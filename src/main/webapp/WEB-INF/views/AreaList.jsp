<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/header.jsp"%>

<style>
	.table tr th{
		text-align: center;
	}
	.table tr td{ 
		text-align: center; 	
		vertical-align: middle !important;
	}
</style>

<div class="w3-content" style="max-width:1000px;margin-top:80px;margin-bottom:80px">
	<div class="w3-row w3-container">
		<div id="selectwrap">
			<select id="AreaList_select">
				<option value="11" ${selected == '11' ? 'selected' : '' }>서울</option>
				<option value="21" ${selected == '21' ? 'selected' : '' }>부산</option>
				<option value="22" ${selected == '22' ? 'selected' : '' }>대구</option>
				<option value="23" ${selected == '23' ? 'selected' : '' } >인천</option>
				<option value="24" ${selected == '24' ? 'selected' : '' }>광주</option>
				<option value="25" ${selected == '25' ? 'selected' : '' }>대전</option>
				<option value="26" ${selected == '26' ? 'selected' : '' }>울산</option>
				<option value="45" ${selected == '45' ? 'selected' : '' }>세종</option>
				<option value="31" ${selected == '31' ? 'selected' : '' }>경기</option>
				<option value="32" ${selected == '32' ? 'selected' : '' }>강원</option>
				<option >충북</option>
				<option >충남</option>
				<option >전북</option>
				<option >전남</option>
				<option >경북</option>
				<option >경남</option>
				<option >제주</option>
				<option >기타</option>
			</select>
		</div>
		  
		<div class="box-body">  
					<table class="table table-boardered">
						<tr>  
							<th style="width:150px;">이미지</th>
							<th style="width:150px;">종목</th>
							<th style="width:400px;">명칭</th>
							<th style="width:150px;">소재지</th>												
						</tr>   
						<c:forEach items="${result }" var="item">
							<tr>
								<td><img src="${item.listImageUrl }"></td>
								<td align="center">${item.itemNm } ${item.crltsNoNm}호	</td>
								<td>${item.crltsNm }<br>(${item.crltsNmChcrt })</td>
								<td>${item.ctrdNm }</td>								
							</tr>	
						</c:forEach>						
					</table>
				</div>
		
		   
  	<script>
  		$("#AreaList_select").change(function(){
  			var vv= $("#AreaList_select option:selected").val();
  			
  			if(vv != ""){
  				location.href = "AreaList?ctrdCd="+vv;
  			}
  		})
 	 </script>
		
		
		
		
		
		
		
		
		
		
		
	</div>
</div>

<%@ include file="include/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<style>
	#search_select{
		margin-top:70px;
	}
	label.font_size{
		font-size: 20px;
		margin-right:10px;
	}
	.form-group{
		margin-bottom: 10px !important;
	}
	.select_group{
		text-align: center;
	}
	
	
	.search_select {
		width: 200px;
		height: 30px;
		padding-left: 10px;   
		border: 1px solid #ccc;
		border-radius: 3px;
	}	
	.label2{
		margin-left:20px;
	}
	
	.search_div{
		text-align: center;
	} 
	
	
	
	#search_name{
		width: 60%;
		display: inline;
	}
	 
	  
</style>
<%@ include file="include/header.jsp"%>

<div class="w3-content" style="max-width:1000px; min-height: 800px;">
	<div id="search_select">
		<div id="selectwrap">
			<!-- <button id="searchBtn">선택</button> -->
			<div class="form-group select_group">
     				<label class="font_size">지역</label>
      				<select id="areaList_select" class="search_select">
					<option value="" >전체</option>					
					<option value="11" ${areaselected == '11' ? 'selected' : '' }>서울</option>
					<option value="21" ${areaselected == '21' ? 'selected' : '' }>부산</option>
					<option value="22" ${areaselected == '22' ? 'selected' : '' }>대구</option>
					<option value="23" ${areaselected == '23' ? 'selected' : '' }>인천</option>
					<option value="24" ${areaselected == '24' ? 'selected' : '' }>광주</option>
					<option value="25" ${areaselected == '25' ? 'selected' : '' }>대전</option>
					<option value="26" ${areaselected == '26' ? 'selected' : '' }>울산</option>				
								
					<option value="31" ${areaselected == '31' ? 'selected' : '' }>경기</option>				
					
					<option value="32" ${areaselected == '32' ? 'selected' : '' }>강원</option>				
					
					<option value="33" ${areaselected == '33' ? 'selected' : '' }>충북</option>
					<option value="34" ${areaselected == '34' ? 'selected' : '' }>충남</option>				
						
					<option value="37" ${areaselected == '37' ? 'selected' : '' }>경북</option>
					<option value="38" ${areaselected == '38' ? 'selected' : '' }>경남</option>				
						
					<option value="35" ${areaselected == '35' ? 'selected' : '' }>전북</option>
					<option value="36" ${areaselected == '36' ? 'selected' : '' }>전남</option>				
					
					<option value="45" ${areaselected == '45' ? 'selected' : '' }>세종</option>
					<option value="39" ${areaselected == '39' ? 'selected' : '' }>제주</option>				
					
					<option value="40" ${areaselected == '40' ? 'selected' : '' }>황해도</option>
					<option value="42" ${areaselected == '42' ? 'selected' : '' }>평안북도</option>
					<option value="41" ${areaselected == '41' ? 'selected' : '' }>평안남도</option>
					<option value="44" ${areaselected == '44' ? 'selected' : '' }>함경북도</option>
					<option value="43" ${areaselected == '43' ? 'selected' : '' }>함경남도</option>
					<option value="46" ${areaselected == '46' ? 'selected' : '' }>기타</option>
				</select>
				<label class="font_size label2">종목</label>
     			<select id="eventList_select" class="search_select">
					<option value="0"  ${eventselected == '0' ? 'selected' : '' }>전체</option>
					<option value="11" ${eventselected == '11' ? 'selected' : '' }>국보</option>
					<option value="12" ${eventselected == '12' ? 'selected' : '' }>보물</option>
					<option value="13" ${eventselected == '13' ? 'selected' : '' }>사적</option>
					<option value="15" ${eventselected == '15' ? 'selected' : '' }>명승</option>
					<option value="16" ${eventselected == '16' ? 'selected' : '' }>천연기념물</option>
					<option value="17" ${eventselected == '17' ? 'selected' : '' }>국가무형문화재</option>
					<option value="18" ${eventselected == '18' ? 'selected' : '' }>국가민속문화재</option>	
					<option value="21" ${eventselected == '21' ? 'selected' : '' }>시도유형문화재</option>
					<option value="22" ${eventselected == '22' ? 'selected' : '' }>시도무형문화재</option>
					<option value="23" ${eventselected == '23' ? 'selected' : '' }>시도기념물</option>
					<option value="24" ${eventselected == '24' ? 'selected' : '' }>시도민속문화재</option>	
					<option value="31" ${eventselected == '31' ? 'selected' : '' }>문화재자료</option>
					<option value="79" ${eventselected == '79' ? 'selected' : '' }>등록문화재</option>
					<option value="80" ${eventselected == '80' ? 'selected' : '' }>이북5도 무형문화재</option>								
				</select>
   			 </div>
   			 <div class="form-group search_div">
  				<label class="font_size search_label">문화재 명</label>
  				<input type="text" class="form-control" id="search_name">
  				<button type="button" class="btn btn-success" id="searchBtn">검색</button>
			</div>
		</div>
		
		<script type="text/javascript">
						$("#searchBtn").click(function(){
							var area = $("#areaList_select option:selected").val();
							var event = $("#eventList_select option:selected").val();
							var name = $("#search_name").val();
							
							
							
				  			
				  			if(area != ""){
				  			 	location.href = "search?ctrdCd="+area+"&itemCd="+event+"&culName="+name;
				  			}
							
						})
					
		</script>
		
		<c:if test="${result != null }">
		
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
						<c:if test="${item.itemNm == '중요무형문화재' }">
							<td align="center">국가무형문화재 ${item.crltsNoNm}호</td>
						</c:if>
						<c:if test="${item.itemNm != '중요무형문화재' }">
							<td align="center">${item.itemNm } ${item.crltsNoNm}호</td>
						</c:if>
						<%-- <td>${item.crltsNm }<br>(${item.crltsNmChcrt })</td> --%>
						<c:if test="${item.crltsNmChcrt != null }">
							<td>
								<a href="detailView?crltsNo=${item.crltsNo }&ctrdCd=${item.ctrdCd }&itemCd=${item.itemCd}">
								${item.crltsNm }<br>(${item.crltsNmChcrt })
								</a>
							</td>
						</c:if>								
						<c:if test="${item.crltsNmChcrt  == null }">   							       				
                 			<td>
                 				<a href="detailView?crltsNo=${item.crltsNo }&ctrdCd=${item.ctrdCd }&itemCd=${item.itemCd}">
                 					${item.crltsNm }
                 				</a>                 				
                 			</td>                 			
                 		</c:if> 
						<td>${item.ctrdNm }</td>								
					</tr>	
				</c:forEach>						
			</table>
		</div>  
		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">  
					<c:if test="${pageMaker.prev }">
						<li><a href="areaList?ctrdCd=${areaselected }&page=1&itemCd=${eventselected}"> &lt;&lt; </a></li>
						<li><a href="areaList?ctrdCd=${areaselected }&page=${pageMaker.startPage-1 }&itemCd=${eventselected}"> &lt; </a></li>
					</c:if>
					<!-- pageMaker.startPage ~ endPage -->
					<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
						<li ${pageMaker.cri.page == idx ? 'class="active"' : '' }><a href="areaList?ctrdCd=${areaselected }&page=${idx }&itemCd=${eventselected}">${idx }</a></li>
					</c:forEach>
					<c:if test="${pageMaker.next }">						
						<li><a href="areaList?ctrdCd=${areaselected }&page=${pageMaker.endPage+1 }&itemCd=${eventselected}"> &gt; </a></li>
						<li><a href="areaList?ctrdCd=${areaselected }&page=${pageMaker.tempEndPage }&itemCd=${eventselected}"> &gt;&gt; </a></li>
					</c:if>  
				</ul>
			</div>
		</div>
		
		</c:if>
		
	</div>
</div>

<%@ include file="include/footer.jsp"%>
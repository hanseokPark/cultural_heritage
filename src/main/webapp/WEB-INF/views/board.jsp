<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="include/header.jsp"%>
	

	 
	<section class="w3-content">
	<div class="w3-content" style="max-width:1200px; min-height: 770px;">
	<div class="row">    
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">게시판</h3>
				</div>   
				<div class="box-body">
					<select name="searchType" id="searchType">
						<option value="n" ${cri.searchType == 'n' ? 'selected' : '' }>------------------</option>
						<option value="t" ${cri.searchType == 't' ? 'selected' : '' }>제목</option>
						<option value="c" ${cri.searchType == 'c' ? 'selected' : '' }>내용</option>
						<option value="w" ${cri.searchType == 'w' ? 'selected' : '' }>작성자</option>						
					</select>  
					<input type="text" name="keyword" id="keyword" value="${cri.keyword }">
					<button id="searchBtn" class="btn btn-default">검색</button>   
					<span id="btn_span">
						<a href="${pageContext.request.contextPath }/user/login" id="login" class="btn btn-primary btn-flat">관리자 로그인</a>
						
					<%-- <c:if test="${login != null  }">
                    	<a href="${pageContext.request.contextPath }/user/logout" class="btn btn-danger btn-flat">관리자 로그아웃</a>
                    </c:if>
                    <c:if test="${login == null }">
                    	<a href="${pageContext.request.contextPath }/user/login" class="btn btn-default btn-flat">Sign in</a>
                    </c:if> --%>
                    <a id="register" class="btn btn-success btn-flat">글쓰기</a>
					</span>
					<script type="text/javascript">
						$("#searchBtn").click(function(){
							var searchType = $("#searchType").val();
							var keyword = $("#keyword").val();
							
							location.href = "board?searchType="+searchType+"&keyword="+keyword;
							
						})  
						
						$("#register").click(function(){
							location.href = "register";
						})
						
					</script>
				</div>  
			<div class="box-body"> 
					<table class="table table-boardered">
						<tr> 
							<th style="width:5px;">번호</th>  
							<th style="width:70px;">제목</th>  
							<th style="width:10px;">작성자</th>
							<th style="width:5px;">날짜</th>
							<th style="width:5px;">조회수</th>					
						</tr>
						<c:forEach var="item" items="${list }">
							<tr>
								<td class="td">${item.bno }</td>
								<td class="td_title"><a href="readPage?bno=${item.bno }&page=${pageMaker.cri.page}&searchType=${cri.searchType }&keyword=${cri.keyword}&viewCnt=0" class="a">${item.title }</a> [${item.replycnt}]</td>							
						<%-- 		<td class="td_title"><a href="readPage?bno=${item.bno }" class="a"><span>${item.title }</span></a> [${item.replycnt}]</td> --%>
								<td class="td">${item.writer }</td>
								<td class="td"><fmt:formatDate value="${item.regdate }" pattern="yyyy-MM-dd HH:mm"/></td>
								<td class="td"><span class="badge bg-red">${item.viewcnt }</span></td>
							</tr>							
						</c:forEach>						
					</table>
				</div>
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${pageMaker.prev }">
								<li><a href="listPage?page=${pageMaker.startPage-1 }"> &lt; </a></li>
							</c:if>
						<!-- pageMaker.startPage ~ endPage -->
							<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
								<li ${pageMaker.cri.page == idx ? 'class="active"' : '' }><a href="board?page=${idx }&searchType=${pageMaker.cri.searchType}&keyword=${pageMaker.cri.keyword}">${idx }</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next }">
								<li><a href="listPage?page=${pageMaker.endPage+1 }"> &gt; </a></li>
							</c:if>  
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
	
	  

	
<%@ include file="include/footer.jsp"%>
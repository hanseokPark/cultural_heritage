<%@page import="java.util.Enumeration"%>
<%@page import="org.springframework.web.multipart.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>


<style>
	.btnAll{
		text-align: right;
	}
	
</style>

<div class="w3-content" style="max-width:800px;  min-height: 771px;">
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary"> 
				<div class="box-header">
					<h3 class="box-title">글 수정</h3>
				</div>
				<div class="box-body">
					<form method="post" id="f1">					
						<input type="hidden" name="bno" value="${boardVO.bno }">
						<input type="hidden" name="page" value="${cri.page }">
						<input type="hidden" name="searchType" value="${cri.searchType }">
						<input type="hidden" name="keyword" value="${cri.keyword }">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="title" class="form-control" value="${boardVO.title }">							
						</div>						
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="writer" class="form-control" value="${boardVO.writer }" readonly="readonly"><!--  readonly="readonly" -->
						</div>
						<!-- <div class="form-group">
							<label>비밀번호</label>
							<input type="text" name="ur_pass" class="form-control" placeholder="숫자만 입력">
						</div> -->
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" cols="30" class="form-control" name="content" id="summernote">${boardVO.content }</textarea>
						</div>		
					</form>  
					<div class="form-group btnAll">
						<button type="submit" class="btn btn-primary" id="modify">수정</button>
						<button type="submit" class="btn btn-warning" id="cancel">취소</button>
					</div>
					<script>
							var bno = $("input[name='bno']").val();
							var page = $("input[name='page']").val();
							var searchType = $("input[name='searchType']").val();
							var keyword = $("input[name='keyword']").val();
						
							$("#modify").click(function(){
								
								$("#f1").attr("action","modifyPage");
								$("#f1").submit();
							})
							$("#cancel").click(function(){
								location.href = "${pageContext.request.contextPath}/readPage?bno="+bno+"&page="+page+"&searchType="+searchType+"&keyword="+keyword+"&mod=mod";  
							})       
							
							
							$(".imgbtn").click(function(event){
								event.preventDefault();
																
								var form = $(this).parent();
								var img = $(this).attr('data-file')
								
								
								var str = "";      
						
								str = "<input type='hidden' name='fileName' value='" + img + "'>";	
									
								
								$(this).prev().remove();
								$(this).remove();
								form.append(str);

							})  
							
										
						</script>   
				</div>
			</div>
		</div>
	</div>
</section>
</div>

<script>
	
	
	$(document).ready(function() {
	      $('#summernote').summernote({
	        height: 300,
	        minHeight: null,
	        maxHeight: null,
	        focus: true,
	        callbacks: {
	          onImageUpload: function(files, editor, welEditable) {
	            for (var i = files.length - 1; i >= 0; i--) {
	              sendFile(files[i], this);
	            }
	          }
	        }
	      });
	    });
	 
	 function sendFile(file, el) {
	      var form_data = new FormData();
	      form_data.append('file', file);
	      $.ajax({
	        data: form_data,
	        type: "POST",
	        url: 'imgupload',
	        cache: false,
	        contentType: false,
	        enctype: 'multipart/form-data',
	        processData: false,
	        success: function(url) {
	          $(el).summernote('editor.insertImage', "displayFile?filename="+url);
	         
	        }
	      });
	    }

	 
</script>

<%@ include file="include/footer.jsp"%>
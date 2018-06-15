<%@page import="java.util.Enumeration"%>
<%@page import="org.springframework.web.multipart.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>

<style>  
	.w3{
		border: 1px solid #ccc;
		border-radius: 4px;
		padding:10px;
		background-color: #eee;
	}
	
	#content_div{
		margin-bottom:5px !important;
	}
	.box-footer{
		margin-top:10px;
		text-align: right;
	}
	  
</style>

<section class="content">
	<div class="row">
		<div class="col-md-10">
			<div class="box box-primary"> 
				<div class="box-header">
					<h3 class="box-title">글쓰기</h3>
				</div>
				<div class="box-body">
					<form method="get" id="f1">
						<input type="hidden" name="bno" value="${readPage.bno }" id="bno">
						<input type="hidden" name="page" value="${cri.page }">
						<input type="hidden" name="searchType" value="${cri.searchType }">
						<input type="hidden" name="keyword" value="${cri.keyword }">
						<input type="hidden" name="imgs" value="" id="imgs">
					
					</form>
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="title" class="form-control" placeholder="Enter Title" value="${readPage.title }"  readonly="readonly">							
						</div>						
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="writer" class="form-control" placeholder="Enter Writer" value="${readPage.writer }" readonly="readonly">
						</div>					
						<div class="form-group" id="content_div">
							<label>내용</label>
						</div>
						<div class="w3" id="content">							
							<span>${readPage.content }</span>
						</div>
						<div class="box-footer">					
							<button type="submit" class="btn btn-warning" id="modifyBtn">
								Modify
							</button>
						<button type="submit" class="btn btn-danger" id="deleteBtn">
							Delete
						</button>						
						<button type="submit" class="btn btn-primary" id="goListBtn">
							GO LIST
						</button>  
						<script>
						$("#goListBtn").click(function(){						
							
							$("#f1").attr("action","board");
							$("#f1").submit();
						})
						$("#modifyBtn").click(function(){
							$("#f1").attr("action","modifyPage");
							$("#f1").submit();
						})
						
						var arr = []; 
 
							$("#content span").find("img").each(function(i , e){
								console.log( $(this).attr("src").substring(21) );
								arr[i] = $(this).attr("src").substring(21); 		
							}) 
 							$("#imgs").val(arr);
						
						
						
						$("#deleteBtn").click(function(){
						
							$("#f1").attr("action","delete");
							$("#f1").submit();
						})  
						

						
						</script>
						</div>					
				</div>
			</div>
		</div>
	</div>
</section>

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
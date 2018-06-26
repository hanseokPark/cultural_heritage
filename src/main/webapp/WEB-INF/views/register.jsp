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

<div class="w3-content" style="max-width:1000px;  min-height: 771px;">
<section class="content">
	<div class="row">    
		<div class="col-md-14">
			<div class="box box-primary"> 
				<div class="box-header">
					<h3 class="box-title">글쓰기</h3>
				</div>
				<div class="box-body">
					<form method="post" id="f1">
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="title" class="form-control" placeholder="Enter Title">							
						</div>						
						<div class="form-group">
							<label>작성자</label>
							<input type="text" name="writer" class="form-control" placeholder="Enter Writer" value="${login.uid }"><!--  readonly="readonly" -->
						</div>
						<div class="form-group">
							<label>비밀번호</label>
							<input type="text" name="ur_pass" class="form-control" placeholder="숫자만 입력" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" cols="30" class="form-control" name="content" id="summernote"></textarea>
						</div>							
					</form>  
					<div class="form-group btnAll">  
						<input type="submit" class="btn btn-primary"  id="register_btn" value="등록">
						<input type="submit" class="btn btn-warning"  id="cancel_btn" value="취소">  
					</div>
					<script>
							$("#register_btn").click(function(){
								var title = $("input[name='title']").val();
								var writer = $("input[name='writer']").val();
								var ur_pass = $("input[name='ur_pass']").val();
								
								if(title == ""){
									alert("제목을 입력하세요");
									return;
								}
								if(writer == ""){
									alert("작성자를 입력하세요");
									return;
								}
								if(ur_pass == ""){
									alert("비밀번호를 입력하세요 (숫자만 가능합니다.)");
									return;  
								}
								
								$("#f1").attr("action","register");
								$("#f1").submit();
							})
							
							
							$("#cancel_btn").click(function(){
								location.href = "${pageContext.request.contextPath}/board"; 
							})     
							
							
							/* document.$("button[title data-original-title='Remove Image']").click(function(){
								alert(this);
							})      */
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
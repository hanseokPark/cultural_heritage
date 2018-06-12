<%@page import="java.util.Enumeration"%>
<%@page import="org.springframework.web.multipart.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>

<section class="content">
	<div class="row">
		<div class="col-md-10">
			<div class="box box-primary"> 
				<div class="box-header">
					<h3 class="box-title">글쓰기</h3>
				</div>
				<div class="box-body">
					<form method="post" action="register">
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
							<input type="text" name="ur_pass" class="form-control" placeholder="숫자만 입력">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" cols="30" class="form-control" name="content" id="summernote"></textarea>
						</div>			
						<div class="form-group">
							<input type="submit" class="btn btn-primary"  id="register_btn">
						</div>
					</form>  
				</div>
			</div>
		</div>
	</div>
</section>

<script>
	/* $(document).ready(function() {
  	  $('#summernote').summernote({
   	         height: 300,                 // set editor height
   	         minHeight: null,             // set minimum height of editor
    	     maxHeight: null,             // set maximum height of editor
    	     focus: false                  // set focus to editable area after initializing summernote
  	  	});
	});
	 */
	
	/*  $('#summernote').summernote({	 
         //생략..
         //해당callback을 아래처럼 등록하면 이미지업로드시 default로 처리하는부분 무시하고 해당 function호출합니다.
	 callbacks: {                  
    	 onImageUpload: function(files, editor, welEditable) {
    		 height: 300,   
   		  console.log(files);
   	 	 console.log(editor);
   	 	 console.log(welEditable);
   	 	 var opt = {};
     	    for (var i = files.length - 1; i >= 0; i--) {
       	 	 sendFile(files[i], this);
       		 	        	
      	   }
    	 }
 		} 
	});   */
	
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
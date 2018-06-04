<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/header.jsp"%>
 


  
<div class="w3-content" style="max-width:1000px;margin-top:80px;margin-bottom:80px"><!-- max-width:500px -->
	<img class="mySlides" src="${pageContext.request.contextPath }/resources/images/img1.jpg" style="width:100%">
	<img class="mySlides" src="${pageContext.request.contextPath }/resources/images/img2.jpg" style="width:100%">
    <img class="mySlides" src="${pageContext.request.contextPath }/resources/images/img3.jpg" style="width:100%">
    <img class="mySlides" src="${pageContext.request.contextPath }/resources/images/img4.jpeg" style="width:100%">  	
</div>
  
<script>        
var myIndex = 0;
carousel();

function carousel() {  
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>

<%@ include file="include/footer.jsp"%>



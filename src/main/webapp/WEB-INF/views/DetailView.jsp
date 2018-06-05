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
			${cultural.critdDc }  
			
		</div>	
		  
		<div class="box-body">  
			
		</div>  
		
	</div>
</div>

<%@ include file="include/footer.jsp"%>
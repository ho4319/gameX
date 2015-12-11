<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="../css/header.css">        
<div class="header">
알흠다운 UI - 
<c:if test="${not empty loginUser}">
	ID : ${loginUser.email}   /  
	<a href="${pageContext.request.contextPath}/auth/logout.do">로그아웃</a>
</c:if>
<c:if test="${empty loginUser}">
  <a href="${pageContext.request.contextPath}/auth/login.do">로그인</a>
</c:if>
</div>
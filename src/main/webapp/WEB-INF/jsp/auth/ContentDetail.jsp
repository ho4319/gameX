<%-- 게시물 상세정보 및 변경 폼 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시판-상세정보</title>
  <link rel="stylesheet" type="text/css" href="../css/common.css">
</head>
<body>

<jsp:include page="/Header.jsp"/>

<h1>게시물 정보</h1>

<c:if test="${not empty content}">
<form id='form1' action='updateForm.do?no=${content.no}' method='get'
      enctype="multipart/form-data">
<table border='1' width='400px'>
<tr>
  <th>번호</th>
  <td>${content.no}</td>
</tr>
<tr>
  <th>제목</th>
  <td>${content.title}</td>
</tr>
<tr>
  <th>작성자</th>
  <td>${content.writer}</td>
</tr>
<tr height="150px">
  <th>내용</th>
  <td>${content.comment}</td>
</tr>
<tr>
  <th>조회수</th>
  <td>${content.views}</td>
</tr>
<tr>
  <th>등록일</th>
  <td>${content.createdDate}</td>
</tr>
<tr>
  <th>첨부파일</th>
  <td><a href='../attachfile/${content.attachFile}'>${content.attachFile}</a><br>
</tr>
</table>
<p>
<a href='updateForm.do?no=${content.no}' class='button2'>변경</a>
<a id='aDelete' href='delete.do?no=${content.no}' class='button2' onclick='deleteContent()'>삭제</a>
<a href='list.do' class='button2'>목록</a>
</p>
</form>
</c:if>

<c:if test="${empty content}">
<p>해당 번호의 게시물을 찾을 수 없습니다.</p>
</c:if>

<jsp:include page="/Copyright.jsp"/>

<script>
function deleteContent() {
	var href = document.getElementById('aDelete').href;
}
</script>
</body>
</html>
    
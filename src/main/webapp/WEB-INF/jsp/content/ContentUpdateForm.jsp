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
  <title>게시판-변경</title>
  <link rel="stylesheet" type="text/css" href="../css/common.css">
  <link rel="stylesheet" type="text/css" href="../css/include.css">
  <link rel="stylesheet" type="text/css" href="../css/list.css">
  <link rel="stylesheet" type="text/css" href="../css/input.css">
</head>
<body>
<div id="layer_fixed">
    <table cellspacing="0" cellpadding="0" style="width:100%; height:100%;">
    <tr>
       <td style="vertical-align:middle; padding-left: 540px; padding-right: 0px;">
       <a href="../home.jsp"><img src="../file/home.png" align="center"></a> 알흠다운 UI 
       </td>
    </tr>
    </table>
    

</div>
<div class="container">
            <div class="codrops-top">
                <span class="right">
                </span>
            </div>
			<header>
				<h1>Custom <strong>Login Form</strong> Styling</h1>
				<h2>Creative and modern form design with CSS magic</h2>
			</header>
	</div>
<div>
<jsp:include page="/Header.jsp"/>
</div>
<div class="form-style-8">
<form action='update.do' method='post'
      enctype="multipart/form-data">
  <td>게시물 번호 :
  	<input type='text' name='no' value='  ${content.no}' readonly>
  </td>
  <td>제목 :
  	<input type='text' name='title' value='  ${content.title}'>
  </td>
  <td>작성자 :
  	<input type='text' name='writer' value='  ${loginUser.email}' readonly>
  </td>
  <td>내용 :
  	<textarea rows='10' name='comment' cols='60'>  ${content.comment}</textarea>
  </td>
  <td>조회수 :
  	<input type='text' name='no' value='  ${content.views}' readonly>
  </td>
  <td>작성일 :
  	<input type='text' name='no' value='  ${content.createdDate}' readonly>
  </td>
  <td>첨부 파일 :
  <a href='../attachfile/${content.attachFile}'>  ${content.attachFile}</a><br>
  <input type='file' name='file'>
  <input type='hidden' name='attachFile' value='${content.attachFile}'>
<c:if test="${not empty content}">
<p><button type='submit' class='in_button'>변경</button>
<a id='aList' href='list.do' class='in_button' onclick='listContent()'>취소</a>
</p>
</c:if>
</form>
</div>

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
    
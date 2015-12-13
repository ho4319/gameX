<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시판-목록</title>
  <link rel="stylesheet" type="text/css" href="../css/common.css">
  <link rel="stylesheet" type="text/css" href="../css/include.css">
  <link rel="stylesheet" type="text/css" href="../css/list.css">
  <script type="text/javascript" src="../fancybox/jquery-1.11.3.js"></script>
  	<link rel="stylesheet" href="../fancybox/source/jquery.fancybox.css" type="text/css" media="screen" />
	<script type="text/javascript" src="../fancybox/source/jquery.fancybox.pack.js"></script>
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
<form action="add.do" class="dd">
<c:if test="${loginUser.author eq '1'}">
<button class="button3">새 글</button>
</c:if>
</form>


<c:forEach var="content" items="${contents}">
<div id = "table">
			<div id = "table" align="center">
			<a class="fancybox" rel="group" href="../attachfile/${content.attachFile}" title="${content.no}">
			<img src="../attachfile/${content.attachFile}" width="400px" height="230px"></a>
			<a href='detail.do?no=${content.no}'>${content.no}</a><br>
			</div>
 		<div id = "sub_bottom"></div>
 	</div>
 </c:forEach>  


<form action="list.do" method='get' class="form">
<c:forEach var="paging" begin="1" end="${cnt}" varStatus="status">
  <a href='list.do?pageNo=${temp[status.count]}'>${status.count}</a>
</c:forEach>
</form>

<%-- 검색 부분 --%>
<p>
	<form action='search.do' method='get' class="form">
  		<select name="keyword">
  		   <option value="title">제목</option>
   			 <option value="no">글 번호</option>
  		</select>
		<input type='text' name='searchword'>
		<button type='submit'>검색</button>
	</form>
</p>

<script type="text/javascript">
	$(document).ready(function() {
		$(".fancybox").fancybox();
	});
</script>

<jsp:include page="/Copyright.jsp"/>

</body>
</html>





    
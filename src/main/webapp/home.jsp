<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/back.css">
<link rel="stylesheet" type="text/css" href="css/common.css">
<title>알흠다운 UI</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/auth/login.do">
<div id="layer_fixed">
    <table cellspacing="0" cellpadding="0" style="width:100%; height:100%;">
    <tr>
       <td style="vertical-align:middle; padding-left: 540px; padding-right: 0px;">
       <a href="home.jsp"><img src="file/home.png" align="center"></a> 알흠다운 UI 
       </td>
    </tr>
    </table>
    <table class="table1" align="right">
   	<tr>
   		<td>
 	 		<button name='update' type='submit' class='button1'>  login</button>
 	 	</td>
 	 	<td>
 	 		<a id='join' href="${pageContext.request.contextPath}/member/join.do" class='button1'
 	 		onclick='joinMember()'>join</a>
 		</td>
 		<td>
 	 		<a id='list' href="${pageContext.request.contextPath}/content/list.do" class='button1'
 	 		onclick='goList()'>list</a>
 		</td>
    </table>
    </div>
</form>
<script>
function joinMember() {
  document.getElementById('join').href = href;
}
</script>
<script>
function goList() {
  document.getElementById('list').href = href;
}
</script>


</body>
</html>
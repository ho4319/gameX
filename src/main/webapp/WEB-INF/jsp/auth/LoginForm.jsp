<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/include.css">
<link rel="stylesheet" type="text/css" href="../css/common.css">
<style>	
			@import url(http://fonts.googleapis.com/css?family=Montserrat:400,700|Handlee);
			body {
				background: #eedfcc url(images/bg3.jpg) no-repeat center top;
				-webkit-background-size: cover;
				-moz-background-size: cover;
				background-size: cover;
			}
			.container > header h1,
			.container > header h2 {
				color: #fff;
				text-shadow: 0 1px 1px rgba(0,0,0,0.5);
			}
</style>
<title>로그인</title>
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
<form class="form-5" action="login.do" method="post">
	<p>
        <input type="text" id="login" name="email" value="${cookie.email.value}" placeholder="Username">
        <input type="password" name="password" id="password" placeholder="Password"> 
    </p>
    <button type="submit" name="submit">
    	<i class="icon-arrow-right"></i>
    	<span>Sign in</span>
    </button>
    <input type="checkbox" name="saveEmail" 
  	${(empty cookie.email) ? "" : "checked" }>이메일 저장
	<a id='join' href="${pageContext.request.contextPath}/member/join.do" onclick='joinMember()'>
	<b>회원 가입</b></a><br>
</form>
        <script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
		<script type="text/javascript">
		$(function(){
			$('input, textarea').placeholder();
		});
		</script>
<script>
function joinMember() {
  document.getElementById('join').href = href;
}
</script>
</body>
</html>






<%@ page language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <link rel="stylesheet" type="text/css" href="../css/common.css">
  <link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/include.css">
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
<title>회원가입</title>
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
	
  <div align="center" class="ex">
  <form name="regist" id='form1' action='join.do' method='post'>
    <table>
      <tr>
        <th>이메일</th>
        <td><input type="text" name="email" placeholder="이메일을 입력하세요."/></td>
      </tr>
      <tr>
        <th>암호</th>
        <td><input type='password' name='password'></td>
      </tr>
      <tr>
        <th>암호 재입력</th>
        <td><input type='password' name='rePassword'></td>
      </tr>
    </table>
    
      <button type='submit' class='button1'>등록</button>
      <a href='../auth/login.do' class='button1'>취소</a>
  </form>
  </div>
</body>
</html>
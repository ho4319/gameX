<%@ page language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <link rel="stylesheet" type="text/css" href="../css/common.css">
<title>회원가입</title>
</head>
<body>
  <form name="regist" id='form1' action='add.do' method='post'>
    <table>
      <tr>
        <td colspan="3"><hr noshade="noshade" /></td>
      </tr>
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
    <p>
      <button type='submit' class='button1'>등록</button>
      <a href='../auth/login.do' class='button2'>취소</a>
    </p>
  </form>
</body>
</html>
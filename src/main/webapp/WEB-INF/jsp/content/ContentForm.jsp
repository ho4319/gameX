<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset='UTF-8'>
  <title>게시판-목록</title>
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
<form action='add.do' method='post'
      enctype="multipart/form-data"
      >
  <input type='text' name='title' placeholder='제목을 넣으세요' >
  <input type='text' name='writer' value='${loginUser.email}' readonly>
  <textarea rows='10' name='comment' cols='60'
       placeholder="내용을 입력하세요."></textarea>
  <input type='file' name='file'>
<p><button type='submit' class='in_button'>등록</button>
<a id='aList' href='list.do' class='in_button' onclick='listContent()'>취소</a>
</p>
</form>
</div>

<jsp:include page="/Copyright.jsp"/>

<script type="text/javascript">
//auto expand textarea
function adjust_textarea(h) {
    h.style.height = "20px";
    h.style.height = (h.scrollHeight)+"px";
}
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<h1>아이디를 입력하지 않았습니다. 아이디를 입력해 주세요.</h1>
	<form action="result.jsp" method="post"> <!-- submit 누를 시 result.jsp 전달 -->
		아이디: <input type="text" name="userID"><br>
		비밀번호: <input type="password" name="userPW"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력"> <!-- reset효과로 초기화 -->
	</form>
</body>
</html>
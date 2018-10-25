<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>addMember Form</h2>
	<form action="<%=request.getContextPath()%>/addMember" method="post">
		아이디 : 
		<input type="text" name="id"><br>
		비밀번호 :
		<input type="password" name="pw"><br>
		권한 :
		<input type="text" name="level"><br>
		<button type="submit">가입</button>
	</form>
</body>
</html>
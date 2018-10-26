<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginMember != null}">
		${loginMember}님 반갑습니다.
		<a href="${pageContext.request.contextPath}/GetMember">내정보보기</a>
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
	</c:if>
	<c:if test="${loginMember == null}">
		<a href="${pageContext.request.contextPath}/login">로그인</a>
		<a href="${pageContext.request.contextPath}/addMember">회원가입</a>
	</c:if>
</body>
</html>
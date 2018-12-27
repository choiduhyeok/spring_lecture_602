<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<sec:authorize access="isAuthenticated()">
	${loginUser.id } 님 환영합니다.
	<button type="button" onclick="logout_go();">Logout</button>
</sec:authorize>

<script>
	function logout_go(){
		location.href="<%=request.getContextPath()%>/commons/logout";
	}
</script>











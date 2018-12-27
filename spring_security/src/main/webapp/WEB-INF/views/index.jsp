<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>인덱스 페이지</title>
<style>
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<sec:authorize access="!isAuthenticated()">
		<button type="button" id="loginBtn" onclick="login_go();">로그인</button>
	</sec:authorize>


	<ul>

		<sec:authorize access="isAuthenticated()">
			<li><a href="<c:url value='/home/main' />">/home/main</a></li>
		</sec:authorize>
		<sec:authorize access="hasAuthority('ROLE_USER')">
			<li><a href="<c:url value='/member/main' />">/member/main</a></li>
		</sec:authorize>
		<sec:authorize access="hasAuthority('ROLE_MANAGER')">
			<li><a href="<c:url value='/manager/main' />">/manager/main</a></li>
		</sec:authorize>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="<c:url value='/admin/main' />">/admin/main</a></li>
		</sec:authorize>
	</ul>

	<sec:authorize access="isAuthenticated()">
		<button type="button" onclick="logout_go();" >Logout</button>		
	</sec:authorize>
	
	<script>
		function login_go(){
			location.href="commons/loginForm";
		}
		function logout_go(){
			location.href="commons/logout";
		}
	</script>
</body>
</html>







<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/commons/login" method="post" >
		아이디 : <input type='text' name ="id" value="${param.id }" /><br/>
		패스워드 : <input type="password" name="pwd" value="${param.pwd }"/><br/>
		<input type="submit" value="로그인" />
	</form>
	
	<c:if test="${!empty msg }">
		<script>
			alert("${msg}");			
		</script>
		<c:remove var="msg" scope="request"/>
	</c:if>


</body>
</html>




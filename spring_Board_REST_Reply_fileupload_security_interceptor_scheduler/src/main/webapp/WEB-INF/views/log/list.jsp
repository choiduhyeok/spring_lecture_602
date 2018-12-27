<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table>
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>이메일</td>
		<td>IP 주소</td>
		<td>날짜</td>	
	</tr>
	<c:forEach items="${logList }" var="log" >
	<tr>
		<td>${log.id}</td>
		<td>${log.name}</td>
		<td>${log.email}</td>
		<td>${log.ip}</td>
		<td><fmt:formatDate value="${log.indate }" pattern="yyyy-MM-dd HH:mm:ss" />
		</td>
	</tr>
	</c:forEach>

</table>




<%--------------------------------------------------------------------------------
	* 화면명 : Smart Editor 2.8 에디터 - 글 작성후 서버전송 처리
	* 파일명 : /board/writePost.jsp
--------------------------------------------------------------------------------%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table border="1">
	<tr>
		<td style="width:80px;">제목</td>
		<td>${board.title }</td>	
		<td style="width:80px;">작성자</td>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td colspan="3" style="width:200px;">${board.content }</td>
	</tr>
	
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="data.DTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginSuccess</title>
<style>
	form {
		display: inline;
	}
	table {
		border: 1px solid black;
	}
	tr:nth-child(even) {
		background-color: #f3ffe2;
	}
	tr:nth-child(odd) {
		background-color: #f0e8ff;
	}
</style>
</head>
<body>
	<div id="wrap">
		<table>
			<%
				request.setCharacterEncoding("utf-8");
				DTO dto = (DTO)request.getAttribute("dto");
			%>
			<tr><th>아이디</th><td><%=dto.getId() %></td></tr>
			<tr><th>이 름</th><td><%=dto.getName() %></td></tr>
			<tr><th>생년월일</th><td><%=dto.getBirth() %></td></tr>
			<tr><th>성 별</th><td><%=dto.getGender() %></td></tr>
			<tr><th>이메일</th><td><%=dto.getEmail() %></td></tr>
			<tr><th>수신동의</th><td><%=dto.getAgreement() %></td></tr>
			</table>
			<form action="/login/view/Modify.jsp" method="post">
				<input type="hidden" name="id" value="<%= dto.getId() %>"><input type="submit" value="회원정보수정">
			</form>
			<form action="/login/Service" method="post">
				<input type="hidden" name="command" value="delete"><input type="hidden" name="id" value="<%= dto.getId() %>"><input type="submit" value="회원탈퇴">	
			</form>
	</div>
</body>
</html>

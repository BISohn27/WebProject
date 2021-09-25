<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Page</title>
<%
	String id = request.getParameter("id");
%>
</head>
<body>
<form action="../Service" method="post">
<input type='hidden' name='id' value=<%=id %>>
<label for="phone">전화번호</label>
<input type="text" id="phone" name="phone" maxlength="15" size="15"><br>
<label for="email">이메일</label>
<input type="text" id="email" name="emailfirst" maxlength="20" size="20">@<input type="text" name="emaillast" maxlength="20" size="20"><br>
<label for="agreement">수신동의</label>
<input type="radio" id="agreement" name="agreement" value="agree">동의<input type="radio" name="agreement" value="disagree">비동의<br>
<input type="submit" value="수정"><input type="reset" value="지우기"><input type="button" name="command" onclick="location.href='login/Service?id=<%=id %>'" value="뒤로가기">
<input type="hidden" name="command" value="modify">
</form>
</body>
</html>
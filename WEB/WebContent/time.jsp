<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		java.util.Date d = new java.util.Date();
		String time = d.toString();
	%>
	<table border"1">
	<tr>
	<td>현재시간은:<%=time%></td>
	</tr>
	</table>
</body>
</html>
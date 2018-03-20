<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="kr.bit.mem.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<!--  1~10까지의 총합을 구하여 출력하시오. -->
<%
	Helper h = new Helper();

%>
<table border="1">
<tr>
<td>1~10까지의 총합은: <%=h.hap() %></td>
</tr>
</table>

</body>
</html>
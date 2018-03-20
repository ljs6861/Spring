<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import=kr.bit.mem.MemberVO %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	body{
		font-size:12px;
	}
</style>
</head>
<body>
<%

	MemberVO vo =(MemberVO) request.getAttribute("vo");
%>


<table border="1">
	<tr>
	<td><%=vo.getNum() %></td>
	<td><%=vo.getIrum() %></td>
	<td><%=vo.getEmail() %></td>
	<td><%=vo.getIntro() %></td>
	</tr>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.bit.mem.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%
	MemberVO vo= new MemberVO();
	vo.setNum(1);
	vo.setIrum("ȫ�浿");
	vo.setAge(30);
	vo.setEmail("ljs6861@naver.com");
	vo.setIntro("�ڱ�Ұ�");
	
	List<MemberVO> list = new ArrayList<MemberVO>();
	list.add(vo);
	list.add(vo);
	list.add(vo);
	request.setAttribute("list",list);
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>��ȣ</td>
		<td>�̸�</td>
		<td>����</td>
		<td>�̸���</td>
		<td>�Ұ�</td>
	</tr>


<c:forEach var="vo" items="${list}">
<tr>
<td>${vo.num}</td>
<td>${vo.irum}</td>
<td>${vo.age}</td>
<td>${vo.email}</td>
<td>${vo.intro}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
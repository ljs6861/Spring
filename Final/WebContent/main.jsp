<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test = "${id!=null }">
		${id}님 방문을 환영합니다.(로그인 성공자만 보입니다.)<br/>
		<a href="sessout.do">로그아웃</a>
	</c:if>
	<c:if test = "${id==null }">
		<c:redirect url="login.html"/>
	</c:if>
</body>
</html>
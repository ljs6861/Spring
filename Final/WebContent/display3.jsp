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
<c:if test="${cookie.id.value!=null}">
	${cookie.id.value} 님 방문을 환영합니다.
	<br/>
	<a href='logout.do'>로그아웃</a>
</c:if>
<c:if test="${cookie.id.value==null}">
	쿠기가 없습니다.
</c:if>
</body>
</html>
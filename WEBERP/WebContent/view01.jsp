<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%!
	public int sum(){
		int hap=0;
		for(int i=1; i<=10; i++){
			hap+=i;
		}
		return hap;
	
}
%>
<%
	int v=sum();
%>
<%-- 1~10까지 출력하는 부분 --%>
<%=v %>

request.
session.
</body>
</html>
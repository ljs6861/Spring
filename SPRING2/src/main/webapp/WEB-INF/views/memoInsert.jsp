<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	body{
		font-size:12px;
	}
</style>
</head>
<body>
	<fieldset style = "width:350px">
		<legend>���� �޸��ۼ�</legend>
		<form action="mInsert.mo" method="post">
		<table>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="mname"/></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type="text" name="mcontent"/></td>
			</tr>
			<tr>
				<td colspan="2" align="left">
					<input type="submit" value="����"/>
					<input type="reset" value="���"/>
				</td>
			</tr>		
		</table>
		</form>
	</fieldset>
</body>
</html>
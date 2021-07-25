<%@page import="com.vocab.api.pojo.Response"%>
<%@page import="java.util.List"%>
<%@page import="com.vocab.api.dao.ResponseDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> <link rel="stylesheet" href="css/my_css.css">
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 10px;
}
</style>
<meta charset="ISO-8859-1">
<title>Response Define</title>
</head>
<body>
	<h1>Response Define</h1>
	<%
		ResponseDao responseDao = new ResponseDao();
		List<Response> list = responseDao.getAll();
	%>
	<table border="1">
		<thead style="background-color: #e3dfde">
			<tr>
				<td><b>Response ID</b></td>
				<td><b>Response Description</b></td>
			</tr>
		</thead>
		<tbody>
			<%
			for(Response item : list) {
				%>	
				<tr>
					<td><%=item.getResponse_id() %></td>
					<td><%=item.getResponse_description() %></td>
				</tr>		
				<%
			}
			%>
		</tbody>
	</table>
	
	<a href="index.html">BACK</a>
</body>
</html>
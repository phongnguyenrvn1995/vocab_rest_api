<%@page import="com.vocab.api.pojo.Status"%>
<%@page import="java.util.List"%>
<%@page import="com.vocab.api.dao.StatusDao"%>
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
<title>Status Define</title>
</head>
<body>
	<h1>Status Define</h1>
	<%
		StatusDao statusDao = new StatusDao();
		List<Status> list = statusDao.getAll("");
	%>
	<table border="1">
		<thead style="background-color: #e3dfde">
			<tr>
				<td><b>Status ID</b></td>
				<td><b>Status Description</b></td>
			</tr>
		</thead>
		<tbody>
			<%
			for(Status item : list) {
				%>
				<tr>
					<td><%=item.getStatus_id()%></td>
					<td><%=item.getStatus_description()%></td>
				</tr>
				
				<%
			}
			%>
		</tbody>
	</table>
	
	<a href="index.html">BACK</a>
</body>
</html>
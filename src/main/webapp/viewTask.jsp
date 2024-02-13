<%@page import="com.ty.entity.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.helper.TaskSorting"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Task Details</h1>
	
	<table border="1">
        <tr>
            <th>Task ID</th>
            <th>Description</th>
            <th>Created Date Time</th>
            <th>Employee ID</th>
            <th>Status</th>
        </tr>
		<tr>
		<% Object o=request.getAttribute("taskList");
		List<Task> tasks = null;
		if(o != null){
			tasks=(List<Task>)o;
		}
		  for(Task task:tasks){ %>
			  <tr>
			  <td><%= task.getId()%></td>
			  <td><%= task.getDescription() %></td>
			  <td><%= task.getCreatedDateTime() %></td>
			  <td><%= task.getEmployee().getId() %></td>
			  <td><%= task.getStatus() %></td>
		<%}
		%>
	</table>
	
	<form action="ManagerDashBoard.jsp"><input type="submit" value="Back" >  </form>
</body>
</html>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.ty.entity.Task"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Employee....</h1>
	<table border="1">
        <tr>
            <th>Task ID</th>
            <th>Description</th>
            <th>Created Date Time</th>
            <th>Status</th>
            <th>Completed</th>
        </tr>
     	
     	<% Object obj=application.getAttribute("TaskList");
     	
     	List<Task> tasks=null;
     	
     	
     	if(obj != null){
     		tasks=(List<Task>)obj;
     	}
     	
     	for(Task t:tasks){ %>
     		<tr>
     		<td><%=t.getId() %></td>
     		<td><%=t.getDescription() %> </td>
     		<td><%=t.getCreatedDateTime() %></td>
     		<td><%=t.getStatus() %></td>
     		<td>
     		
     		<form action="updateList" method="post">
     		<input type="hidden" name="taskid" value="<%=t.getId()%>">
     		<input type="submit"  name="completed" value="Completed">
     		</form>
     		
     		
     		</td>
     		</tr>
     <%}
     	%>
     	   
     </table>
     
     <form action="welcome.jsp" >
     <input type="submit" value="Back">
     </form>
</body>
</html>
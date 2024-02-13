<%@page import="com.ty.entity.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.entity.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Task details</h1>
	<form action="createtask" method="post">
	Task Description: <input type="text" name="description"> <br> <br>
 
	 <label for="employee">Select Employee:</label>
     <select id="employee" name="employee">
     <option value ="0" selected="selected">Select here</option>
	<% List<Employee> elist = EmployeeDao.findAll(); 
	
		for(Employee e:elist){
			String ename=e.getName();
			int id=e.getId();
			%>
			
			<option value="<%=id%>"><%=ename%></option>
			
		<% }%>
	</select>
	<br>
	Task Status :  <input type="radio" id="assigned" name="status" value="assigned">
      <label for="assigned">Assigned</label>

     <input type="radio" id="completed" name="status" value="Completed">
     <label for="completed">Completed</label><br><br>
	<input type="submit" value="Create">
	
	
	</form>
	<form action="ManagerDashBoard.jsp"><input type="submit" value="Back" >  </form>
</body>
</html>
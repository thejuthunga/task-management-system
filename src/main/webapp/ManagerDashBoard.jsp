<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Manager DashBoard</h1>
<button onclick="addtasktotable()">Add Task</button>
<button onclick="viewtask()">View Task</button>
<script type="text/javascript">
function addtasktotable(){
	window.location.href='task.jsp';
}
function viewtask(){
	window.location.href='arrange';
}

</script>
<form action="welcome.jsp" method="post">
<input type="submit" value="Back">
</form>
</body>
</html>
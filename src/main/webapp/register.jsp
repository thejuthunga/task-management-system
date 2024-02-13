<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Enter Your Details</h1>
    <br>
	<form action="register" method="post">
	 User Name:  <input type="text" name="username">
	 <br><br>
	 Email : <input type="text" name="email">
	 <br><br>
	 Password : <input type="password" name="psw">
	 <br><br>
	 
	  Role : <input type="radio" id="employee" name="role" value="employee">
      <label for="employee">Employee</label>

     <input type="radio" id="manager" name="role" value="manager">
     <label for="manager">Manager</label><br><br>
     
	 Designation : <input type="text" name="designation">
	 <br><br>
	 Salary : <input type="number" name="salary">
	 <br><br>
	 <input type="submit" value="SignUp"> 
	 
	 
	 <form action="welcome.jsp"><input type="submit" value="Back"></form>
	</form>
</body>
</html>
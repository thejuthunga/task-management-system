<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
align-content: center;
}
#formone{
border:2px solid black;
border-radius:8px;
padding: 20px;
height: 100px;
width: 300px;
margin-left: 530px;
margin-top:50px;
box-shadow: 0px 0px 5px 5px;
}
#btn1{

width: 100px;
font-size: 15px;
margin-left: 90px;
}
#formtwo{
margin-left: 630px;
}

#btn2{
width: 100px;
font-size: 15px;
margin-left: 5px;
}
</style>
</head>
<body>
<center>
<h1>Welcome To Zimway</h1>
</center>
<form action="login" method="post" id="formone">

Email : <input type="text" name="useremail" required="required"><br><br>
Password : <input type="password" name="password" required="required"><br><br>

<input type="submit" value="Login" id="btn1">
</form>
<br><br>
<form action="register.jsp" id="formtwo">
New User:<input type="submit" value="SignUp"  id="btn2">
</form>


</body>
</html>
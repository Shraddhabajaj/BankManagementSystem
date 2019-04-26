<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
<title>update</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
   table.center {
    width:70%; 
    margin-left:22%; 
    margin-right:15%;
	padding:20%;
  }
  </style>

</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">PayGate</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li ><a href="../adminhome.jsp">Home</a></li>
       <!--  <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../index.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav><br><br>
	<div class="container">
	<form action="updateaccount" method="post">
		<table  class="center">
			<tr rowspan ="3">
				<th>Account Number:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span></td>
				<td><input type="number" name="accNo" value="${ACCOUNT.accNo}" readonly /></td>
			</tr> 
			<tr rowspan="3">
				<th>First Name:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span></td>
				<td><input type="text" name="fName" value="${ACCOUNT.fName}"
					required autofocus /></td>
			</tr>
			<tr rowspan="3">
				<th>Last Name:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span></td>
				<td><input type="text" name="lName" value="${ACCOUNT.lName}" required autofocus /></td>
			</tr>
			<tr rowspan="3">
				<th>Phone Number:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span></td>
				<td><input type="number" name="phone" value="${ACCOUNT.phone}" required
					autofocus /></td>
			</tr>
			<tr rowspan="3">
				<th>Email Id:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span></td>
				<td><input type="email" name="email" value="${ACCOUNT.email}" required
					autofocus /></td>
			</tr>
			<tr rowspan="3">
				<th>Password:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span></td>
				<td><input type="password" name="password" value="${ACCOUNT.password}" required
					autofocus /></td>
			</tr>
			<tr rowspan="3">
				<th>Confirm Password:</th>
				<td><span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span></td>
				<td><input type="password" name="cPassword" value="${ACCOUNT.cPassword}" required
					autofocus /></td>
			</tr>
			
			<tr>
				<th><input type="submit" value="Update"></th>
			</tr>

		</table>
	</form>
	</div>
</body>
</html>
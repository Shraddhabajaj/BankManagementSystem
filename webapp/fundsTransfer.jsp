<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
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
        <li><a href="../home.jsp">Home</a></li>
       <!--  <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../index.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav><br><br>
<h1>Funds Transfer Page</h1>
<form action="fundsTransfer" method="post">
		<table border=2>
		<tr>
				<th>From Account No</th>
				<td><input style="align: left;" type="text" name="fromAccNo"
					required autofocus /></td>
			</tr>
			<tr>
				<th>Enter Payee's Account No</th>
				<td><input style="align: left;" type="text" name="toAccNo"
					required autofocus /></td>
			</tr>
			<tr>
				<th>Transaction Type</th>
				<td><input type="text" name="type" value="Fund Transfer" readonly/></td>
			</tr>
			<tr>
			<th>Enter Amount</th>
			<td><input type="text" name="amount" /></td>
			</tr>
			<tr>
			<th><input type="submit" name="Transfer" value="Transfer" /></th>
			</tr>
        </table>
        </form>
        
</body>
</html>
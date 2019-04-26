<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Home</title>
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
        <li class="active"><a href="#">Home</a></li>
       <!--  <li><a href="#">About</a></li>
        <li><a href="#">Contact</a></li> -->
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="../index.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav><br><br>
<h2 align="center">What are you looking for?</h2><br>
<table id="table1" class="center">
<div class="flipBanner">
<tr><td><div class="product product1">
<a href="../ewallet/add" align="center"><img class="front icon" src="/images/profile.png" alt="New_Account" style="margin-top: 0px; margin-left: 0px; width: 111px; height: 112px;">
<br><br>Create New Account<br><br></a>
</div></td>&nbsp;&nbsp;
<td><div class="product product2">
<a href="../ewallet/modify" align="center"><img class="front icon" src="/images/update.png" alt="Withdraw" style="margin-top: 0px; margin-left: 0px; width: 111px; height: 112px;">
<br><br>Modify Account<br><br></a>
</div></td>&nbsp;&nbsp;
<td><div class="product product3">
<a href="../ewallet/delete" align="center"><img class="front icon" src="/images/delete.png" alt="Deposit" style="margin-top: 0px; margin-left: 0px; width: 111px; height: 112px;">
<br><br>Delete Account<br><br></a>
</div></td></tr>
<tr><td><div class="product product4">
<a href="../ewallet/retrieve" align="center"><img class="front icon" src="/images/balance.png" alt="Fund Transfer" style="margin-top: 0px; margin-left: 0px; width: 111px; height: 112px;">
<br><br>Retrieve By Id<br><br></a>
</div></td>&nbsp;&nbsp;
<td><div class="product product5">
<a href="../ewallet/" align="center"><img class="front icon" src="/images/balance.png" alt="Show Balance" style="margin-top: 0px; margin-left: 0px; width: 111px; height: 112px;">
<br><br>Retrieve All Accounts<br><br></a>
</div></td></tr>
</div>
</table>
</body>
</html>
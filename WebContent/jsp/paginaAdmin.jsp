<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Found It! | PaginaAdmin</title>
		<!--Css document  -->		
		<link rel="stylesheet" href="../style/css/browser.css" type="text/css" />
		<style type="text/css">
				div.container{
					margin-bottom: 0px;			
				}
		</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div id="containerSuperiore">
		<div class="container">
				<div class="sezioneUnoAdmin">
					<h2 align="center">Opzioni</h2>
					<ul id="opzioni">
  						<li><a href="#">Utenti registrati</a></li>
  						<li><a href="#">Utenti Bannati</a></li>
  						<li><a href="#">Società sportive</a></li>
					</ul>
				</div>
				<div  class="sezioneDueAdmin">		
										
				</div>
		</div>
	</div>
	
	
	<%@include file="footer.jsp"%>	
</body>
</html>
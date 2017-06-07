<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="../style/css/browser.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Found It!</title>
<style type="text/css">
	table{
		width: 100%;
		height: auto;
	}
	
	td{ 
		text-align: center;
		padding-bottom: 10px;
	}
	
	form.form-di-ricerca-home{
		text-align: center;
	}
</style>

</head>
<body>
	<%@include file="header.jsp"%>
	
	<div id="containerSuperiore">
		<h1 align="center">Benvenuto in Found It !</h1>
		<h3 align="center">Trova anche tu la struttura sportiva adatta a te con una
			semplice ricerca.</h3>
		<hr></hr>

		<div class="container">
			<form class="form-di-ricerca-home" method="get" action="">
				<div class="container-form-di-ricerca-home">
					<table>
						<tr>
							<td>Quale sport vuoi praticare?</td>
							<td>Dove?</td>
							<td>Quando?</td>
							<td> A che ora?</td>
						</tr>
						<tr>
							<td>
								<select>
									<option value="calcio">calcio</option>
									<option value="calcio a 5">calcio a 5</option>
									<option value="pallavolo">pallavolo</option>
									<option value="basket">basket</option>
								</select>
							</td>
							<td><input id="geocomplete" type="text" size="40" /></td>
							<td><input type="date" size="30"></td>					
							<td>
								<input type="number" name="ora" min="0" max="23">:
								<input type="number" name="minuti" min="0" max="59">
							</td>	
						</tr>
					</table>
				</div>
				<br>
				<br>
				<hr>
				<br>
				<input type="submit" value="cerca!">
			</form>
			<br>
		</div>
	</div> 
	<%@include file="footer.jsp"%>
	
	<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCofJoxoB2qURli3Js_1iUFjixonLuqk-M&sensor=false&amp;libraries=places"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

    <script src="../js/jquery.geocomplete.js"></script>
    <script src="../js/logger.js"></script>
	
	<script>
      $(function(){
        
        $("#geocomplete").geocomplete()
          .bind("geocode:result", function(event, result){
            $.log("Result: " + result.formatted_address);
          })
          .bind("geocode:error", function(event, status){
            $.log("ERROR: " + status);
          })
          .bind("geocode:multiple", function(event, results){
            $.log("Multiple: " + results.length + " results found");
          });
        
        $("#find").click(function(){
          $("#geocomplete").trigger("geocode");
        });        
      });
    </script>
	
</body>
</html>
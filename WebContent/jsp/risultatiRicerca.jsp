<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="../style/css/browser.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Found It! | Risultati Ricerca</title>
	<style type="text/css">
	
		div.elementoDellaRicerca{
			margin-top: 2%;
			padding: 10px;
			border: 1px solid black;
			float: left;
			display: inline;
		}
		input,select.inSideBar{
			margin-top: 5%;
		}
		div.container {
			margin-bottom: 0;
		}
		div#containerSuperiore {
			width: 90%;
		}
		
		div.sideBarDiRicerca{
			padding-top: 2%;
			width: 25%;
			min-height: 100%;
			height: inherit;
			text-align: center;
			float: left;
		}
		
		div.containerRisultati{
			padding: 2%;
			float:left;
			border-left: 1px solid black;
			min-height: 377.266px;
			width: 70%;
		}
	</style>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<div id="containerSuperiore">
		<div class="container">
			<div class="sideBarDiRicerca">
				<label>Quale sport vuoi praticare?</label>
				<select class="inSideBar">	
					<option value="calcio">calcio</option>
					<option value="calcio a 5">calcio a 5</option>
					<option value="pallavolo">pallavolo</option>
					<option value="basket">basket</option>
				</select>
				<hr>
				<label>Dove?</label>
				<input class="inSideBar" id="geocomplete" type="text" size="30" />
				<hr>
				<label>Quando?</label> 
				<br>
				<input class="inSideBar" type="date" size="30">
				<hr>
				<label>A che ora?</label>
				<br> 
				<input class="inSideBar" type="number" name="ora" min="0" max="23">:
				<input class="inSideBar" type="number" name="minuti" min="0" max="59">
				<br><br>
				<input type="submit" value="Effettua nuova ricerca!">
				<br><br>
			</div>
			<div class="containerRisultati">
				
				<div class="elementoDellaRicerca">
					<img alt="fotoCampo" src="../images/userStandard.png" style="height: 100px; width: 100px; float: left;">
					<div class="descrizioneRicerca">
						<h3 align="center">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper nulla tincidunt pharetra efficitur.
						 Fusce ut lectus ut eros venenatis dapibus sed ac ipsum. Phasellus rutrum iaculis molestie. Maecenas varius
						  erat a neque ultrices, at vestibulum diam feugiat. Vestibulum neque lectus, tristique quis posuere eget,
						   blandit ut ante. Suspendisse tincidunt urna ut neque scelerisque pharetra. Vivamus dictum velit ante, in
						    euismod mi aliquet ut. Morbi nibh magna, lobortis vel neque venenatis, porta maximus ante. Phasellus 
						    condimentum porttitor dapibus. Duis auctor faucibus tellus, quis viverra justo ultrices maximus. Maecenas
						     vel lorem eu lorem gravida venenatis ut quis turpis. Morbi a condimentum neque. Vivamus sed porta mi.
						      Fusce iaculis nibh et massa vulputate vulputate.</p>
						<input type="submit" value="Prenota!" style="float: right;">
					</div>
				</div>
				
				<div class="elementoDellaRicerca">
					<img alt="fotoCampo" src="../images/userStandard.png" style="height: 100px; width: 100px; float: left;">
					<div class="descrizioneRicerca">
						<h3 align="center">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper nulla tincidunt pharetra efficitur.
						 Fusce ut lectus ut eros venenatis dapibus sed ac ipsum. Phasellus rutrum iaculis molestie. Maecenas varius
						  erat a neque ultrices, at vestibulum diam feugiat. Vestibulum neque lectus, tristique quis posuere eget,
						   blandit ut ante. Suspendisse tincidunt urna ut neque scelerisque pharetra. Vivamus dictum velit ante, in
						    euismod mi aliquet ut. Morbi nibh magna, lobortis vel neque venenatis, porta maximus ante. Phasellus 
						    condimentum porttitor dapibus. Duis auctor faucibus tellus, quis viverra justo ultrices maximus. Maecenas
						     vel lorem eu lorem gravida venenatis ut quis turpis. Morbi a condimentum neque. Vivamus sed porta mi.
						      Fusce iaculis nibh et massa vulputate vulputate.</p>
						<input type="submit" value="Prenota!" style="float: right;">
					</div>
				</div>
				
				<div class="elementoDellaRicerca">
					<img alt="fotoCampo" src="../images/userStandard.png" style="height: 100px; width: 100px; float: left;">
					<div class="descrizioneRicerca">
						<h3 align="center">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris semper nulla tincidunt pharetra efficitur.
						 Fusce ut lectus ut eros venenatis dapibus sed ac ipsum. Phasellus rutrum iaculis molestie. Maecenas varius
						  erat a neque ultrices, at vestibulum diam feugiat. Vestibulum neque lectus, tristique quis posuere eget,
						   blandit ut ante. Suspendisse tincidunt urna ut neque scelerisque pharetra. Vivamus dictum velit ante, in
						    euismod mi aliquet ut. Morbi nibh magna, lobortis vel neque venenatis, porta maximus ante. Phasellus 
						    condimentum porttitor dapibus. Duis auctor faucibus tellus, quis viverra justo ultrices maximus. Maecenas
						     vel lorem eu lorem gravida venenatis ut quis turpis. Morbi a condimentum neque. Vivamus sed porta mi.
						      Fusce iaculis nibh et massa vulputate vulputate.</p>
						<input type="submit" value="Prenota!" style="float: right;">
					</div>
				</div>
			</div>
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
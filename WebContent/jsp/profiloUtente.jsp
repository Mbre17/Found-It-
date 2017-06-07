<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
		
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
	<title>Found It! | Profilo Utente</title>
		
	<!--Css document  -->		
	<link rel="stylesheet" href="../style/css/browser.css" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>	
	<div id="containerSuperiore">
		<div class="top">
			<h2><center>PROFILO UTENTE</center></h2>
		</div>
	<hr>
	<div class="container ">
		<br><br><br>	
		<div class="image-box">
			<center><b>Nome Utente</b></center>
			<br>
            <img src="../images/userStandard.png" id="user" alt="fotoUser">
            <br>
            <button type="submit" id="submit" name="submit">Cambia immagine del profilo</button>
 			<br><br>
 		</div>
 	<center>
 	<section>                  
		<ul id="tabs">
    		<li><a href="#tab1">Dati Personali</a></li>
     	   	<li><a href="#tab2">Dati Profilo</a></li>
    		<li><a href="#tab3">Privacy e Sicurezza</a></li>
		</ul>
 		<div id="containerTab">
    		<div class="content">
       			<a name="tab1" id="tab1"></a>
        		<h2>Dati Personali</h2>
        		<hr>
        		<div class="allineasinistra">
        			<section style="width: 50%;">
        				<label class="registra">Nome</label>
        				<div class="displayTab">
							<input id="nome" type="text" name="nome"> 
							<button type="submit" id="submit" name="submit">Cambia</button>
						</div>
						<label class="registra">Cognome</label>
						<div class="displayTab">	
							<input id="cogname" type="text" name="cognome">
				 			<button type="submit" id="submit" name="submit">Cambia</button>
						</div>
			
						<label class="registra">Città</label>
						<div class="displayTab"> 
							<input id="città" type="text" name="città">
							<button type="submit" id="submit" name="submit">Cambia</button>
						</div>
					</section>
							
					<section style="width: 50%;">
						<label class="registra">Provincia</label> 
						<div class="displayTab">	
							<input  id="provincia" type="text" name="provincia">
							<button type="submit" id="submit" name="submit">Cambia</button>
						</div>
					
						<label  class="registra">Cap</label>
						<div class="displayTab">
							<input id="cap" type="text" name="cap">
							<button type="submit" id="submit" name="submit">Cambia</button>
						</div>
					
						<label class="registra">Telefono</label>
						<div class="displayTab">
							<input id="telefono" type="text" name="telefono">
							<button type="submit" id="submit" name="submit">Cambia</button>
	 					</div>
					</section>			
        		</div>
    		</div> 		
      </section>
	 </center>
    		<div class="content">
        		<a name="tab2" id="tab2"></a>
        		<h2>Dati Profilo</h2>
				<hr>
				        	
        		<label class="registra">Nome</label>
        		<div class="displayTab">
					<input id="nome" type="text" name="nome"> 
					<button type="submit" id="submit" name="submit">Cambia</button>
				</div>
				
				<label class="registra">Cognome</label>
				<div class="displayTab">	
					<input id="cogname" type="text" name="cognome">
				 	<button type="submit" id="submit" name="submit">Cambia</button>
				</div>
			
				<label class="registra">Città</label>
				<div class="displayTab"> 
					<input id="città" type="text" name="città">
					<button type="submit" id="submit" name="submit">Cambia</button>
				</div>
     		</div>
    			
    		<div class="content">
        		<a name="tab3" id="tab3"></a>
        		<h2>Privacy e Sicurezza</h2>
        		<p>uffa</p>
    		</div>
		</div>
	</div>	
	</div>

	<%@include file="footer.jsp"%>	
</body>
</html>
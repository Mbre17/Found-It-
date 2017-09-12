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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/style/css/browser.css" type="text/css" />
	<style type="text/css">
		div.displayTab label.registra {
			min-width: 100px;
		}
		div.displayTab label.datiprofilo {
			min-width: 200px;
			font-weight: bold;
			
			
		}
	</style>
</head>
<body>
	<%@include file="header.jsp"%>	
	<%if(utente == null || utente.getUsername() == null){
		    ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/jsp/home.jsp");
			String message = "Effettuare il login prima di accedere al profilo utente!";
			request.getSession().setAttribute("message", message);
			rd.forward(request, response);
	   };
	%>
	
	<div id="containerSuperiore">
		<div class="top">
			<h2><center> PROFILO <label style="text-transform: uppercase;"><%=utente.getTipo() %></label></center></h2>
		</div>
		<hr>
		<div class="container ">
			<br><br><br>	
			<div class="image-box">
				<center><b> <%=utente.getNome()%> <%=utente.getCognome()%></b> </center>
				<br>
            	<img src="<%=request.getContextPath()%>/images/userStandard.png" id="user" alt="fotoUser">
            	<br>
            	<button type="submit" id="submit" name="submit">Cambia immagine del profilo</button>
 				<br><br>
 			</div>
 			
 		<div class="tabContainer">	
 			<div class="tab">
  				<button style="width:33.33%;" class="tablinks" onclick="openCity(event, 'Dati Personali')" id="defaultOpen">Dati Personali</button>
  				<button style="width:33.33%; border-left:1px solid black; border-right:1px solid black;" class="tablinks" onclick="openCity(event, 'Dati Profilo')">Dati Profilo</button>
  				<button style="width:33.33%;" class="tablinks" onclick="openCity(event, 'Privacy e Sicurezza')">Privacy e Sicurezza</button>
			</div>

			<div align="center" id="Dati Personali" class="tabcontent">
			<h2>Dati Personali</h2>
  				<div class="allineasinistra">
  				<form name="datiPersonali" action="<%=request.getContextPath()%>/ProfiloController" method="POST" onsubmit="return validateDatiPersonali()">
        			<section style="width: 50%;">
        				<div class="displayTab">
							<label class="registra">Nome</label>						
							<input id="nome" type="text" name="nome" value="<%= utente.getNome() %>"> 
						</div>
						
						<div class="displayTab">
							<label class="registra">Cognome</label>	
							<input id="cognome" type="text" name="cognome" value="<%= utente.getCognome() %>">
						</div>
			
						<div class="displayTab"> 
							<label class="registra">Città</label>
							<input id="citta" type="text" name="citta" value="<%= utente.getcitta() %>">
						</div>
					</section>
							
					<section style="width: 50%;">
												 
						<div class="displayTab">	
							<label class="registra">Provincia</label>
							<input  id="provincia" type="text" name="provincia" value="<%= utente.getProvincia() %>">
						</div>
											
						<div class="displayTab">
							<label  class="registra">Cap</label>
							<input id="cap" type="text" name="cap" value="<%= utente.getCap() %>">
						</div>
											
						<div class="displayTab">
							<label class="registra">Telefono</label>
							<input id="telefono" type="text" name="telefono" value="<%= utente.getTelefono() %>">
	 					</div>
					</section>	
					<br><br>
					<button type="submit" id="cambiaDatiProfilo" name="cambiaDatiPersonali">Cambia</button>
					<br><br><br>	
					</form>	
        		</div>    		
			</div>

			<div align="center" id="Dati Profilo" class="tabcontent">
  				<h2>Dati Profilo</h2>
  				
  				<div style="width: 50%; margin-left: auto; margin-right: auto;">
  					<form name="datiProfilo" action="<%=request.getContextPath()%>/DatiProfiloController" method="POST" onsubmit="return validateDatiProfilo()">
  					<div class="displayTab">
						<label  class="datiprofilo">Username</label>
				 		<input id="username" type="text" name="username" readonly="readonly" value="<%= utente.getUsername() %>"> 
					</div>
				
					<div class="displayTab">
						<label  class="datiprofilo">Password</label>
				 		<input	id="password" type="password" name="password" value="<%= utente.getPassword() %>">	 
					</div>
					
					<div class="displayTab">
						<label  class="datiprofilo">Conferma password</label>
				 		<input	id="confpassword" type="password" name="confpassword" value="<%= utente.getPassword() %>">	 
					</div>
				
					<div class="displayTab">
						<label  class="datiprofilo">Email<span style="color: #FF0000">*</span></label>
				 		<input id="email" type="email" name="email" value="<%= utente.getEmail() %>">				 
   					</div>
   					<br><br>
					<button style="width:40%; margin-left:20%;" type="submit" id="cambiaDatiProfilo" name="cambiaDatiProfilo">Cambia</button>
					<br><br><br>
					</form>
   				</div>
   				
			</div>

			<div id="Privacy e Sicurezza" class="tabcontent">
  				<h2>Privacy e Sicurezza</h2>   
  				<h3>Informativa sul trattamento dei dati personali</h3>
  				<p>Found It rispetta e tutela la privacy dei propri utenti.<br>Al fine di rafforzare la fiducia dei nostri utenti, ed anche ai sensi dell&rsquo;art. 13 del Codice della Privacy (d.lgs. 196 del 30 giugno 2003), forniamo l&rsquo;informativa relativa al trattamento dei dati personali eventualmente forniti dagli utenti che interagiscono con i servizi web di Found It<br>
     				La presente informativa &egrave; relativa esclusivamente all&rsquo; eventuale trattamento di suoi dati personali da Lei comunicati o altrimenti ottenuti da Found It! per effetto del Suo utilizzo del Sito. Specifiche informative di privacy verranno riportate o visualizzate nelle pagine del sito predisposte alla fornitura di particolari servizi a richiesta.
  				</p>
			</div>
 		</div>
	</div>	
</div>

	<%@include file="footer.jsp"%>
	<script type="text/javascript" src ="<%=request.getContextPath()%>/js/testRegistrazione.js"></script>
	
	<script>
		function openCity(evt, cityName) {
    		var i, tabcontent, tablinks;
    		tabcontent = document.getElementsByClassName("tabcontent");
    		for (i = 0; i < tabcontent.length; i++) {
        		tabcontent[i].style.display = "none";
   		 	}
    		tablinks = document.getElementsByClassName("tablinks");
    		for (i = 0; i < tablinks.length; i++) {
        		tablinks[i].className = tablinks[i].className.replace(" active", "");
    		}
    		document.getElementById(cityName).style.display = "block";
    		evt.currentTarget.className += " active";
		}
		
		document.getElementById("defaultOpen").click();
		
		function validateDatiPersonali(){
			var nome = document.datiPersonali.nome.value;
			var cognome = document.datiPersonali.cognome.value;
			var citta = document.datiPersonali.citta.value;
			var provincia = document.datiPersonali.provincia.value;
			var cap = document.datiPersonali.cap.value;
			var telefono = document.datiPersonali.telefono.value;
			
			if (isEmpty(nome,"nome")){
				return false;
			}
			if (!isAValidString(nome,regex.nome,"nome")){
				return false;
			}
			if (isEmpty(cognome,"cognome")){
				return false;
			}
			if (!isAValidString(cognome,regex.cognome,"cognome")){
				return false;
			}
			if (isEmpty(citta,"citta")){
				return false;
			}
			if (!isAValidString(citta,regex.citta,"citta")){
				return false;
			}
			if (isEmpty(provincia,"provincia")){
				return false;
			}
			if (!isAValidString(provincia,regex.provincia,"provincia")){
				return false;
			}
			if (isEmpty(cap,"cap")){
				return false;
			}
			if (!isAValidString(cap,regex.cap,"cap")){
				return false;
			}
			if (isEmpty(telefono,"telefono")){
				return false;
			}
			if (!isAValidString(telefono,regex.telefono,"telefono")){
				return false;
			}
			return true;
		}
		
		function validateDatiProfilo(){
			var password = document.datiProfilo.password.value;
			var confpassword = document.datiProfilo.confpassword.value;
			var email = document.datiProfilo.email.value;
			
			if (isEmpty(password,"password")){
				return false;
			}
			if (!isAValidString(password,regex.password,"password")){
				return false;
			}
			if (isEmpty(confpassword,"confpassword")){
				return false;
			}
			if (!(confpassword == password)){
				alert("Errore: I campi password e conferma password devono corrispondere!")
				return false;
			}
			if (isEmpty(email,"email")){
				return false;
			}
			if (!isAValidString(email,regex.email,"email")){
				return false;
			}
		
			return true;
		}
	</script>
     	
</body>
</html>
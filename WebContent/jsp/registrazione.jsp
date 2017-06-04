<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>Found It! | Registrazione</title>
		
		<!--Css document  -->
		<link rel="stylesheet" href="../style/css/font-awesome.css" type="text/css" />
		
		<link rel="stylesheet" href="../style/css/browser.css" type="text/css" />
		
</head>
<body>

	<%@include file="header.jsp"%>	
	<form id="containerSuperiore" method="POST">
		<div class="top">
				<h2><center>REGISTRAZIONE</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
		<div class="container">
			
			<section>
				<div class="formelement">
					<label  class="registra">Nome<span style="color: #FF0000">*</span></label>
					<input class="campi" id="nome" type="text" name="nome">
                	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Cognome<span style="color: #FF0000">*</span></label>
				 	<input class="campi" id="cogname" type="text" name="cognome">
				 	<i class="fa fa-user"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Città<span style="color: #FF0000">*</span></label> 
					<input class="campi" id="città" type="text" name="città">
					<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Provincia<span style="color: #FF0000">*</span></label> 
						<select
								class="campi" name="activityProvince" id="activityProvince">
								<%@include file="province.jsp" %>
						</select>
					<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Cap<span style="color: #FF0000">*</span></label>
					<input class="campi" id="cap" type="text" name="cap"  placeholder="80035">
				 	<i class="fa fa-user"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Telefono<span style="color: #FF0000">*</span></label>
				 	<input class="campi" id="telefono" type="text" name="telefono"  placeholder="0811234567">
				 	<i class="fa fa-phone"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Email<span style="color: #FF0000">*</span></label>
				 	<input class="campi" id="email" type="email" name="email" placeholder="name@exemple.com">
                    <i class="fa fa-envelope"></i>				 
   				</div>

				<div class="formelement">
					<label  class="registra">Usurname<span style="color: #FF0000">*</span></label>
				 	<input class="campi" id="usurname" type="text" name="usurname">
				 	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Password<span style="color: #FF0000">*</span></label>
				 	<input	class="campi" id="password" type="password" name="password">
				 	<i class="fa fa-lock"></i>	 
				</div>

				<div class="formelement">
					<label  class="registra" for="password">Conferma password<span style="color: #FF0000">*</span></label>
					<input class="campi" id="password" type="password" name="password">
				 	<i class="fa fa-lock"></i>
				</div>
				<br>
			
				<div class="formelement">
					<label  class="registra">Possiedi campi sportivi?<span style="color: #FF0000">*</span></label>
					<input type="radio" name="possiedicampisportivi" value="si">si
					<input type=radio name="possiedicampisportivi" value="no">no
				</div>

	</section>
			
	<section>
			<div class="image-box">
				<b>Immagine personale</b>
				<br>
             	<img src="../images/userStandard.png" id="user" alt="fotoUser">
             	<br>
             	<br>
             	<button type="submit" id="submit" name="submit">Carica immagine del profilo</button>
            </div>
	</section>
						
		</div>
		
			<div style="text-align:center;">
			<button class="buttonreg" type="submit" id="submit" name="submit"><b>Registrati</b></button>
			</div>
		
			<div style="text-align: left; padding-left: 0.8%;">
			I campi con <span style="color: #FF0000">*</span> sono obbligatori
	   		</div>
	    
	</form>
	<%@include file="footer.jsp"%>	
</body>
</html>
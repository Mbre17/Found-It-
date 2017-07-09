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
		<link rel="stylesheet" href="style/css/font-awesome.css" type="text/css" />
		
		<link rel="stylesheet" href="style/css/browser.css" type="text/css" />
		 

		<style>
			.alert {
   				padding: 20px;
   	 			background-color: #f44336;
    			color: white;
    			display:none;
			}

			.closebtn {
    			margin-left: 15px;
    			color: white;
   			 	font-weight: bold;
    			float: right;
    			font-size: 22px;
    			line-height: 20px;
    			cursor: pointer;
    			transition: 0.3s;
			}

			.closebtn:hover {
    			color: black;
			}
</style>
		
</head>
<body>
	<% String error = (String)request.getAttribute("error"); %>

	<%@include file="jsp/header.jsp"%>	
	<form name="registrazione" id="containerSuperiore" action="RegistrationController" method="POST" onsubmit="return validateForm()">
		<div class="top">
				<h2><center>REGISTRAZIONE</center></h2>
		</div>
		<hr style= "margin-left:1%; margin-right:1%">
		<div class="container">
			
			<section>
				<div class="formelement">
					<label  class="registra">Nome<span style="color: #FF0000">*</span></label>
					<input class="campi" type="text" name="nome">
                	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Cognome<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="cognome">
				 	<i class="fa fa-user"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Citta<span style="color: #FF0000">*</span></label> 
					<input class="campi" type="text" name="citta">
					<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Provincia<span style="color: #FF0000">*</span></label> 
						<select
								class="campi" name="activityProvince">
								<%@include file="jsp/province.jsp" %>
						</select>
					<i class="fa fa-map-marker"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Cap<span style="color: #FF0000">*</span></label>
					<input class="campi" type="text" name="cap"  placeholder="80035">
				 	<i class="fa fa-user"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Telefono<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="telefono"  placeholder="0811234567">
				 	<i class="fa fa-phone"></i>
				</div>

				<div class="formelement">
					<label  class="registra">Email<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="email" name="email" placeholder="name@exemple.com">
                    <i class="fa fa-envelope"></i>				 
   				</div>

				<div class="formelement">
					<label  class="registra">Username<span style="color: #FF0000">*</span></label>
				 	<input class="campi" type="text" name="username">
				 	<i class="fa fa-user"></i> 
				</div>

				<div class="formelement">
					<label  class="registra">Password<span style="color: #FF0000">*</span></label>
				 	<input	class="campi" type="password" name="password">
				 	<i class="fa fa-lock"></i>	 
				</div>

				<div class="formelement">
					<label  class="registra" for="password">Conferma password<span style="color: #FF0000">*</span></label>
					<input class="campi" type="password" name="confpassword">
				 	<i class="fa fa-lock"></i>
				</div>
				<br>
			
				<div class="formelement">
					<label  class="registra">Possiedi campi sportivi?<span style="color: #FF0000">*</span></label>
					<input type="radio" name="possiedicampisportivi" value="si" id="si">si
					<input type=radio name="possiedicampisportivi" value="no" id="no">no
				</div>

	</section>
			
	<section>
			<div class="image-box">
				<b>Immagine personale</b>
				<br>
             	<img src="../images/userStandard.png" id="user" alt="fotoUser">
             	<br>
             	<br>
             	<!--<button type="submit" name="submit">Carica immagine del profilo</button>-->
            </div>
	</section>
						
		</div>
		
			
			<% if(error != null && !error.equals("")) { %>	
			<p><br><br><br><%=error %>
			<% } %>	
			
			<div style="text-align:center;">
			<button class="buttonreg" type="submit" name="submit"><b>Registrati</b></button>
			</div>
			
		
			<div style="text-align: left; padding-left: 0.8%;">
			I campi con <span style="color: #FF0000">*</span> sono obbligatori
	   		</div>
	</form>
	
	<script src ="<%=request.getContextPath()%>/js/testRegistrazione.js"></script>
	<%@include file="jsp/footer.jsp"%>	
	
</body>
</html>
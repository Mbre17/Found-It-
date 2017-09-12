<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
					<!-- Import external css file -->
	<link href="<%=request.getContextPath()%>/style/css/browser.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/style/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/style/css/style.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script src="<%=request.getContextPath()%>/js/login.js"></script></head>
</head>
<body onload="showMessage()">
	<%@page import="model.UtenteBean"%>
	<% UtenteBean utente= (UtenteBean) request.getSession().getAttribute("login");%>
	<header>
		<div class="logo">
			<a href="<%=request.getContextPath()%>/jsp/home.jsp"">
				<img alt="logo sito" src="<%=request.getContextPath()%>/images/logoFoundIt!.png" height="80px" width="180px">
			</a>
		</div>
		<% if(utente==null || utente.getUsername()==null){  %>
		<div class="menu" id="MenuResponsive" >
			<nav>
				<ul>
					<li>
					<div id="loginContainer">
                <a href="#" id="loginButton"><i class="fa fa-sign-in" aria-hidden="true"> Login</i></a>
                <div style="clear:both"></div>
                <div id="loginBox">                
                    <form id="loginForm" action="../LoginController" method="post">
                        <fieldset id="body">
                            <fieldset>
                                <label for="email">Username</label>
                                <input type="text" name="username" id="username" />
                            </fieldset>
                            <fieldset>
                                <label for="password">Password</label>
                                <input type="password" name="password" id="password" />
                            </fieldset>
                            <input type="submit" id="login" value="Entra" />
                            <label for="checkbox"><input type="checkbox" id="checkbox" />Ricordami</label>
                        </fieldset>
                        <span><a href="<%=request.getContextPath()%>/jsp/recuperoPassword.jsp">Hai dimenticato la password?</a></span>
                    </form>
                </div>
            </div>
					</li>
					<li><a href="<%=request.getContextPath()%>/jsp/registrazione.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a></li>
					<li><a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="responsiveFunction()">&#9776;</a></li>
				</ul>
			</nav>
		</div>	
		<% }else{ %>
		<div class="menu" id="MenuResponsive" >
			<nav>
				<ul>
					<li>
						<div id="loginContainer">
               				<a href="<%=request.getContextPath()%>/LogoutController" id="logoutButton"><i class="fa fa-sign-out" aria-hidden="true"> Logout</i></a>
                			<div style="clear:both"></div>
           				</div>
					</li>
					<li><a href="<%=request.getContextPath()%>/jsp/profiloUtente.jsp"><i class="fa fa-user" aria-hidden="true"></i> <%=utente.getUsername()%></a></li>
					<% if(utente.getTipo().equals("admin")){%>
					<li><a href="<%=request.getContextPath()%>/jsp/paginaAdmin.jsp"><i class="fa fa-info-circle" aria-hidden="true"></i> Opzioni Amministratore</a></li>
					<%}%>
					<li><a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="responsiveFunction()">&#9776;</a></li>
				</ul>
			</nav>
		</div>	
		<% } %>
		
		
		
	</header>
	
	<script>
		function showMessage() {
	    // Get the snackbar DIV
	    	var x = document.getElementById("snackbar")

	    // Add the "show" class to DIV
	    	x.className = "show";

	    // After 3 seconds, remove the show class from DIV
	    	setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
		}
		function responsiveFunction(){
    		var x = document.getElementById("MenuResponsive");
    		if (x.className === "menu") {
        		x.className += " responsive";
    		} else {
        		x.className = "menu";
    		}
		}
	</script>
	<div id="snackbar"><%= request.getSession().getAttribute("message")%></div>	
</body>
</html>
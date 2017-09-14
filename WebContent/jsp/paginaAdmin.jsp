<%
// Check user credentials
Boolean adminRoles = (Boolean) session.getAttribute("adminRoles");
if ((adminRoles == null) || (!adminRoles.booleanValue()))
{	
    response.sendRedirect("/jsp/home.jsp");
    return;
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*,model.UtenteModel,model.UtenteModelDM"%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Found It! | PaginaAdmin</title>
		<!--Css document  -->		
		<link rel="stylesheet" href="../style/css/browser.css" type="text/css" />
		<style type="text/css">
				* {box-sizing: border-box}
				body {font-family: "Lato", sans-serif;}

				/* Style the tab */
			div.Tab {
    				float: left;
    				border: 1px solid #ccc;
    				background-color: #f1f1f1;
    				width: 20%;
    				height: 300px;
			}

		/* Style the buttons inside the tab */
			div.Tab button {
    			display: block;
    			background-color: inherit;
    			color: black;
    			padding: 22px 16px;
    			width: 100%;
    			border: none;
    			outline: none;
    			text-align: left;
    			cursor: pointer;
    			transition: 0.3s;
   	 			font-size: 17px;
			}

		/* Change background color of buttons on hover */
			div.Tab button:hover {
    			background-color: #ddd;
			}

		/* Create an active/current "tab button" class */
			div.Tab button.active {
    			background-color: #ccc;
			}

		/* Style the tab content */
			.tabContent {
    		float: left;
    		padding: 0px 12px;
    		border: 1px solid #ccc;
    		width: 50%;
    		border-left: none;
    		height: 300px;
		}
</style>
		
</head>
<body>
	<%@include file="header.jsp"%>
	<%if(utente == null || utente.getUsername() == null || !(utente.getTipo().equals("admin"))){
		    ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/jsp/home.jsp");
			String message = "Pagina protetta, effettuare il login come admin!";
			request.getSession().setAttribute("message", message);
			rd.forward(request, response);
	   };
	%>
	<div id="containerSuperiore">
		<div class="top">
			<h2><center> OPZIONI AMMINISTRATORE</center></h2>
		</div>
		<div class="container">
				
					<div class="Tab">
  						<button class="tabLinks" onclick="openCity(event, 'UtentiRegistrati')" id="defaultOpen">Utenti registrati</button>
  						<button class="tabLinks" onclick="openCity(event, 'UtentiBannati')">Utenti Bannati</button>
  						<button class="tabLinks" onclick="openCity(event, 'SocietaSportiva')">Società sportive</button>
					</div>

			<div id="UtentiRegistrati" class="tabContent">
  				<h3><center>Utenti Registrati</center></h3>
  				<p><% 	final UtenteModel model= new UtenteModelDM();
  				Collection<UtenteBean> utenti= model.doRetrieveAll("nome"); %>
  				</p>
  				<table>
		<tr>
			<th>Nome </th>
			<th>Cognome </th>
			<th>Username </th>
			
			
		</tr>
		<%
			if ( utenti != null && utenti.size() != 0) {
				Iterator<?> it = utenti.iterator();
				while (it.hasNext()) {
					UtenteBean bean = (UtenteBean) it.next();
		%>
		<tr>
			<% if(bean.getTipo().equals("utente")){ %>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getCognome()%></td>
			<td><%=bean.getUsername()%></td>
			
			<%} %>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="4">Non ci sono utenti registrati!</td>
		</tr>
		<%
			}
		%>
	</table>
	
			</div>

			<div id="UtentiBannati" class="tabContent">
  			<h3><center>Utenti Bannati</center></h3>
  			<table>
  				<tr>
			<th>Nome </th>
			<th>Cognome </th>
			<th>Username </th>
			
		</tr>
		<%
			if ( utenti != null && utenti.size() != 0) {
				Iterator<?> it = utenti.iterator();
				while (it.hasNext()) {
					UtenteBean bean = (UtenteBean) it.next();
		%>
		<tr>
			<% if(bean.getTipo().equals("bannato")){ %>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getCognome()%></td>
			<td><%=bean.getUsername()%></td>
			
			<%} %>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="4">Non ci sono utenti bannati!</td>
		</tr>
		<%
			}
		%>
	</table> 
			</div>

			<div id="SocietaSportiva" class="tabContent">
  			<h3><center>Società Sportiva</center></h3>
  			<table>
  				<tr>
			<th>Nome </th>
			<th>Cognome </th>
			<th>Username </th>
			
		</tr>
		<%
			if ( utenti != null && utenti.size() != 0) {
				Iterator<?> it = utenti.iterator();
				while (it.hasNext()) {
					UtenteBean bean = (UtenteBean) it.next();
		%>
		<tr>
			<% if(bean.getTipo().equals("partner sportivo")){ %>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getCognome()%></td>
			<td><%=bean.getUsername()%></td>
			
			<%} %>
		</tr>
		<%
				}
			} else {
		%>
		<tr>
			<td colspan="4">Non ci sono partner sportivi registrati!</td>
		</tr>
		<%
			}
		%>
	</table>
			</div>
					
		</div>
		</div>
	</div>
	
	
	<%@include file="footer.jsp"%>	
<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabContent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tabLinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>

</body>
</html>
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
<body>
	<header>
		<div class="logo">
			<a href="#">
				<img alt="logo sito" src="<%=request.getContextPath()%>/images/logoFoundIt!.png" height="80px" width="180px">
			</a>
		</div>
		<div class="menu" id="MenuResponsive" >
			<nav>
				<ul>
					<li>
					<div id="loginContainer">
                <a href="#" id="loginButton"><i class="fa fa-sign-in" aria-hidden="true"></i>Login</a>
                <div style="clear:both"></div>
                <div id="loginBox">                
                    <form id="loginForm">
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
                        <span><a href="#">Hai dimenticato la password?</a></span>
                    </form>
                </div>
            </div>
					</li>
					<li><a href="<%=request.getContextPath()%>/registrazione.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i> Register</a></li>
					<li><a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="responsiveFunction()">&#9776;</a></li>
				</ul>
			</nav>
		</div>	
	</header>
	
	<script>
		function responsiveFunction(){
    		var x = document.getElementById("MenuResponsive");
    		if (x.className === "menu") {
        		x.className += " responsive";
    		} else {
        		x.className = "menu";
    		}
		}
	</script>
</body>
</html>
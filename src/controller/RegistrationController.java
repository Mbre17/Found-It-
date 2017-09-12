package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;
import util.ValidationUtil;
/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  UtenteModel model = new UtenteModelDM();

    public RegistrationController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UtenteBean utente = new UtenteBean();
		
		// Copio tutti i parametri di input nelle variabili locali
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("activityProvince");
		String cap = request.getParameter("cap");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confpassword= request.getParameter("confpassword");
		String possiediCampiSportivi = request.getParameter("possiedicampisportivi");
		
		if( ValidationUtil.isEmpty(nome) || !ValidationUtil.isAValidString(nome,ValidationUtil.REGEX_NOME)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: nome non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(cognome) || !ValidationUtil.isAValidString(cognome,ValidationUtil.REGEX_GENERALE)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: cognome non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(citta) || !ValidationUtil.isAValidString(citta,ValidationUtil.REGEX_GENERALE)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: citta' non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(provincia) || !ValidationUtil.isAValidString(provincia,ValidationUtil.REGEX_GENERALE)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: provincia non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(cap) || !ValidationUtil.isAValidString(cap,ValidationUtil.REGEX_CAP)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: cap non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(telefono) || !ValidationUtil.isAValidString(telefono,ValidationUtil.REGEX_TELEFONO)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: telefono non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(email) || !ValidationUtil.isAValidString(email,ValidationUtil.REGEX_EMAIL)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: email non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		    
		    //controllare se esiste già questa email associata ad un altro account
		}
		 if( ValidationUtil.isEmpty(username) || !ValidationUtil.isAValidString(username,ValidationUtil.REGEX_USERNAME)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: username non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(password) || !ValidationUtil.isAValidString(password,ValidationUtil.REGEX_PASSWORD)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: password non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if(!confpassword.equals(password)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: I campi password e conferma password devono corrispondere!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		 if(possiediCampiSportivi == null){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: Devi dichiarare se possiedi o meno un campo sportivo!');");
		    out.println("location='"+request.getContextPath()+"/registrazione.jsp';");
		    out.println("</script>");
		}
		
		
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setcitta(citta);
		utente.setProvincia(provincia);
		utente.setCap(Integer.parseInt(cap));
		utente.setTelefono(telefono);
		utente.setEmail(email);
		utente.setUsername(username);
		String cryptedPassword = toSHA1(password.getBytes());
		utente.setPassword(cryptedPassword);
		if(possiediCampiSportivi.equals("no")){
			utente.setTipo("utente");
		}
		else if(possiediCampiSportivi.equals("si")){
			utente.setTipo("partner sportivo");
		}
		
		try{
		
			model.doSave(utente);
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		String redirectedPage = "/jsp/home.jsp";
		response.sendRedirect(request.getContextPath() + redirectedPage);
	
	}
	
	/**
	 * Encrypt data into String type
	 * @param convertme array of bytes to be encrypt
	 * @return encrypted bytes
	 */
	public static String toSHA1(byte[] convertme) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new String(md.digest(convertme));
	}
}
 

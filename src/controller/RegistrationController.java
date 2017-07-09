package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UtenteModel;
import model.UtenteBean;
/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  UtenteModel model;

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
		String città = request.getParameter("città");
		String provincia = request.getParameter("activityProvince");
		String cap = request.getParameter("cap");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confpassword= request.getParameter("confpassword");
		String possiediCampiSportivi = request.getParameter("possiedicampisportivi");
		
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setCittà(città);
		utente.setProvincia(provincia);
		int CAP = Integer.parseInt(cap);
		utente.setCap(CAP);
		//int TELEFONO = Integer.parseInt(telefono);
		//utente.setTelefono(TELEFONO);
		utente.setEmail(email);
		utente.setUsername(username);
		//utente.setPassword(password);
		//utente.setConfpassword(confpassword);
		utente.setPossiediCampiSportivi(possiediCampiSportivi);
			
		//String cryptedPassword = toSHA1(password.getBytes());
		try{
		
			model.doSave(utente);
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);	
	
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
 

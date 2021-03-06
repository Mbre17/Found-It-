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

import model.UtenteBean;
import model.UtenteModel;
import model.UtenteModelDM;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static UtenteModel model= new UtenteModelDM();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			String cryptedPassword = toSHA1(password.getBytes());
			String redirectedPage;
			try {
				UtenteBean utente= model.doRetrieveByKey(username);
				redirectedPage= "/jsp/home.jsp";
				
				if(utente == null || utente.getUsername() == null ){
					String message = "Username errato oppure inesistente!";
					request.getSession().setAttribute("message", message);
					response.sendRedirect(request.getContextPath() + redirectedPage);
				}
				else if(utente.getPassword().equals(cryptedPassword)){
					HttpSession session = request.getSession(true);
					session.setAttribute("login",utente);
					String message = "Ehy "+utente.getUsername()+", Benvenuto in Found It!";
					request.getSession().setAttribute("message", message);
					if(utente.getTipo().equals("admin")){
						request.getSession().setAttribute("adminRoles", new Boolean(true));
						redirectedPage = "/jsp/paginaAdmin.jsp";
						response.sendRedirect(request.getContextPath() + redirectedPage);
						}
					else if(utente.getTipo().equals("bannato")){
						message="Utente bannato! Contattare l'amministratore";
						request.getSession().setAttribute("message", message);
						redirectedPage = "/jsp/home.jsp";
						response.sendRedirect(request.getContextPath() + redirectedPage);	
						session.invalidate();
					}
					else{
						response.sendRedirect(request.getContextPath() + redirectedPage);
					}

				}
				else{
					String message = "Password errata!";
					request.getSession().setAttribute("message", message);
					response.sendRedirect(request.getContextPath() + redirectedPage);

				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
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

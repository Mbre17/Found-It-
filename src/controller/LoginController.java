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
			System.out.println("Sei in Login Register, Username:"+username+", Password:"+password);
			
			try {
				UtenteBean utente= model.doRetrieveByKey(username);
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher("/jsp/home.jsp");
				
				System.out.println("Conversione utente, utente="+utente);
				
				if(utente == null || utente.getUsername() == null ){
					System.out.println("utente inesistente!");
					String message = "test messaggio di errore!";
					request.setAttribute("message", message);
					rd.forward(request, response);
				}
				else if(utente.getPassword().equals(cryptedPassword)){
					System.out.println("password corretta!");
					HttpSession session = request.getSession(true);
					session.setAttribute("login",utente);
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Benvenuto '+ utente.getNome());");
				    out.println("location='"+request.getContextPath()+"/jsp/home.jsp';");
				    out.println("</script>");
				
				}
				else{
					System.out.println("password errata!");
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('Errore: utente non valido!');");
				    out.println("location='"+request.getContextPath()+"/jsp/home.jsp';");
				    out.println("</script>");
				}
			rd.forward(request, response);	
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

package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import util.ValidationUtil;

/**
 * Servlet implementation class DatiProfiloController
 */
@WebServlet("/DatiProfiloController")
public class DatiProfiloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtenteModel model= new UtenteModelDM();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatiProfiloController() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UtenteBean utenteSessione= (UtenteBean) session.getAttribute("login");
		UtenteBean utente= new UtenteBean();
		
		// Copio tutti i parametri di input nelle variabili locali
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confpassword");
		String email = request.getParameter("email");
		
		if( ValidationUtil.isEmpty(username) || !ValidationUtil.isAValidString(username,ValidationUtil.REGEX_USERNAME)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: username non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(password) || !ValidationUtil.isAValidString(password,ValidationUtil.REGEX_PASSWORD)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: password non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if(!confpassword.equals(password)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: I campi password e conferma password devono corrispondere!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(email) || !ValidationUtil.isAValidString(email,ValidationUtil.REGEX_EMAIL)){
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Errore: email non inserita oppure non valida!');");
			    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
			    out.println("</script>");
			    
			    //controllare se esiste già questa email associata ad un altro account
			}
		
		 
		 if(utente!=null){
			 utente.setUsername(username);
			 utente.setPassword(RegistrationController.toSHA1(password.getBytes()));
			 utente.setEmail(email);
			 utente.setNome(utenteSessione.getNome());
			 utente.setCognome(utenteSessione.getCognome());
			 utente.setcitta(utenteSessione.getcitta());
			 utente.setProvincia(utenteSessione.getProvincia());
			 utente.setCap(utenteSessione.getCap());
			 utente.setTelefono(utenteSessione.getTelefono());
			 utente.setTipo(utenteSessione.getTipo());

		 }
		 if(!(utente.equals(utenteSessione))){
			 try {
				 model.doUpdate(utente);
			 } catch (SQLException e) {
			// TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 utenteSessione.setUsername(username);
			 utenteSessione.setPassword(password);
			 utenteSessione.setEmail(email);			 
		 }
		 ServletContext sc = getServletContext();
		 RequestDispatcher rd = sc.getRequestDispatcher("/jsp/profiloUtente.jsp");
		 rd.forward(request, response);	
	}

}

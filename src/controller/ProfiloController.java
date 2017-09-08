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
 * Servlet implementation class ProfiloController
 */
@WebServlet("/ProfiloController")
public class ProfiloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static UtenteModel model= new UtenteModelDM();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfiloController() {
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
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("provincia");
		String cap = request.getParameter("cap");
		String telefono = request.getParameter("telefono");
		
		if( ValidationUtil.isEmpty(nome) || !ValidationUtil.isAValidString(nome,ValidationUtil.REGEX_NOME)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: nome non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(cognome) || !ValidationUtil.isAValidString(cognome,ValidationUtil.REGEX_GENERALE)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: cognome non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(citta) || !ValidationUtil.isAValidString(citta,ValidationUtil.REGEX_GENERALE)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: citta' non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(provincia) || !ValidationUtil.isAValidString(provincia,ValidationUtil.REGEX_GENERALE)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: provincia non inserita oppure non valida!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(cap) || !ValidationUtil.isAValidString(cap,ValidationUtil.REGEX_CAP)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: cap non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 if( ValidationUtil.isEmpty(telefono) || !ValidationUtil.isAValidString(telefono,ValidationUtil.REGEX_TELEFONO)){
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Errore: telefono non inserito oppure non valido!');");
		    out.println("location='"+request.getContextPath()+"/jsp/profiloUtente.jsp';");
		    out.println("</script>");
		}
		 
		 if(utente!=null){
			 utente.setNome(nome);
			 utente.setCognome(cognome);
			 utente.setcitta(citta);
			 utente.setProvincia(provincia);
			 utente.setCap(Integer.parseInt(cap));
			 utente.setTelefono(telefono);
			 utente.setUsername(utenteSessione.getUsername());
			 utente.setPassword(utenteSessione.getPassword());
			 utente.setEmail(utenteSessione.getEmail());
			 utente.setTipo(utenteSessione.getTipo());
		 }
		 if(!(utente.equals(utenteSessione))){
			 try {
				 model.doUpdate(utente);
			 } catch (SQLException e) {
			// TODO Auto-generated catch block
				 e.printStackTrace();
			 }
			 utenteSessione.setNome(nome);
			 utenteSessione.setCognome(cognome);
			 utenteSessione.setcitta(citta);
			 utenteSessione.setProvincia(provincia);
			 utenteSessione.setCap(Integer.parseInt(cap));
			 utenteSessione.setTelefono(telefono);
			 
		 }
		 ServletContext sc = getServletContext();
		 RequestDispatcher rd = sc.getRequestDispatcher("/jsp/profiloUtente.jsp");
		 rd.forward(request, response);	
		
	}	
	

}

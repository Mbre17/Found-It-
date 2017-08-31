package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
		UtenteBean utente= (UtenteBean) session.getAttribute("login");
		
		request.setAttribute("nome", utente.getNome());
		request.setAttribute("cognome", utente.getCognome());
		request.setAttribute("citta", utente.getcitta());
		request.setAttribute("activityProvince", utente.getProvincia());
		request.setAttribute("cap", utente.getCap());
		request.setAttribute("telefono", utente.getTelefono());
		
		/*
		String nome= request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String citta = request.getParameter("citta");
		String provincia = request.getParameter("activityProvince");
		String cap = request.getParameter("cap");
		String telefono = request.getParameter("telefono");
		
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setcitta(citta);
		utente.setProvincia(provincia);
		utente.setCap(Integer.parseInt(cap));
		utente.setTelefono(telefono);
		*/
		try {
			model.doRetrieveByKey(utente.getUsername());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try{
			if(utente.getUsername() == null){
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Errore: campo vuoto!');");
				out.println("location='"+request.getContextPath()+"/jsp/home.jsp';");
				out.println("</script>");
			}
			model.doUpdate(utente);
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Nome = request.getParameter("nome");
		String Cognome = request.getParameter("cognome");
		String Città = request.getParameter("città");
		String Provincia = request.getParameter("activityProvince");
		String Cap = request.getParameter("cap");
		String Telefono = request.getParameter("telefono");
		String Email = request.getParameter("email");
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		String PossiediCampiSportivi = request.getParameter("possiedicampisportivi");
	if(Nome.isEmpty()||Cognome.isEmpty()||Città.isEmpty()||Provincia.isEmpty()||Cap.isEmpty()||Telefono.isEmpty()||Email.isEmpty()||Username.isEmpty()||Password.isEmpty()||PossiediCampiSportivi.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("registrazione.jsp");
			out.println("<font color=red>Please fill all the fields</font>");
			rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
	}
}


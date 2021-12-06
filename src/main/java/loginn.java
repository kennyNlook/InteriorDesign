

//import java.io.IOException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import Roosine.Databaseconnection;

/**
 * Servlet implementation class loginn
 */
@WebServlet("/loginn")
public class loginn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		String password=request.getParameter("password");
		Databaseconnection dbc = new Databaseconnection();
	boolean result=dbc.checkCredentials(username, password);
	response.getWriter().println(result);
		if(result) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("dashbord.jsp");
		}else {
			  String errorMessage ="The retrived password or username did not match";
		        request.setAttribute("errorMessage", errorMessage );
		           RequestDispatcher rd = request.getRequestDispatcher("signin.jsp");
		                rd.forward(request, response);  
		}
		
	}
	}



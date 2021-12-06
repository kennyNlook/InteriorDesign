

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class connre
 */
@WebServlet("/connre")
public class connre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connre() {
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
		String street = request.getParameter("street");
		String phone =request.getParameter("phone");
		String gender = request.getParameter("gender");
		String location =request.getParameter("location");
		
		
		Conclass register = new Conclass(street,phone,gender,location) ;
		
		Databaseconnection dbcon =new Databaseconnection();
			
			String result = dbcon.insert(register);
			response.sendRedirect("inside.jsp");
			response.getWriter().print(result);
	}
}

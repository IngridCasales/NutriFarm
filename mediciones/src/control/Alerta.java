package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alerta
 */
@WebServlet("/alerta")
public class Alerta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alerta() {
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
		String mensajeAlerta;
		
		PrintWriter out;
		mensajeAlerta=(String)request.getAttribute("alerta");
		response.setContentType("text/html");
		out=response.getWriter();
		out.print("<html>");
		out.print("<head>");
	    out.print("<title>Advertencia de error</title>");
	    out.print("</head>");
	    out.print("<body>");
	    out.print("ERROR(:  "+mensajeAlerta);		   
	    out.print("</body>");
	    out.print("</html>");
        
	}

}

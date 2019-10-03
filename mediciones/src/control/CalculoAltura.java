package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Edificio;
import modelo.ExcepcionAngulo;
import modelo.ExcepcionDistanciaSombra;

/**
 * Servlet implementation class CalculoAltura
 */
@WebServlet("/calculoaltura")
public class CalculoAltura extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculoAltura() {
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
		String mensajeAlerta=null;
		Edificio edificio= new Edificio();
		try{
			edificio.setAngulo(Double.parseDouble(request.getParameter("angulo")));
			edificio.setDistanciaSombra(Double.parseDouble(request.getParameter("distancia")));
			edificio.calcularAltura();
			
			PrintWriter out;
			response.setContentType("text/html");
			out=response.getWriter();
			out.print("<html>");
			out.print("<head>");
		    out.print("<title>ALTURA CALCULADA</title>");
		    out.print("</head>");
		    out.print("<body>");
		    out.print("La altura calculada es: "+edificio.getAltura());		   
		    out.print("</body>");
		    out.print("</html>");	
		    
		}catch(NumberFormatException nfe){
			mensajeAlerta="Formato incorrecto de número";
			request.setAttribute("alerta", mensajeAlerta);
			RequestDispatcher rd=request.getRequestDispatcher("/alerta");
		}catch(ExcepcionAngulo ea){
			mensajeAlerta=" El ángulo no esta en los límites correspondientes";
			request.setAttribute("alerta", mensajeAlerta);
			RequestDispatcher rd=request.getRequestDispatcher("/alerta");
			rd.forward(request, response);
		}catch(ExcepcionDistanciaSombra eds){	
			mensajeAlerta="El valor de la distancia  de la sombra, es incorrecto";
			request.setAttribute("alerta", mensajeAlerta);
			RequestDispatcher rd=request.getRequestDispatcher("/alerta");
			rd.forward(request, response);
		}

	}

}

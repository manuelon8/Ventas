package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Empleado;
import modelo.EmpleadoDao;

/**
 * Servlet implementation class Validar
 */
@WebServlet("/Validar")
public class ControladorValidar extends HttpServlet {
 
       
 
	EmpleadoDao edao = new EmpleadoDao();
	Empleado em = new Empleado();


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
		 String accion = request.getParameter("accion");
		 //si presiona el boton ingresar efectua este recorrido
		 if(accion.equalsIgnoreCase("Ingresar")) {
			 String user=request.getParameter("txtuser");
			 String pass=request.getParameter("txtpass");
			 
			 em= edao.Validar(user, pass);
			 
			 if(em.getUser()!=null) {
				 request.setAttribute("usuario", em);
				 request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
			 }
			 else {
				 request.getRequestDispatcher("index.jsp").forward(request, response);
			 }
		 }
		 else {
			 request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response); 
		 }
	}

}

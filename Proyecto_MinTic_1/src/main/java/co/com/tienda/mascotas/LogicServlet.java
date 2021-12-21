package co.com.tienda.mascotas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/LogicServlet")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String usuario = request.getParameter("txt_usuario");
		String contraseña = request.getParameter("txt_contraseña");
		
			if(usuario.equals("admininicial")) {
				if(contraseña.equals("admin123456")) {
					RequestDispatcher rd; 
					rd=request.getRequestDispatcher("Modulo_Gestion_usuarios.jsp");
					rd.forward(request, response);
				}else {
					response.getWriter().append(" Contraseña incorrecta");
				}
				
			}else {
				
				response.getWriter().append(" Usuario incorrecto");
			}
				

	
	}

}

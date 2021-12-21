package co.com.tienda.mascotas;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.URL;
import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public DemoServlet() {
    	
        // TODO Auto-generated constructor stub
    }
    public void validarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//    	  request.getRequestDispatcher("/Modulo_Gestion_usuarios.jsp").forward(request, response);
    	try {

		ArrayList<Usuarios> lista = TestJSON.getJSON();
		request.setAttribute("lista", lista);
		String usua = request.getParameter("txt_usuario");
		String pass = request.getParameter("txt_password");
		int respuesta =0;
		

		for (Usuarios usuario:lista){
			if (usuario.getUsuario().equals(usua) && usuario.getPassword().equals(pass)) {
			    request.setAttribute("usuario", usuario);
			    request.getRequestDispatcher("/Principal.jsp").forward(request, response);
			    respuesta =1;
			}
					
		}
			
		if (respuesta==0) {
		    request.setAttribute("feedback", "El usuario no existe o la contraseña es incorrecta");
			request.getRequestDispatcher("/Index.jsp").forward(request, response);
			System.out.println("No se encontraron datos");
		}
			
	} catch (Exception e) {
			// TODO: handle exception
		response.getWriter().println(e);
		  System.out.println(e);
		e.printStackTrace();
	}
    }
    	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	     String accion = request.getParameter("accion");
		

			
	      if (accion.equals("Ingresar")) {
	    	  
		    this.validarUsuarios(request, response);		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package co.com.tienda.mascotas;

import java.io.IOException;
import java.io.PrintWriter;
//import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	double subtotal=0, totalapagar=0;
    long codproducto=0;
    double precio=0, valor_iva=0, iva=0, subtotaliva=0, acusubtotal=0;
    long numfac=0;
    int cantidad=0, item=0;
    String descripcion, cedulacliente;
    
    List<Detalle_ventas> listaVentas = new ArrayList<>();
    Usuarios usuarios = new Usuarios();
    Detalle_ventas detalle_venta = new Detalle_ventas();
    
    public Controlador() {
       super();
    }
     
    public void buscarCliente(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
 	   try {
    		ArrayList<Clientes> listac=ClienteJSON.getJSON();
 			for (Clientes cliente:listac) {
 				if(cliente.getCedula_cliente() == (id)) {
 					request.setAttribute("clienteSeleccionado", cliente);
 				}
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
    }
 	
     public void buscarProducto(Long id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     	
     	try {
 			ArrayList<Productos> listap=ProductosJSON.getJSON();
 			for (Productos productos:listap) {
 				if(productos.getCodigo_producto() == (id)) {
 					request.setAttribute("productoSeleccionado", productos);
 				}
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
     }

     public void mostrarFactura(String numFact, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	if(numFact==null) {
    		numfac=Long.parseLong(numFact)+1;
    	}else {
    		numfac=Long.parseLong(numFact)+1;
    	}
    	request.setAttribute("numeroFactura", numfac);
     }
     
     public void grabarDetalle_ventas(Long numFcat,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//**************grabar en tabla de detalles ventas**********************
    	 for(int i=0; i< listaVentas.size(); i++) {
    		 detalle_venta=new Detalle_ventas();
    		 
    		 detalle_venta.setCodigo_detalle_venta(i+1);
    		 detalle_venta.setCodigo_venta(String.valueOf(numfac));
    		 detalle_venta.setCantidad_producto(listaVentas.get(i).getCantidad_producto());
    		 detalle_venta.setCodigo_producto(listaVentas.get(i).getCodigo_producto());
    		 detalle_venta.setValor_venta(listaVentas.get(i).getValor_venta());
    		 detalle_venta.setValor_total(listaVentas.get(i).getValor_total());
    		 detalle_venta.setValoriva(listaVentas.get(i).getValoriva());
    		 
    		 int respuesta=0;
    		 try {
    			 respuesta=Detalle_ventasJSON.postJSON(detalle_venta);
    			 PrintWriter write = response.getWriter();
    			 if(respuesta==200) {
    				 request.getRequestDispatcher("Controlador?menu=Ventas&accion=default").forward(request, response);
    				 System.out.println("Registros grabados en Detalle venta");
    		 }else {
    			 write.println("Error Detalle ventas:"+ respuesta);
    			 
    		 }
    			 write.close();
    		  
    		 }catch(Exception e) {
					e.printStackTrace();
    		 }
    	 }
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
String menu = request.getParameter("menu");
String accion = request.getParameter("accion");


        
 switch (menu) {
 case "Principal":
	  request.getRequestDispatcher("/Principal.jsp").forward(request, response);
	  break;
    case "Usuarios":
    	if (accion.equals("Listar")) {
   	     try {
   	        ArrayList<Usuarios> lista = TestJSON.getJSON();
   		 request.setAttribute("lista", lista);
   	     } catch (Exception e) {
   		 e.printStackTrace();
   	     }
   	  }else if(accion.equals("Agregar")) {
   	     Usuarios usuario = new Usuarios();
   	     usuario.setCedula_usuario(Long.parseLong(request.getParameter("txt_cedula")));
   	     usuario.setNombre_usuario(request.getParameter("txt_nombre_completo"));
   	     usuario.setEmail_usuario(request.getParameter("txt_correo"));
   	     usuario.setUsuario(request.getParameter("txt_usuario"));
   	     usuario.setPassword(request.getParameter("txt_password"));
   					
   	     int respuesta=0;
   	      try {
   		   respuesta = TestJSON.postJSON(usuario);
   		   if (respuesta==200) {

   	request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request,
                                                                                  response);
   	        } else {
   	        	System.out.println("Error: " +  respuesta);
   			
   		 }
   	     } catch (Exception e) {
   		 e.printStackTrace();
   	      }
   					
   	  }else if(accion.equals("Actualizar")) {
   		     Usuarios usuario = new Usuarios();
   		     usuario.setCedula_usuario(Long.parseLong(request.getParameter("txt_cedula")));
   		     usuario.setNombre_usuario(request.getParameter("txt_nombre_completo"));
   		     usuario.setEmail_usuario(request.getParameter("txt_correo"));
   		     usuario.setUsuario(request.getParameter("txt_usuario"));
   		     usuario.setPassword(request.getParameter("txt_password"));
   			
   	            int respuesta=0;
   			try {
   			   respuesta = TestJSON.putJSON(usuario,usuario.getCedula_usuario());
   			   PrintWriter write = response.getWriter();
   							
   			   if (respuesta==200) {
   		request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
   	       	   } else {
   				write.println("Error: " +  respuesta);
   			   }
   				write.close();
   			   } catch (Exception e) {
   				e.printStackTrace();
   			   }
   		}else if(accion.equals("Cargar")) {
   			Long id = Long.parseLong(request.getParameter("id"));
   			try {
   	               ArrayList<Usuarios> lista1 = TestJSON.getJSON();
   			   System.out.println("Parametro: " + id);						
   			   for (Usuarios usuario:lista1){
   				if (usuario.getCedula_usuario()==id) {
   				   request.setAttribute("usuarioSeleccionado", usuario);
   				   request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
   				}
   			   }
   			 } catch (Exception e) {
   		       	e.printStackTrace();
   			 }
   		}else if(accion.equals("Eliminar")) {
   	       	Long id= Long.parseLong(request.getParameter("id"));			
   			int respuesta=0;
   			try {
   			   respuesta = TestJSON.deleteJSON(id);
   			   PrintWriter write = response.getWriter();
   			   if (respuesta==200) {
   		request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
   			   } else {
   				write.println("Error: " +  respuesta);
   			   }
   			      write.close();
   			   } catch (Exception e) {
   				e.printStackTrace();
   			   }
   			
   		}else if(accion.equals("Consultar")) { 
   			Long id= Long.parseLong(request.getParameter("txt_cedula")); 
   			try {
   	                ArrayList<Usuarios> lista2 = TestJSON.getJSON();					
   			   for (Usuarios usuarios:lista2){ 
   				if (usuarios.getCedula_usuario()==id) { 
   				   request.setAttribute("usuarioSeleccionado", usuarios); 
   				   request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
   				}
   			   }
   			 } catch (Exception e) {
   		       	e.printStackTrace();
   			 }
   	}request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
	   break;
	   
	   
    case "Clientes":
			if (accion.equals("Listar")) {
			     try {
			        ArrayList<Clientes> lista = ClienteJSON.getJSON();
				 request.setAttribute("lista", lista);
			     } catch (Exception e) {
				 e.printStackTrace();
			     }
			  }else if(accion.equals("Agregar")) {
			     
			     Clientes cliente = new Clientes();
				cliente.setCedula_cliente(Long.parseLong(request.getParameter("txt_cedulac")));
				cliente.setDireccion_cliente(request.getParameter("txt_direccionc"));
				cliente.setEmail_cliente(request.getParameter("txt_correoc"));
				cliente.setNombre_cliente(request.getParameter("txt_nombrec"));
				cliente.setTelefono_cliente(request.getParameter("txt_telefonoc"));		
			     int respuesta=0;
			      try {
				   respuesta = ClienteJSON.postJSON(cliente);
				   if (respuesta==200) {
					   request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request,response);
			
			        } else {
			        	System.out.println("Error: " +  respuesta);
					
				 }
			     } catch (Exception e) {
				 e.printStackTrace();
			      }
							
			  }else if(accion.equals("Actualizar")) {
				  Clientes cliente = new Clientes();
					cliente.setCedula_cliente(Long.parseLong(request.getParameter("txt_cedulac")));
					cliente.setDireccion_cliente(request.getParameter("txt_direccionc"));
					cliente.setEmail_cliente(request.getParameter("txt_correoc"));
					cliente.setNombre_cliente(request.getParameter("txt_nombrec"));
					cliente.setTelefono_cliente(request.getParameter("txt_telefonoc"));		
					
			            int respuesta=0;
					try {
					   respuesta = ClienteJSON.putJSON(cliente,cliente.getCedula_cliente());
					   PrintWriter write = response.getWriter();
									
					   if (respuesta==200) {
				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
			       	   } else {
						write.println("Error: " +  respuesta);
					   }
						write.close();
					   } catch (Exception e) {
						e.printStackTrace();
					   }
				}else if(accion.equals("Cargar")) {
					Long id= (Long.parseLong(request.getParameter("id")));
					try {
			            ArrayList<Clientes> lista = ClienteJSON.getJSON();
					   System.out.println("Parametro: " + id);						
					   for (Clientes clientes:lista){
						if (clientes.getCedula_cliente()==id) {
						   request.setAttribute("clienteSeleccionado", clientes);
						   request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
					   }
					   }
					 } catch (Exception e) {
				       	e.printStackTrace();
					 }
				}else if(accion.equals("Eliminar")) {
			       	Long id= (Long.parseLong(request.getParameter("id")));			
					int respuesta=0;
					try {
					   respuesta = ClienteJSON.deleteJSON(id);
					   PrintWriter write = response.getWriter();
					   if (respuesta==200) {
				request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
					   } else {
						write.println("Error: " +  respuesta);
					   }
					      write.close();
					   } catch (Exception e) {
						e.printStackTrace();
					   }
					
				}else if(accion.equals("Consultar")) { 
						Long id= (Long.parseLong(request.getParameter("txt_cedulac")));
						try {
				               ArrayList<Clientes> lista2 = ClienteJSON.getJSON();
						   System.out.println("Parametro: " + id);						
						   for (Clientes clientes:lista2){
							if (clientes.getCedula_cliente()==id) {
							   request.setAttribute("clienteSeleccionado", clientes);
							   request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
						}
					   }
					 } catch (Exception e) {
				       	e.printStackTrace();
					 }
			}request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
		break;
		
		
		
		case "Proveedores":	
			if (accion.equals("Listar")) {
			     try {
			        ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
				 request.setAttribute("lista", lista);
			     } catch (Exception e) {
				 e.printStackTrace();
			     }
			  }else if(accion.equals("Agregar")) {
			     Proveedores provee = new Proveedores();
			     provee.setNitproveedor(Long.parseLong(request.getParameter("txt_nitproveedor")));
			     provee.setNombre_proveedor(request.getParameter("txt_nombre_proveedor"));
			     provee.setDireccion_proveedor(request.getParameter("txt_direccion_proveedor"));
			     provee.setTelefono_proveedor(request.getParameter("txt_telefono_proveedor"));
			     provee.setCiudad_proveedor(request.getParameter("txt_ciudad_proveedor"));
			     
							
			     int respuesta=0;
			      try {
				   respuesta = ProveedoresJSON.postJSON(provee);
				   if (respuesta==200) {
					   request.setAttribute("provee", provee);
			request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request,response);
			        } else {
			        	System.out.println("Error: " +  respuesta);
					
				 }
			     } catch (Exception e) {
				 e.printStackTrace();
			      }
							
			  }else if(accion.equals("Actualizar")) {
				  Proveedores provee = new Proveedores();
				     provee.setNitproveedor(Long.parseLong(request.getParameter("txt_nitproveedor")));
				     provee.setNombre_proveedor(request.getParameter("txt_nombre_proveedor"));
				     provee.setDireccion_proveedor(request.getParameter("txt_direccion_proveedor"));
				     provee.setTelefono_proveedor(request.getParameter("txt_telefono_proveedor"));
				     provee.setCiudad_proveedor(request.getParameter("txt_ciudad_proveedor"));
					
			            int respuesta=0;
					try {
					   respuesta = ProveedoresJSON.putJSON(provee,provee.getNitproveedor());
					   PrintWriter write = response.getWriter();
									
					   if (respuesta==200) {
				request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
			       	   } else {
						write.println("Error: " +  respuesta);
					   }
						write.close();
					   } catch (Exception e) {
						e.printStackTrace();
					   }
				}else if(accion.equals("Cargar")) {
					Long id= Long.parseLong(request.getParameter("id"));
					try {
			               ArrayList<Proveedores> listap = ProveedoresJSON.getJSON();
					   System.out.println("Parametro: " + id);						
					   for (Proveedores provee:listap){
						if (provee.getNitproveedor()==id) {
						   request.setAttribute("proveeSeleccionado", provee);
						   request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);	
						}
					   }
					 } catch (Exception e) {
				       	e.printStackTrace();
					 }
				}else if(accion.equals("Eliminar")) {
			       	Long id= Long.parseLong(request.getParameter("id"));			
					int respuesta=0;
					try {
					   respuesta = ProveedoresJSON.deleteJSON(id);
					   PrintWriter write = response.getWriter();
					   if (respuesta==200) {
				request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
					   } else {
						write.println("Error: " +  respuesta);
					   }
					      write.close();
					   } catch (Exception e) {
						e.printStackTrace();
					   }
					
				}else if(accion.equals("Consultar")) { 
					Long id= Long.parseLong(request.getParameter("txt_nitproveedor")); 
					try {
			                ArrayList<Proveedores> listap = ProveedoresJSON.getJSON();
			                System.out.println("Parametro: " + id);						
					   for (Proveedores provee:listap){ 
						if (provee.getNitproveedor()==id) { 
						   request.setAttribute("proveeSeleccionado", provee); 
						   request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);	
						}
					   }
					 } catch (Exception e) {
				       	e.printStackTrace();
				       	System.out.println("Usuario no encontrado");
					 }
				}request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
		break;
		
		
		case "Productos":
		
			if (accion.equals("Listar")) {
			     try {
			        ArrayList<Productos> lista = ProductosJSON.getJSON();
				 request.setAttribute("lista", lista);
			     } catch (Exception e) {
				 e.printStackTrace();
			     }
			  }else if(accion.equals("Agregar")) {
			     
			    Productos produ = new Productos();
				produ.setCodigo_producto(Long.parseLong(request.getParameter("txt_codigo_producto")));
				produ.setNombre_producto(request.getParameter("txt_nombre_producto"));
				produ.setPrecio_compra(Double.parseDouble(request.getParameter("txt_precio_compra")));
				produ.setIvacompra(Double.parseDouble(request.getParameter("txt_ivacompra")));
				produ.setPrecio_venta(Double.parseDouble(request.getParameter("txt_precio_venta")));
				produ.setNitproveedor(Long.parseLong(request.getParameter("txt_nitproveedor")));
			     int respuesta=0;
			      try {
				   respuesta = ProductosJSON.postJSON(produ);
				   if (respuesta==200) {
					   request.setAttribute("produ", produ);
			request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request,
		                                                                               response);
			        } else {
			        	System.out.println("Error: " +  respuesta);
					
				 }
			     } catch (Exception e) {
				 e.printStackTrace();
			      }
							
			  }else if(accion.equals("Actualizar")) {
				  Productos produ = new Productos();
					produ.setCodigo_producto(Long.parseLong(request.getParameter("txt_codigo_producto")));
					produ.setNombre_producto(request.getParameter("txt_nombre_producto"));
					produ.setPrecio_compra(Double.parseDouble(request.getParameter("txt_precio_compra")));
					produ.setIvacompra(Double.parseDouble(request.getParameter("txt_ivacompra")));
					produ.setPrecio_venta(Double.parseDouble(request.getParameter("txt_precio_venta")));
					produ.setNitproveedor(Long.parseLong(request.getParameter("txt_nitproveedor")));
					
			            int respuesta=0;
					try {
					   respuesta = ProductosJSON.putJSON(produ,produ.getCodigo_producto());
					   PrintWriter write = response.getWriter();
									
					   if (respuesta==200) {
				request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
			       	   } else {
						write.println("Error: " +  respuesta);
					   }
						write.close();
					   } catch (Exception e) {
						e.printStackTrace();
					   }
				}else if(accion.equals("Cargar")) {
					Long id= Long.parseLong(request.getParameter("id"));
					try {
			               ArrayList<Productos> lista1 = ProductosJSON.getJSON();
					   System.out.println("Parametro: " + id);						
					   for (Productos produ:lista1){
						if (produ.getCodigo_producto()==id) {
						   request.setAttribute("productoSeleccionado", produ);
						   request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);	
						}
					   }
					 } catch (Exception e) {
				       	e.printStackTrace();
					 }
				}else if(accion.equals("Eliminar")) {
			       	Long id= Long.parseLong(request.getParameter("id"));			
					int respuesta=0;
					try {
					   respuesta = ProductosJSON.deleteJSON(id);
					   PrintWriter write = response.getWriter();
					   if (respuesta==200) {
				request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
					   } else {
						write.println("Error: " +  respuesta);
					   }
					      write.close();
					   } catch (Exception e) {
						e.printStackTrace();
					   }
					
				}else if(accion.equals("Consultar")) { 
					Long id= Long.parseLong(request.getParameter("txt_codigo_producto")); 
					try {
			                ArrayList<Productos> lista2 = ProductosJSON.getJSON();
			                System.out.println("Parametro: " + id);						
					   for (Productos produ:lista2){ 
						if (produ.getCodigo_producto()==id) { 
						   request.setAttribute("productoSeleccionado", produ); 
						   request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);	
						}
					   }
					 } catch (Exception e) {
				       	e.printStackTrace();
					 }
			}request.getRequestDispatcher("/Productos.jsp").forward(request, response);
		break;
		case "Ventas":	
			 Long cedula_usuario_activo=Long.parseLong(request.getParameter("UsuarioActivo"));
			 usuarios.setCedula_usuario(cedula_usuario_activo);

			 request.setAttribute("usuarioSeleccionado", usuarios);
			request.setAttribute("numeroFactura", numfac);
			if (accion.equals("BuscarCliente")) {
				
				Long id = (Long.parseLong(request.getParameter("cedulacliente")));
				this.buscarCliente(id, request, response);
				
			}else if (accion.equals("BuscarProducto")) {
				
				Long id = (Long.parseLong(request.getParameter("cedulacliente")));
				this.buscarCliente(id, request, response);
							
				Long cod = (Long.parseLong(request.getParameter("codigoproducto")));
				this.buscarProducto(cod, request, response);
				
			}else if (accion.equals("AgregarProducto")) {
				Long id = (Long.parseLong(request.getParameter("cedulacliente")));
				this.buscarCliente(id, request, response);
				
				detalle_venta = new Detalle_ventas();
				item++;
				totalapagar=0;
				subtotal=0;
				acusubtotal=0;
				subtotaliva=0;
				totalapagar=0;
				
				codproducto=(Long.parseLong(request.getParameter("codigoproducto")));
				descripcion=request.getParameter("nombreproducto");
				precio=(Double.parseDouble(request.getParameter("precioproducto")));
				cantidad=Integer.parseInt(request.getParameter("cantidadproducto"));
				iva=(Double.parseDouble(request.getParameter("ivaproducto")));
				
				subtotal=(precio*cantidad);
				valor_iva=subtotal*iva/100;
				
				detalle_venta.setCodigo_detalle_venta(item);
				detalle_venta.setCantidad_producto(cantidad);
				detalle_venta.setDescripcion_producto(descripcion);
				detalle_venta.setCodigo_producto(codproducto);
				detalle_venta.setCodigo_venta(String.valueOf(numfac));
				detalle_venta.setValoriva(valor_iva);
				detalle_venta.setValor_venta(subtotal);
				detalle_venta.setPrecio_producto(precio);
				
				listaVentas.add(detalle_venta);
				
				for(int i=0; i<listaVentas.size(); i++) {
					acusubtotal +=listaVentas.get(i).getValor_venta();
					subtotaliva +=listaVentas.get(i).getValoriva();
				}
				
				totalapagar = acusubtotal + subtotaliva; 
				detalle_venta.setValor_total(totalapagar);
				
				request.setAttribute("listaventas", listaVentas);
				request.setAttribute("totalsubtotal", acusubtotal);
				request.setAttribute("totaliva", subtotaliva);
				request.setAttribute("totalapagar", totalapagar);
		}else if (accion.equals("GenerarVenta")) {
			System.out.println("entro");
				cedulacliente=request.getParameter("cedulacliente");
				String numFact=request.getParameter("numerofactura");
				Ventas ventas= new Ventas();
				ventas.setCodigo_venta(Long.parseLong(numFact));
				ventas.setCedula_cliente(Long.parseLong(cedulacliente));
				ventas.setCedula_usuario(usuarios.getCedula_usuario());
				ventas.setIvaventa(subtotaliva);
				ventas.setTotal_venta(totalapagar);
				ventas.setValor_venta(acusubtotal);
				
				
				int respuesta=0;
				try {
					respuesta=VentasJSON.postJSON(ventas);
					PrintWriter write=response.getWriter();
					if(respuesta==200) {
						System.out.println("Grabacion Exitosa:"+ respuesta);
					this.grabarDetalle_ventas(ventas.getCodigo_venta(), request, response);
					}else {
						write.println("Error Ventas:"+ respuesta);
					}
					write.close();
				}catch(Exception e) {
					e.printStackTrace();
				}listaVentas.clear();
				item=0;
				totalapagar=0;
				subtotal=0;
				acusubtotal=0;
				subtotaliva=0;
				totalapagar=0;
				
				
				
			}else {
//				String factura=request.getParameter("numerofactura");
//				System.out.println(request.getParameter("numerofactura"));
//				this.mostrarFactura(factura, request, response);
				try {
					numfac=VentasJSON.getConsecutivo();
					request.setAttribute("numerofactura", numfac);
				    } catch (Exception e) {
					e.printStackTrace();
				    }
			
			}
			request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
			break;
		case "Reportes":
			int opcion=0;
			if(accion.equals("ReporteUsuarios")) {
				opcion=1;
				 try {
			   	        ArrayList<Usuarios> lista = TestJSON.getJSON();
			   		 request.setAttribute("listaUsuarios", lista);
			   		 request.setAttribute("opcion", opcion);
			   	     } catch (Exception e) {
			   		 e.printStackTrace();
			   	     }
			}else if(accion.equals("ReporteClientes")) {
				opcion=2;
				 try {
				        ArrayList<Clientes> lista = ClienteJSON.getJSON();
					 request.setAttribute("listaClientes", lista);
					 request.setAttribute("opcion",opcion);
				     } catch (Exception e) {
					 e.printStackTrace();
				     }
			}else if(accion.equals("ReporteVentas")) {
				opcion=3;
				try {
					 ArrayList<Ventas> lista = VentasJSON.getJSON();
					 request.setAttribute("listaVentas", lista);
					request.setAttribute("opcion",opcion);
				     } catch (Exception e) {
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("/Reportes.jsp").forward(request, response);
			break;
		
		default:
		break;
 	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

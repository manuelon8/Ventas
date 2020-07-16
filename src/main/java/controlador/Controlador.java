package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.GenerarSerie;
import modelo.Cliente;
import modelo.ClienteDao;
import modelo.Empleado;
import modelo.EmpleadoDao;
import modelo.Producto;
import modelo.ProductoDao;
import modelo.Venta;
import modelo.VentaDAO;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet { 


	Empleado em = new Empleado();
	Cliente c = new Cliente();	
	EmpleadoDao edao = new EmpleadoDao();
	ClienteDao cdao=new ClienteDao();
	Producto p = new Producto();
	ProductoDao pdao = new ProductoDao();
	Venta v = new Venta();
	VentaDAO vdao= new VentaDAO();
	List<Venta> lista = new ArrayList<>();
	int ide;
	int idc;
	int idp;
	
	int item;
	int cod;
	String descripcion;
	double precio;
	int cant;
	double subtotal;
	double totalPagar;
	String numeroSerie;
	
	
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		  throws ServletException, IOException {
    		    
    		String accion = request.getParameter("accion");
    		String menu = request.getParameter("menu");
    		
    		if(menu.equals("Principal")) {
    			request.getRequestDispatcher("principal.jsp").forward(request, response);
    		}
    		if(menu.equals("Empleados")) {
    			
    			switch (accion) {
				case "Listar":
					
					List lista = edao.listar();
					request.setAttribute("empleados", lista);
					break;
				case "Agregar":
					
					String dni= request.getParameter("txtDni");
					String nom= request.getParameter("txtNombres");
					String tel= request.getParameter("txtTel");
					String est= request.getParameter("txtEstado");
					String user= request.getParameter("txtUser");
					 
					em.setDni(dni);
					em.setNom(nom);
					em.setTel(tel);
					em.setEstado(est);
					em.setUser(user);
					
					edao.agregar(em);
					request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
					break;
				case "Editar":
					ide = Integer.parseInt(request.getParameter("id"));
					Empleado e=edao.listarId(ide);
					request.setAttribute("empleado", e);
					request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
					break;
				case "Actualizar":
					String dni1= request.getParameter("txtDni");
					String nom1= request.getParameter("txtNombres");
					String tel1= request.getParameter("txtTel");
					String est1= request.getParameter("txtEstado");
					String user1= request.getParameter("txtUser");
					 
					em.setDni(dni1);
					em.setNom(nom1);
					em.setTel(tel1);
					em.setEstado(est1);
					em.setUser(user1);
					
					em.setId(ide);
					
					edao.actualizar(em);
					request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
					break;
					
				case "Delete":
					
					ide = Integer.parseInt(request.getParameter("id"));
					edao.delete(ide);
					 
					request.getRequestDispatcher("Controlador?menu=Empleados&accion=Listar").forward(request, response);
					
					break;
					
				case "NuevaVenta":
					
					
					break;

				default:
					break;
				}
    			request.getRequestDispatcher("empleados.jsp").forward(request, response);
    		}
    		if(menu.equals("Producto")) {
    			
    			switch (accion) {
				case "Agregar":
//    			String idp= request.getParameter("txtId");
    			String descripcionp= request.getParameter("txtDescripcion");
    			String preciop= request.getParameter("txtPrecio");
    			String stockp= request.getParameter("txtStock");
    			String estadop= request.getParameter("txtEstado");
    			
    			p.setNom(descripcionp);
    			p.setPre(Double.parseDouble(preciop));
    			p.setStock(Integer.parseInt(stockp));
    			p.setEstado(estadop);
    			pdao.agregar(p);
    			request.getRequestDispatcher("producto.jsp").forward(request, response);
    			 
    			 break;
				default:
					request.getRequestDispatcher("producto.jsp").forward(request, response);
					break;
    			}
    		}
    		if(menu.equals("Clientes")) {
   			 request.getRequestDispatcher("clientes.jsp").forward(request, response);
    		}
    		if(menu.equals("NuevaVenta")) {
    			
    			switch (accion) {
				case "BuscarCliente":
					String dni = request.getParameter("codigoCLiente");
					c.setDni(dni);
					c=cdao.buscar(dni);
					request.setAttribute("c", c);
					break;
				case "BuscarProducto":
					int  id = Integer.parseInt(request.getParameter("codigoProducto"));
					p=pdao.listarId(id);
					request.setAttribute("producto", p);
					request.setAttribute("lista", lista); 
					request.setAttribute("totalpagar", totalPagar);
					request.setAttribute("c", c);
					break;
				case "Agregar":
					request.setAttribute("c", c);
					item = item +1;
					cod= p.getId();
					descripcion=request.getParameter("nomproducto");
					precio=Double.parseDouble(request.getParameter("precio"));
					cant = Integer.parseInt(request.getParameter("cant"));
					subtotal=precio*cant;
					totalPagar = 0.0;
					
					v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);    
					break;
					
					case "GenerarVenta":
					//Guardar Venta
						
					//Actualizar el stock
					for(int i=0; i<lista.size(); i++) {
						ProductoDao pdao=new ProductoDao();
						Producto pr = new Producto();
						int idProduct = lista.get(i).getIdproducto();
						pr=pdao.buscar(idProduct);//busca los detalles del producto
						int cant = lista.get(i).getCantidad();//obtiene la cantidad de productos de la venta
						int sac=pr.getStock()-cant;//resta al stock actual la cantidad de items de la venta
						pdao.actualizarstock(idProduct, sac);//actualiza en base el stock	
						
					}
						
					v.setIdcliente(c.getId());
					v.setIdempleado(2);
					v.setNumserie(numeroSerie);
					v.setFecha("2020-07-10");
					v.setMonto(totalPagar);
					v.setEstado("1");
					vdao.guardarVenta(v);
					//Guardar Detalle de la venta
					//1ro se guarda el id de esa venta
					int idv=Integer.parseInt(vdao.IdVentas());
					 
					for(int i=0; i<lista.size(); i++) {
						v=new Venta();
						v.setId(idv);
						v.setIdproducto(lista.get(i).getIdproducto());
						v.setCantidad(lista.get(i).getCantidad());
						v.setPrecio(lista.get(i).getPrecio());
						vdao.guardarDetalleventas(v);
					}
					
					break;

				default:
					numeroSerie=vdao.GenerarSerie();
					if(numeroSerie==null) {
						numeroSerie="00000001";
						request.setAttribute("nserie", numeroSerie);
					}
					else{
						int incrementar= Integer.parseInt(numeroSerie);
						GenerarSerie gs = new GenerarSerie();
						numeroSerie=gs.NumeroSerie(incrementar);
						request.setAttribute("nserie", numeroSerie);
					}
					 request.getRequestDispatcher("registrarventa.jsp").forward(request, response);
					break;
					 
				}
      			 request.getRequestDispatcher("registrarventa.jsp").forward(request, response);
       		}    		
    		
    		 } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}

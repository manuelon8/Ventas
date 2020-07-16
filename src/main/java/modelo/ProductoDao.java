package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class ProductoDao {
	

	Conexion cn = new Conexion();
	java.sql.Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;
	
	public Producto buscar(int id){
	      Producto p=new Producto();
	      String sql="select * from producto where idproducto="+id;
	      try {
	          con=cn.Coneccion();
	          ps=con.prepareStatement(sql);
	          rs=ps.executeQuery();
	          while (rs.next()) {
	              p.setId(rs.getInt(1));
	              p.setNom(rs.getString(2));
	              p.setPre(rs.getDouble(3));
	              p.setStock(rs.getInt(4));
	              p.setEstado(rs.getString(5));
	          }
	      } catch (Exception e) {
	      }
	     return p;
	  }
	
	
	//OPERACIONES CRUD
	
		public List listar() {
			String sql = "Select * from producto";
			List<Producto> lista = new ArrayList();
			try {
				con=cn.Coneccion();
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					Producto p = new Producto();
					p.setId(rs.getInt(1));					 
					p.setNom(rs.getString(2));
					p.setPre(rs.getDouble(3));
					p.setStock(rs.getInt(4));
					p.setEstado(rs.getNString(5));
					 
					lista.add(p);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return lista;
		}
		
		public int actualizarstock(int id, int stock){
		      String sql="update producto set Stock=? where idproducto=?";
		      try {
		          con=cn.Coneccion();
		          ps=con.prepareStatement(sql);
		          ps.setInt(1, stock);
		          ps.setInt(2, id);
		          ps.executeUpdate();
		      } catch (Exception e) {
		      }
		      return r;
		  }
		
		public int agregar(Producto p){ 
	        String sql="insert into producto(Nombres, Precio,Stock,Estado)values(?,?,?,?)";
	        try {
	            con=cn.Coneccion();
	            ps=con.prepareStatement(sql);
	            ps.setString(1, p.getNom());
	            ps.setDouble(2, p.getPre());
	            ps.setInt(3, p.getStock());
	            ps.setString(4, p.getEstado());        
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	        return r;
	        
	    }
	    public Producto listarId(int id){
	        Producto pr=new Producto();
	        String sql="select * from producto where IdProducto="+id;
	        try {
	            con=cn.Coneccion();
	            ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            while (rs.next()) {
	                pr.setId(rs.getInt(1));
	                pr.setNom(rs.getString(2));               
	                pr.setPre(rs.getDouble(3));
	                pr.setStock(rs.getInt(4));
	                pr.setEstado(rs.getString(5));  
	            }
	        } catch (Exception e) {
	        }
	        return pr;
	    }
	    public int actualizar(Producto em){
	        String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
	        try {
	            con=cn.Coneccion();
	            ps=con.prepareStatement(sql);
	            ps.setString(1, em.getNom());
	            ps.setDouble(2, em.getPre());
	            ps.setInt(3, em.getStock());
	            ps.setString(4, em.getEstado());            
	            ps.setInt(5, em.getId());
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	        return r;
	    }
	    public void delete(int id){
	        String sql="delete from producto where IdProducto="+id;
	        try {
	            con=cn.Coneccion();
	            ps=con.prepareStatement(sql);
	            ps.executeUpdate();
	        } catch (Exception e) {
	        }
	    }

}

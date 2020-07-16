package modelo;

 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Conexion;

public class EmpleadoDao {
	
	Conexion cn = new Conexion();
	java.sql.Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int r;
	
	public Empleado Validar(String user, String pass) {
		Empleado em = new Empleado();
		
		String sql = "Select * from empleado where User=? and Dni=?";
		try {
			con = cn.Coneccion();
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				em.setId(rs.getInt("IdEmpleado"));
				em.setUser(rs.getString("User"));
				em.setDni(rs.getString("Dni"));
				em.setNom(rs.getString("Nombres"));
			}
		} catch (Exception e) {
			 
		}
		return em;
		
	}
	
	//OPERACIONES CRUD
	
	public List listar() {
		String sql = "Select * from empleado";
		List<Empleado> lista = new ArrayList();
		try {
			con=cn.Coneccion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Empleado em = new Empleado();
				em.setId(rs.getInt(1));
				em.setDni(rs.getString(2));
				em.setNom(rs.getString(3));
				em.setTel(rs.getNString(4));
				em.setEstado(rs.getNString(5));
				em.setUser(rs.getNString(6));
				lista.add(em);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void agregar(Empleado em) {
		String sql="insert into empleado(Dni,Nombres,Telefono,Estado,User) values(?,?,?,?,?)";
		
		try {
			con=cn.Coneccion();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getDni());
			ps.setString(2, em.getNom());
			ps.setString(3, em.getTel());
			ps.setString(4, em.getEstado());
			ps.setString(5, em.getUser());
			ps.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	public int actualizar(Empleado em) {
		String sql="update empleado set Dni=?,Nombres=?,Telefono=?,Estado=?,User=? where idEmpleado=?";
		int r=0;
		try {
			con=cn.Coneccion();
			ps=con.prepareStatement(sql);
			ps.setString(1, em.getDni());
			ps.setString(2, em.getNom());
			ps.setString(3, em.getTel());
			ps.setString(4, em.getEstado());
			ps.setString(5, em.getUser());
			ps.setInt(6, em.getId());
		    r =ps.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return r;
	}
	
	public Empleado listarId(int id) {
		Empleado em = new Empleado();
		String sql="Select *from empleado where idEmpleado="+id;
		
		try {
			con=cn.Coneccion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				em.setDni(rs.getString(2));
				em.setNom(rs.getString(3));
				em.setTel(rs.getString(4));
				em.setEstado(rs.getString(5));
				em.setUser(rs.getString(6));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return em;
	}
	
	public void delete(int id) {
	String sql="delete from  empleado  where idEmpleado="+id;
	try {
		con=cn.Coneccion();
		ps=con.prepareStatement(sql);
		ps.executeUpdate();
	} catch (Exception e2) {
		e2.printStackTrace();
	}
}
}

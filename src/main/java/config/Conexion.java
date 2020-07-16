package config;

import java.sql.DriverManager;

import java.sql.Connection;

public class Conexion {
	
	Connection conn;
	
	public Connection Coneccion() {
		
		try {
			String url = "jdbc:mysql://localhost:3306/bd_ventas";
			String user = "root";
			String pass = "";
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection(url,user,pass);
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
	}

}

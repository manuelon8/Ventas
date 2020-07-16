package modelo;

public class Empleado {
	
	int id;
	String dni;
	String nom;
	String tel;
	String estado;
	String  user;
	
	
	public Empleado(int id, String dni, String nom, String tel, String estado, String user) {
		super();
		this.id = id;
		this.dni = dni;
		this.nom = nom;
		this.tel = tel;
		this.estado = estado;
		this.user = user;
	}
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	

}

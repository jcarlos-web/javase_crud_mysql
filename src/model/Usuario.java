/**
 * 
 */
package model;

/**
 * @author <jCarlos:Mendoza/>
 *
 * Proyecto: app_crud_mysql
 * Código para: Usuario.java
 * Fecha: 10/04/2017
 */
public class Usuario {
	
	private int id;
	private String nombre;
	private String ap_pat;
	private String ap_mat;
	private String email;
	private String telefono;
	private String fecha;
	
	public Usuario(){}
	
	public Usuario(int id, String nombre, String ap_pat, String ap_mat, String email, String telefono, String fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ap_pat = ap_pat;
		this.ap_mat = ap_mat;
		this.email = email;
		this.telefono = telefono;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAp_pat() {
		return ap_pat;
	}

	public void setAp_pat(String ap_pat) {
		this.ap_pat = ap_pat;
	}

	public String getAp_mat() {
		return ap_mat;
	}

	public void setAp_mat(String ap_mat) {
		this.ap_mat = ap_mat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	

}

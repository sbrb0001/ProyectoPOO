package lógico;

import java.io.Serializable;

public class Persona implements Serializable{
	
	protected static final long serialVersionUID = 1L;//para que persista en el fichero, ojom com eso
	protected String Cedula;
	protected String Nombre;
	protected String direccion;
	protected String telefono;
	protected boolean estado; 
	protected String usuarioString;
	protected String password;
	

	public Persona(String cedula, String nombre, String direccion, String telefono, boolean estado,
			String usuarioString, String password) {
		super();
		Cedula = cedula;
		Nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.estado = estado;
		this.usuarioString = usuarioString;
		this.password = password;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getUsuarioString() {
		return usuarioString;
	}
	public void setUsuarioString(String usuarioString) {
		this.usuarioString = usuarioString;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package lógico;

public class Cliente {
	
	private String Cedula;
	private String Nombre;
	private String direccion;
	private String telefono;
	
	public Cliente(String cedula, String nombre, String direccion, String telefono) {
		super();
		Cedula = cedula;
		Nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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
	
	
	

}

package lógico;

import java.io.Serializable;

public class Empleado extends Persona {
	
	private static final long serialVersionUID = 1L;
	protected String cargo;

	public Empleado(String cedula, String nombre, String direccion, String telefono, boolean estado,
			String usuarioString, String password, String cargo) {
		super(cedula, nombre, direccion, telefono, estado, usuarioString, password);
		this.cargo = cargo;
	}
	
	public double descuentoEmpleado(double compraTotal) {
		double tot=0;
		//un 5% a empleados normales y un 10% para la administracion
		if(cargo.equalsIgnoreCase("administracion")) {
			tot= compraTotal*0.1;
			
		}else {
			tot= compraTotal*0.05;
		}
		return tot;
		
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}

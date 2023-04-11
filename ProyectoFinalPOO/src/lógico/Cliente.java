package lógico;

import java.io.Serializable;

public class Cliente extends Persona {

	private static final long serialVersionUID = 1L;
	protected String ocupacion;
	protected int cantCompras; //esto es para realizarles descuentos si han hecho mas de 5 compras cada vez que se le hace un descuento la cantidad vuelve a cero
	
	
	public Cliente(String cedula, String nombre, String direccion, String telefono, boolean estado,
			String usuarioString, String password, String ocupacion, int cantCompras) {
		super(cedula, nombre, direccion, telefono, estado, usuarioString, password);
		this.ocupacion = ocupacion;
		this.cantCompras = 0;
	}
	
	public double descuento(double totalCompra) {
		double tot=0;
		
		if (cantCompras % 5==0) {//la cantidad de compra debe ser muktiplo de 5, porque el descuento solo se hace cada 5 compras
			tot= totalCompra*0.2; //HandshakeCompletedEvent un 20 de descuento
		}
		
		return tot;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public int getCantCompras() {
		return cantCompras;
	}
	public void setCantCompras(int cantCompras) {
		this.cantCompras = cantCompras;
	}

	
	
	
	
}

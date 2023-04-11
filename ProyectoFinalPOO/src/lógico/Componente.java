package lógico;

import java.io.Serializable;

public abstract class Componente implements Serializable{

	protected static final long serialVersionUID = 1L;
	protected String Marca;
	protected String numSerie;
	protected int cant;
	protected double precio;

	
	public Componente(String marca, String numSerie, int cant, double precio) {
		super();
		this.Marca = marca;
		this.numSerie = numSerie;
		this.cant = cant;
		this.precio = precio;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public abstract String Dato1();
	public abstract String Dato2();
	public abstract String Dato3();

	public static long getSerialversionuid() {
		return serialVersionUID;
	} 
	
}

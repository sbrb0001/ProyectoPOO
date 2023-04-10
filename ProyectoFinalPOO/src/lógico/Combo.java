package lógico;

import java.util.ArrayList;

public class Combo {
	
	private String nombre;
	private ArrayList<Componente> losComponentes;
	private int cant;
	
	public Combo(ArrayList<Componente> losComponentes, String nombre, int cant) {
		super();
		this.losComponentes = losComponentes;
		this.nombre = nombre;
		this.cant = cant;
	}

	public ArrayList<Componente> getLosComponentes() {
		return losComponentes;
	}

	public void setLosComponentes(ArrayList<Componente> losComponentes) {
		this.losComponentes = losComponentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	public double Precio() {
		
		double precio = 0;
		
		for(Componente componente : losComponentes) {
			precio += componente.precio;
		}
		
		return precio - precio*0.1;
	}
	
	
}

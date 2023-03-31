package lógico;

import java.util.ArrayList;

public class Combo {
	
	private String nombre;
	private ArrayList<Componente> losComponentes;
	
	public Combo(ArrayList<Componente> losComponentes, String nombre) {
		super();
		this.losComponentes = new ArrayList<Componente>();
		this.nombre = nombre;
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
	
	
}

package lógico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Persona persona;
	private ArrayList<Combo> cVendidos;
	private ArrayList<Componente> misComponentes;
	
	
	public Factura(String codigo, Persona persona, ArrayList<Combo> cVendidos, ArrayList<Componente> misComponentes) {
		super();
		this.persona = persona;
		this.cVendidos = cVendidos;
		this.misComponentes = misComponentes;
		this.codigo = codigo;
		;
	}
	
	public ArrayList<Combo> getcVendidos() {
		return cVendidos;
	}
	public void setcVendidos(ArrayList<Combo> cVendidos) {
		this.cVendidos = cVendidos;
	}
	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}
	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

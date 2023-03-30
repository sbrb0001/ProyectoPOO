package lógico;

import java.util.ArrayList;

public class Factura {
	private ArrayList<Cliente> misClientes;
	private ArrayList<Combo> cVendidos;
	private ArrayList<Componente> misComponentes;
	
	public Factura(ArrayList<Cliente> misClientes, ArrayList<Combo> cVendidos, ArrayList<Componente> misComponentes) {
		super();
		this.misClientes = new ArrayList<Cliente>();
		this.cVendidos = new ArrayList<Combo>();
		this.misComponentes = new ArrayList<Componente>();
	}
	
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
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
	
	
	
	
}

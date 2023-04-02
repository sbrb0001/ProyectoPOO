package lógico;

import java.util.ArrayList;

public class Factura {
	private Cliente cliente;
	private ArrayList<Combo> cVendidos;
	private ArrayList<Componente> misComponentes;
	
	public Factura(Cliente cliente, ArrayList<Combo> cVendidos, ArrayList<Componente> misComponentes) {
		super();
		this.cliente = cliente;
		this.cVendidos = new ArrayList<Combo>();
		this.misComponentes = new ArrayList<Componente>();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}

package lógico;

import java.util.ArrayList;

public class TiendaComp {
	private ArrayList<Componente> misComponentes;
	private ArrayList<Combo> cVendidos;
	private ArrayList<Cliente> misClientes;
	private ArrayList<Factura> MisFacturas;
	
	public TiendaComp(ArrayList<Componente> misComponentes, ArrayList<Combo> cVendidos, ArrayList<Cliente> misClientes,
			ArrayList<Factura> misFacturas) {
		super();
		this.misComponentes = new ArrayList<Componente>();
		this.cVendidos = new ArrayList<Combo>();
		this.misClientes = new ArrayList<Cliente>();
		MisFacturas = new ArrayList<Factura>();
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}

	public ArrayList<Combo> getcVendidos() {
		return cVendidos;
	}

	public void setcVendidos(ArrayList<Combo> cVendidos) {
		this.cVendidos = cVendidos;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Factura> getMisFacturas() {
		return MisFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		MisFacturas = misFacturas;
	}
	
	
	
	
	
}

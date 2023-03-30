package lógico;

public abstract class Componente {

	protected String Marca;
	protected String numSerie;
	protected int cant;
	protected double precio;
	
	public Componente(String marca, String numSerie, int cant, double precio) {
		super();
		Marca = marca;
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
	
}

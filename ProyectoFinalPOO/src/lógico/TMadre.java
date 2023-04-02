package lógico;

public class TMadre extends Componente {
	protected String modelo;
	protected String tipoConector;
	protected String tipoRam;
	protected String[] conexiones;
	
	public TMadre(String marca, String numSerie, int cant, double precio, String modelo, String tipoConector,
			String tipoRam, String[] conexiones) {
		super(marca, numSerie, cant, precio);
		this.modelo = modelo;
		this.tipoConector = tipoConector;
		this.tipoRam = tipoRam;
		this.conexiones = new String [6];
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoConector() {
		return tipoConector;
	}

	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}

	public String getTipoRam() {
		return tipoRam;
	}

	public void setTipoRam(String tipoRam) {
		this.tipoRam = tipoRam;
	}

	public String[] getConexiones() {
		return conexiones;
	}

	public void setConexiones(String[] conexiones) {
		this.conexiones = conexiones;
	}

	@Override
	public String Dato1() {
		// TODO Auto-generated method stub
		return modelo;
	}

	@Override
	public String Dato2() {
		// TODO Auto-generated method stub
		return tipoConector;
	}

	@Override
	public String Dato3() {
		// TODO Auto-generated method stub
		return tipoRam;
	}

}

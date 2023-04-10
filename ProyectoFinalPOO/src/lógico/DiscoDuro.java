package lógico;

public class DiscoDuro extends Componente {
	protected String modelo;
	protected double almacenamiento;
	protected String tipoConector;
	protected String tipoAlmacenamieString;
	
	public DiscoDuro(String marca, String numSerie, int cant, double precio, String modelo, double almacenamiento,
			String tipoConector,String tipoAlmacenamieString) {
		super(marca, numSerie, cant, precio);
		this.modelo = modelo;
		this.almacenamiento = almacenamiento;
		this.tipoConector = tipoConector;
		this.tipoAlmacenamieString=tipoAlmacenamieString;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getAlmacenamiento() {
		return almacenamiento;
	}
	public void setAlmacenamiento(double almacenamiento) {
		this.almacenamiento = almacenamiento;
	}
	public String getTipoConector() {
		return tipoConector;
	}
	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}

	@Override
	public String Dato1() {
		// TODO Auto-generated method stub
		return modelo;
	}

	@Override
	public String Dato2() {
		// TODO Auto-generated method stub
		return String.valueOf(almacenamiento);
	}

	@Override
	public String Dato3() {
		// TODO Auto-generated method stub
		return tipoConector;
	}

	public String getTipoAlmacenamieString() {
		return tipoAlmacenamieString;
	}

	public void setTipoAlmacenamieString(String tipoAlmacenamieString) {
		this.tipoAlmacenamieString = tipoAlmacenamieString;
	}
	
}

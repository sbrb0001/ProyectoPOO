package lógico;

public class MicroProcesador extends Componente {
	protected String modelo;
	protected String tipoConexion;
	protected double velocidad;
	protected String tipoProcesamiento;
	
	public MicroProcesador(String marca, String numSerie, int cant, double precio, String modelo, String tipiConexion,
			double velocidad,String tipoProcesamiento) {
		super(marca, numSerie, cant, precio);
		this.modelo = modelo;
		this.tipoConexion = tipiConexion;
		this.velocidad = velocidad;
		this.tipoProcesamiento=tipoProcesamiento;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipiConexion() {
		return tipoConexion;
	}

	public void setTipiConexion(String tipiConexion) {
		this.tipoConexion = tipiConexion;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String Dato1() {
		// TODO Auto-generated method stub
		return modelo;
	}

	@Override
	public String Dato2() {
		// TODO Auto-generated method stub
		return tipoConexion;
	}

	@Override
	public String Dato3() {
		// TODO Auto-generated method stub
		return String.valueOf(velocidad);
	}
	
	
	
}

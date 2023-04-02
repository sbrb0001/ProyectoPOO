package lógico;

public class MicroProcesador extends Componente {
	protected String modelo;
	protected String tipiConexion;
	protected double velocidad;
	
	public MicroProcesador(String marca, String numSerie, int cant, double precio, String modelo, String tipiConexion,
			double velocidad) {
		super(marca, numSerie, cant, precio);
		this.modelo = modelo;
		this.tipiConexion = tipiConexion;
		this.velocidad = velocidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipiConexion() {
		return tipiConexion;
	}

	public void setTipiConexion(String tipiConexion) {
		this.tipiConexion = tipiConexion;
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
		return tipiConexion;
	}

	@Override
	public String Dato3() {
		// TODO Auto-generated method stub
		return String.valueOf(velocidad);
	}
	
	
	
}

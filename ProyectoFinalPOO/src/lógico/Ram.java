package lógico;

public class Ram extends Componente {
	protected float memoria;
	protected String tipoMemoria;
	public Ram(String marca, String numSerie, int cant, double precio, float memoria, String tipoMemoria) {
		super(marca, numSerie, cant, precio);
		this.memoria = memoria;
		this.tipoMemoria = tipoMemoria;
	}
	public float getMemoria() {
		return memoria;
	}
	public void setMemoria(float memoria) {
		this.memoria = memoria;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	
	
}

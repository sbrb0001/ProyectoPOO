package lógico;

public class Ram extends Componente {
	protected double memoria;
	protected String tipoAlmacenamiemtoString;
	protected String tipoMemoria;
	public Ram(String marca, String numSerie, int cant, double precio, double capacidad, String tipoMemoria,String tipoAlmacenamiemtoString) {
		super(marca, numSerie, cant, precio);
		this.memoria = capacidad;
		this.tipoMemoria = tipoMemoria;
		this.tipoAlmacenamiemtoString=tipoAlmacenamiemtoString;
	}
	public double getMemoria() {
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
	@Override
	public String Dato1() {
		// TODO Auto-generated method stub
		return String.valueOf(memoria);
	}
	@Override
	public String Dato2() {
		// TODO Auto-generated method stub
		return tipoMemoria;
	}
	@Override
	public String Dato3() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTipoAlmacenamiemtoString() {
		return tipoAlmacenamiemtoString;
	}
	public void setTipoAlmacenamiemtoString(String tipoAlmacenamiemtoString) {
		this.tipoAlmacenamiemtoString = tipoAlmacenamiemtoString;
	}
	
}

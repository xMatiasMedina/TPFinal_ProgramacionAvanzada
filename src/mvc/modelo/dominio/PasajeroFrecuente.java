package mvc.modelo.dominio;

public class PasajeroFrecuente {

	private int idPasajeroFrecuente;
	private Alianza alianza;		
	private LineaAerea aerolinea; 	
	private String numero;
	private String categoria;
	
	public PasajeroFrecuente() {}
	
	public PasajeroFrecuente(int idPasajeroFrecute, Alianza alianza, LineaAerea aerolinea, String numero, String categoria) {
	    this.idPasajeroFrecuente = idPasajeroFrecuente;
		this.alianza = alianza;
		this.aerolinea = aerolinea;
		this.numero = numero;
		this.categoria = categoria;
	}
	
	public int getIdPasajeroFrecuente() {
		return idPasajeroFrecuente;
	}

	public Alianza getAlianza() {
		return alianza;
	}
	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}
	public LineaAerea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(LineaAerea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}

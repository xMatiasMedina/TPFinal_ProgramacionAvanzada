package mvc.modelo.dominio;

import java.io.Serializable;

public class PasajeroFrecuente implements Serializable {

	private String idPasajeroFrecuente;
	private Alianza alianza;		
	private LineaAerea aerolinea; 	
	private String numero;
	private String categoria;
	
	/*
		Este constructor por defecto se usa para instanciar en memoria un objeto sin conocer aun sus datos,
		que pueden establecerse luego mediante los setters correspondientes, en particular el ID, que sera� generado
		automaticamente por la base de datos
	*/
	public PasajeroFrecuente() {}
	
	// Este constructor se usa para instanciar en memoria un objeto DESPUÉS de haber
    // agregado el pasajero frecuente a la base de datos, que produce un ID automatico
	public PasajeroFrecuente(String idPasajeroFrecute, Alianza alianza, LineaAerea aerolinea, String numero, String categoria) {
	    this.idPasajeroFrecuente = idPasajeroFrecuente;
		this.alianza = alianza;
		this.aerolinea = aerolinea;
		this.numero = numero;
		this.categoria = categoria;
	}
	
	public String getIdPasajeroFrecuente() {
		return idPasajeroFrecuente;
	}

	public void setIdPasajeroFrecuente(String idPasajeroFrecuente) {
		this.idPasajeroFrecuente = idPasajeroFrecuente;
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

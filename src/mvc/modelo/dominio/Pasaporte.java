package mvc.modelo.dominio;

import java.io.Serializable;
import java.util.Date;

public class Pasaporte implements Serializable{
	
	private int idPasaporte;
    private String numero; 
    private String autoridadDeEmision;
	private Pais paisEmision;
	private Date fechaDeEmision;
    private Date fechaDeVencimiento;


	public Pasaporte() {}
	
	public Pasaporte(int idPasaporte, String numero, String autoridadDeEmision, Pais paisEmision, Date fechaDeEmision,
			Date fechaDeVencimiento) {
		this.idPasaporte = idPasaporte;
		this.numero = numero;
		this.autoridadDeEmision = autoridadDeEmision;
		this.paisEmision = paisEmision;
		this.fechaDeEmision = fechaDeEmision;
		this.fechaDeVencimiento = fechaDeVencimiento;
	}
	
	public int getIdPasaporte() {
		return idPasaporte;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero =numero;
	}
	
	public String getAutoridadDeEmision() {
		return autoridadDeEmision;
	}
	public void setAutoridadDeEmision(String autoridadDeEmision) {
		this.autoridadDeEmision = autoridadDeEmision;
	}
	public Pais getPaisEmision() {
		return paisEmision;
	}
	public void setPaisEmision(Pais paisEmision) {
		this.paisEmision = paisEmision;
	}
	
	public Date getFechaDeEmision() {
		return fechaDeEmision;
	}
	public void setFechaDeEmision(Date fechaDeEmision) {
		this.fechaDeEmision = fechaDeEmision;
		
	}
	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}
	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

}

package mvc.modelo.dominio;

import java.io.Serializable;

public class Telefono implements Serializable {
	
	private static int CONT = 0;
	private final int idTelefono;
	private String personal;
	private String celular;
	private String laboral;
	
	public Telefono(String personal, String celular, String laboral) {
		this.idTelefono = ++CONT;
		this.personal = personal;
		this.celular = celular;
		this.laboral = laboral;
	}
	
	public int getIdTelefono() {
		return idTelefono;
	}

	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getLaboral() {
		return laboral;
	}
	public void setLaboral(String laboral) {
		this.laboral = laboral;
	}
	
}

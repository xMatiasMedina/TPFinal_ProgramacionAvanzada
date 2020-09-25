package mvc.modelo.dominio;

import java.io.Serializable;
import java.util.*;

public class Cliente implements Serializable {
	
    private String idCliente;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String cuit;
	private Pasaporte pasaporte;
	private Date fechaDeNacimiento;
	private Telefono telefono;
	private PasajeroFrecuente pasajerofrecuente;
	private Direccion direccion;
	
	/*
		COMENTARIO: Este constructor por defecto se usa para instanciar en memoria un objeto sin conocer a�n sus datos,
		que pueden establecerse luego mediante los setters correspondientes, en particular el ID, que ser� generado
		autom�ticamente por la base de datos
	*/
	public Cliente() {}
	
	// Este constructor se usa para instanciar en memoria un objeto DESPU�S de haber
    // agregado el cliente a la base de datos, que produce un ID autom�tico
	public Cliente(String idCliente, String nombre, String apellido, String dni, String email, String cuit,
			Pasaporte pasaporte, Date fechaDeNacimiento, Telefono telefono, PasajeroFrecuente pasajerofrecuente,
			Direccion direccion) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.cuit = cuit;
		this.pasaporte = pasaporte;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
		this.pasajerofrecuente = pasajerofrecuente;
		this.direccion = direccion;
	}

	public String getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;

	}
	
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public Pasaporte getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public PasajeroFrecuente getPasajerofrecuente() {
		return pasajerofrecuente;
	}
	public void setPasajerofrecuente(PasajeroFrecuente pasajerofrecuente) {
		this.pasajerofrecuente = pasajerofrecuente;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}

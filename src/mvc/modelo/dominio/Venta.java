package mvc.modelo.dominio;

import java.util.Date;

public class Venta {
	private static int CONT = 0;
	private final int idVenta;
	private Cliente cliente;
	private Vuelo vuelo;
	private LineaAerea aerolinea;
    private Date dateVenta; //Fecha y hora de venta
    private String formaDePago; //ver Restricciones
    
//  int cuotas;

	public Venta(Vuelo vuelo, LineaAerea aerolinea, Cliente cliente, Date dateVenta, String formaDePago /*,int cuotas */) {
		this.idVenta = ++CONT;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.dateVenta = dateVenta;
		this.formaDePago = formaDePago;	// Atención, no hay importes !!
		
		FormaDePago forma = FormaDePago.get(formaDePago);
		if(forma == null) {
			throw new RuntimeException("Forma de pago inválida");
		}
		
		if(forma == FormaDePago.TARJETA_CREDITO) {
//			this.cuotas = cuotas;
//		} else {
//			this.cuotas = 1;
		}
	}
    	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Vuelo getVuelo() {
		return vuelo;
	}
	
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	public LineaAerea getAerolinea() {
		return aerolinea;
	}
	
	public void setAerolinea(LineaAerea aerolinea) {
		this.aerolinea = aerolinea;
	}
	
	public Date getDateVenta() {
		return dateVenta;
	}
	
	public void setDateVenta(Date dateVenta) {
		this.dateVenta = dateVenta;
	}
	
	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;	
	}

	public int getIdVenta() {
		return idVenta;
	}
	
}

	



package mvc.modelo.dominio;

import java.util.Date;

public class Venta {
	private String idVenta;
	
	private Cliente cliente;
	private Vuelo vuelo;
	private LineaAerea aerolinea;
    //Aerolinea
    private Date dateVenta; //Fecha y hora de venta
    private String formaDePago; //ver Restricciones
    
//    int cuotas;

   //public Venta() {}
    
    // Este constructor se usa para instanciar en memoria un objeto DESPUÉS de haber
    // agregado la venta a la base de datos, que produce un ID automático
	public Venta(String idVenta, Vuelo vuelo, LineaAerea aerolinea, Cliente cliente, Date dateVenta, String formaDePago /*,int cuotas */) {
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.dateVenta = dateVenta;
		this.formaDePago = formaDePago;	// Ojo con esto porque no hay importes !!
		
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
    // Este constructor se usa para instanciar en memoria un objeto ANTES de haber
    // agregado el vuelo a la base de datos, POR LO QUE DESCONOCEMOS CUÁL SERÁ SU id
	public Venta(Vuelo vuelo, LineaAerea aerolinea, Cliente cliente, Date dateVenta, String formaDePago /*,int cuotas */) {
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.dateVenta = dateVenta;
		this.formaDePago = formaDePago;	// Ojo con esto porque no hay importes !!
		
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
	
	
	public String getIdVenta() {
		return idVenta;
	}
	
	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
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

}

	



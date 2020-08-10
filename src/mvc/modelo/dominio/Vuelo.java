package mvc.modelo.dominio;


import java.util.*;

/*
10) Los n�meros de vuelo deber�n formarse como:
a. Las primeras 2 letras del nombre de la aerol�nea, en el caso que sea un nombre
compuesto (Ej. Aerol�neas Argentinas) se formar� con la primer letra de los primeras
2 palabras (en el ejemplo: AA)
b. Un guion medio (-)
c. El valor n�mero del n�mero con una longitud de 4 d�gitos -> Esto es un metodo
d. Ejemplo: AR-1234
*/

public class Vuelo {
		private static int CONT = 1000;
		private final String idVuelo;
	    private int cantidadDeAsientos;
	    private Aeropuerto aeropuertoDeSalida;
	    private Aeropuerto aeropuertoDeLlegada;
	    private Date dateSalida; //fecha y hora de salida
	    private Date dateLlegada; //fecha y hora de llegada
	    private String tiempo; //tiempo de vuelo
	    private int vendidos;
		
		public Vuelo(LineaAerea aerolinea, int cantidadDeAsientos, Aeropuerto aeropuertoDeSalida, Aeropuerto aeropuertoDeLlegada,
				Date dateSalida, Date dateLlegada, String tiempo) {
					
			int id = ++CONT;

			idVuelo = aerolinea.getIniciales() + "-" + id; //Lo arregle
			
			this.cantidadDeAsientos = cantidadDeAsientos;
			this.aeropuertoDeSalida = aeropuertoDeSalida;
			this.aeropuertoDeLlegada = aeropuertoDeLlegada;
			this.dateSalida = dateSalida;
			this.dateLlegada = dateLlegada;
			this.tiempo = tiempo;
			
			vendidos = 0;
		}
		
		public String getIdVuelo() {
			return idVuelo;
		}
		
		public static int getCont() {
			return CONT;
		}
		
		public int getCantidadDeAsientos() {
			return cantidadDeAsientos;
		}
		public void setCantidadDeAsientos(int cantidadDeAsientos) {
			this.cantidadDeAsientos = cantidadDeAsientos;
		}	
			
		public Aeropuerto getAeropuertoDeSalida() {
			return aeropuertoDeSalida;
		}
		
		public void setAeropuertoDeSalida(Aeropuerto aeropuertoDeSalida) {
			this.aeropuertoDeSalida = aeropuertoDeSalida;
		}
		
		public Aeropuerto getAeropuertoDeLlegada() {
			return aeropuertoDeLlegada;
		}
		
		public void setAeropuertoDeLlegada(Aeropuerto aeropuertoDeLlegada) {
			this.aeropuertoDeLlegada = aeropuertoDeLlegada;
		}
		
		public Date getDateSalida() {
			return dateSalida;
		}
		
		public void setDateSalida(Date dateSalida) {
			this.dateSalida = dateSalida;
		}
		
		public Date getDateLlegada() {
			return dateLlegada;
		}
		public void setDateLlegada(Date dateLlegada) {
			this.dateLlegada = dateLlegada;
		}
		
		public String getTiempo() {
			return tiempo;
		}
		
		public void setTiempo(String tiempo) {
			this.tiempo = tiempo;
		}
		
		// permite buscar vuelos a partir de su identificador
		// determina el criterio para comparar esta instancia (this) con otra instancia (otro)
		
		public boolean equals(Vuelo otro) {
			return this.idVuelo.equals(otro.idVuelo);
		}
		
		public void registrarVenta() {
			vendidos++;
		}
		
		public int getDisponibles() {
			return cantidadDeAsientos - vendidos;
		}
}















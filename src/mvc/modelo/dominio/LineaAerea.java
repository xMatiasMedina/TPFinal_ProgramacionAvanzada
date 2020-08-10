package mvc.modelo.dominio;

import java.util.*;

public class LineaAerea {
	
	private static int CONT = 0;
	private String iniciales;
	private String aerolinea;
	private Alianza alianza;
	private ArrayList<Vuelo> vuelos;
	private int id;

	public LineaAerea() {}

	public LineaAerea(String aerolinea, Alianza alianza) {
		id = ++CONT;//Establece un valor autom�tico incremental como Id
		//Se generan las iniciales de la l�nea a�rea a partir del nombre.
		String s[] = aerolinea.split(" ");
		if(s.length == 1) {
			iniciales= aerolinea.substring(0, 2);
		} else {
			iniciales = s[0].charAt(0)+""+s[1].charAt(0); //Esto lo acomode mejor
		}
		this.aerolinea = aerolinea;//Se asigna localmente el nombre de aerol�nea recibido por par�metro.
		this.alianza = alianza;//Se asigna localmente la Alianza recibida por par�metro.
	}
	
	public String getIniciales() {
		return iniciales;
	}
	
	public int getId() {
		return id;
	}

	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public Alianza getAlianza() {
		return alianza;
	}
	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}
	
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Vuelo buscarVuelo(String idVuelo) {
		Vuelo buscado = null;
		int i = 0;
		while(i < vuelos.size() && buscado == null) {
			if(vuelos.get(i).getIdVuelo().equals(idVuelo)) {
				buscado = vuelos.get(i);
			} else {
				i++;
			}
		}
		return buscado;
	}
	
	public void removeVuelo(String idVuelo) {
		Vuelo eliminado = buscarVuelo(idVuelo);
		if(eliminado != null) {
			vuelos.remove(eliminado);
		} else {
			throw new RuntimeException("No existe el vuelo" + idVuelo);
		}
	}
	
}

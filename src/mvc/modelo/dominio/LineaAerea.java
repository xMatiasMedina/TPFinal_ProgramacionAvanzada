
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
	
	// Este constructor se usa para instanciar en memoria un objeto DESPUÉS de haber
    // agregado la Linea Aerea a la base de datos, que produce un ID automático
	
	/*
		Las iniciales se determinan directa y unívocamente a partir del nombre de la aerolínea, por lo tanto
		no sería un parámetro a recibir en el construnctor sino que se establecen inmediatamente a partir del nombre.
		Las iniciales NO SON el ID, sino una especie de abreviatura del nombre que se usa para referirse a la aerolínea
		(ver clase Vuelo)
	*/

	public LineaAerea(String aerolinea, Alianza alianza) {
		id = ++CONT;//Establece un valor automatico incremental como Id
		//Se generan las iniciales de la linea aerea a partir del nombre.
		String s[] = aerolinea.split(" ");
		if(s.length == 1) {
			iniciales= aerolinea.substring(0, 2);
		} else {
			iniciales = s[0].charAt(0)+""+s[1].charAt(0); //Esto lo acomode mejor
		}
		this.aerolinea = aerolinea;//Se asigna localmente el nombre de aerolï¿½nea recibido por parï¿½metro.
		this.alianza = alianza;//Se asigna localmente la Alianza recibida por parametro.
	}
	
	
	public String getIniciales() {
		return iniciales;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
//>>>>>>> branch 'master' of https://github.com/xMatiasMedina/TPFinal_ProgramacionAvanzada.git

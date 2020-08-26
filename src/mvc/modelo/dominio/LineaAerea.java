package mvc.modelo.dominio;

import java.util.*;

public class LineaAerea {
	
	private String idLineaAerea;
	private String iniciales;
	private String aerolinea;
	private Alianza alianza;
	private ArrayList<Vuelo> vuelos;
	
	public LineaAerea() {}
	
	
	// Este constructor se usa para instanciar en memoria un objeto DESPU�S de haber
    // agregado la Linea Aerea a la base de datos, que produce un ID autom�tico
	
	/*
		Las iniciales se determinan directa y un�vocamente a partir del nombre de la aerol�nea, por lo tanto
		no ser�a un par�metro a recibir en el construnctor sino que se establecen inmediatamente a partir del nombre.
		Las iniciales NO SON el ID, sino una especie de abreviatura del nombre que se usa para referirse a la aerol�nea
		(ver clase Vuelo)
	*/
	public LineaAerea(String idLineaAerea, String aerolinea, Alianza alianza, ArrayList<Vuelo> vuelos) {
		this.idLineaAerea=idLineaAerea;
		this.aerolinea=aerolinea;
		this.alianza=alianza;
		this.vuelos=vuelos;
		//Se generan las iniciales de la l�nea a�rea a partir del nombre.
		String s[] = aerolinea.split(" ");
		if(s.length == 1) {
			iniciales= aerolinea.substring(0, 2);
		} else {
			iniciales = s[0].substring(0, 1) + s[1].substring(0, 1);
		}
	}

	/*
		COMENTARIO: Este constructor se usar�a ANTES de agregar la L�nea A�rea a la base de datos, pues �sta producir�
		un ID autom�ticamente que luego se incorpora a la instancia a trav�s del m�todo setIdLineaAerea().
	
	*/
	public LineaAerea(String aerolinea, Alianza alianza, ArrayList<Vuelo> vuelos) {
		//Se generan las iniciales de la l�nea a�rea a partir del nombre.
		String s[] = aerolinea.split(" ");
		if(s.length == 1) {
			iniciales= aerolinea.substring(0, 2);
		} else {
			iniciales = s[0].substring(0, 1) + s[1].substring(0, 1);
		}
		this.vuelos=vuelos;
		this.aerolinea = aerolinea;//Se asigna localmente el nombre de aerol�nea recibido por par�metro.
		this.alianza = alianza;//Se asigna localmente la Alianza recibida por par�metro.
	}
	
	
	public String getIniciales() {
		return iniciales;
	}
	
	public String getIdLineaAerea() {
		return idLineaAerea;
	}
	
	public void setIdLineaAerea(String idLineaAerea) {
		this.idLineaAerea= idLineaAerea;
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

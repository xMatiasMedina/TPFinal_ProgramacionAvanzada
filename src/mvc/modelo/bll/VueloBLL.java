package mvc.modelo.bll;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import mvc.modelo.dominio.Venta;
import mvc.modelo.dominio.Vuelo;

public class VueloBLL {

	public boolean disponible(Vuelo vuelo, List<Venta> ventas) {
		int cantidad = vuelo.getCantidadDeAsientos();
		int ocupados = ventas.stream().filter
				(a -> a.getVuelo().getIdVuelo().equals(vuelo.getIdVuelo())).collect(Collectors.toList()).size();
		return cantidad > ocupados;
	}
	
	public void cargarTiempodeVuelo(Vuelo vuelo) {
		LocalDate time1 = vuelo.getDateSalida().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		LocalDate time2 = vuelo.getDateLlegada().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		vuelo.setTiempo((""+Duration.between(time1, time2).getSeconds()/3600));
	}
}

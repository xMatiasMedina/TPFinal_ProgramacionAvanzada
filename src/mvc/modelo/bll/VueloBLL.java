package mvc.modelo.bll;

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
}

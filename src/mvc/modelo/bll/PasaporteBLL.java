package mvc.modelo.bll;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import mvc.modelo.dominio.Pasaporte;
import mvc.modelo.dominio.Vuelo;

public class PasaporteBLL {
	
	public boolean validar(Pasaporte pasaporte, Vuelo vuelo) {
		boolean result = pasaporte.getFechaDeEmision().before(vuelo.getDateSalida());
		LocalDate vencimiento = pasaporte.getFechaDeVencimiento().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		LocalDate llegada = vuelo.getDateLlegada().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		return result && (Period.between(llegada, vencimiento).getMonths() >= 6);
	}
}

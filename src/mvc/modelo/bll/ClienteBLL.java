package mvc.modelo.bll;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import mvc.modelo.dominio.Cliente;

public class ClienteBLL {
	public boolean mayorde18(Cliente cliente) {
		LocalDate time1 = cliente.getFechaDeNacimiento().toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		Period period = Period.between(time1, LocalDate.now());
		return period.getYears()>=18;
	}
}

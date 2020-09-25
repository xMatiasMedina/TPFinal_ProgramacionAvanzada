package mvc.modelo.dao.factories;

import mvc.modelo.dao.daoimplementations.stream.ClienteDAOImpObjectStream;
import mvc.modelo.dao.idaos.ClienteDAO;

public class ClienteDAOFactory {
	public static ClienteDAO getClienteDAOImp(ImpType data) {
		switch(data) {
			case STREAM:
				return new ClienteDAOImpObjectStream();
			case SQLSERVER:
				return null; //No implementado aun
			default:
				throw new RuntimeException("No existe tal implementacion");
		}
	}
}

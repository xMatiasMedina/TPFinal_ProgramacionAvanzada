package mvc.modelo.dao.factories;

import mvc.modelo.dao.daoimplementations.sqlserver.VentaDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.VentaDAOImpObjectStream;
import mvc.modelo.dao.idaos.VentaDAO;

public class VentaDAOFactory {
	public static VentaDAO getVentaDAO(ImpType data) {
		switch(data) {
			case STREAM:
				return new VentaDAOImpObjectStream();
			case SQLSERVER:
				return new VentaDAOImpSQLServer();
			default:
				throw new RuntimeException("No existe tal implementacion");
		}
	}
}

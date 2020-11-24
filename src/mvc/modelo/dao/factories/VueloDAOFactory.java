package mvc.modelo.dao.factories;

import mvc.modelo.dao.daoimplementations.sqlserver.VueloDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.VueloDAOImpObjectStream;
import mvc.modelo.dao.idaos.VueloDAO;

public class VueloDAOFactory {
	
	public static VueloDAO getVueloDAO(ImpType data) {
		switch(data) {
			case STREAM:
				return new VueloDAOImpObjectStream();
			case SQLSERVER:
				return new VueloDAOImpSQLServer();
			default:
				throw new RuntimeException("No existe tal implementacion");
		}
	}
}

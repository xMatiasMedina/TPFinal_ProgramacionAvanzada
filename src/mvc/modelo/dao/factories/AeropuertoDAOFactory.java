package mvc.modelo.dao.factories;

import mvc.modelo.dao.daoimplementations.sqlserver.AeropuertoDAOImplSQLServer;
import mvc.modelo.dao.daoimplementations.stream.AeropuertoDAOImpStream;
import mvc.modelo.dao.idaos.AeropuertoDAO;

public class AeropuertoDAOFactory {
	public static AeropuertoDAO getAeropuertoDAO(ImpType data) {
		switch(data) {
			case STREAM:
				return new AeropuertoDAOImpStream();
			case SQLSERVER:
				return new AeropuertoDAOImplSQLServer();
			default:
				throw new RuntimeException("No existe tal implementacion");
		}
	}
}

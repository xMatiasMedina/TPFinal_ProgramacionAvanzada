package mvc.modelo.dao.factories;

import mvc.modelo.dao.daoimplementations.sqlserver.LineaAereaDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.LineaAereaDAOImpObjectStream;
import mvc.modelo.dao.idaos.LineaAereaDAO;

public class LineaAereaDAOFactory {
	
	public static LineaAereaDAO getLineaAereaDAO(ImpType data) {
		switch(data) {
			case STREAM:
				return new LineaAereaDAOImpObjectStream();
			case SQLSERVER:
				return new LineaAereaDAOImpSQLServer();
			default:
				throw new RuntimeException("No existe tal implementacion");
		}
	}
}

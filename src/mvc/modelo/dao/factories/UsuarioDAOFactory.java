package mvc.modelo.dao.factories;

import mvc.modelo.dao.daoimplementations.stream.UsuarioDAOImpObjectStream;
import mvc.modelo.dao.idaos.UsuarioDAO;

public class UsuarioDAOFactory {
	public static UsuarioDAO getUsuarioDAOImp(ImpType data) {
		switch(data) {
			case STREAM:
				return new UsuarioDAOImpObjectStream();
			case SQLSERVER:
				return null; //No implementado aun
			default:
				throw new RuntimeException("No existe tal implementacion");
		}
	}
}

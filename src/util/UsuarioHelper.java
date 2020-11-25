package util;

import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.factories.UsuarioDAOFactory;
import mvc.modelo.dao.idaos.UsuarioDAO;
import mvc.modelo.dominio.Usuario;

public class UsuarioHelper {
	
	private static UsuarioDAO dao;
	
	static {
		dao = UsuarioDAOFactory.getUsuarioDAOImp(ImpType.STREAM);
	}
	
	public static void addAdmin() {
		if(dao.getUsuario("admin") == null)
			dao.addUser(new Usuario("-1", "admin", "1234", "admin"));
	}
}

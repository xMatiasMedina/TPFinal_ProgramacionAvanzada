package mvc.modelo.dao.daoimplementations.sqlserver;

import java.util.Arrays;
import java.util.List;

import mvc.modelo.dao.idaos.PaisDAO;
import mvc.modelo.dominio.Pais;

//Singleton para facilitar uso continuo

public class PaisDAOImpSQLServer implements PaisDAO{
	
	private static PaisDAOImpSQLServer instance;

	@Override
	public List<String> getAllasString() {
		return null;//Arrays.asList("Argentina","Brasil","Otro");
	}
	
	public static PaisDAOImpSQLServer getInstance() {
		if(instance == null)
			instance = new PaisDAOImpSQLServer();
		return instance;
	}

	@Override
	public Pais getPais(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

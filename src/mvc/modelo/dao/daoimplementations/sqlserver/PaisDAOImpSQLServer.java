package mvc.modelo.dao.daoimplementations.sqlserver;

import java.util.Arrays;
import java.util.List;

import mvc.modelo.dao.idaos.PaisDAO;

//Singleton para facilitar uso continuo

public class PaisDAOImpSQLServer implements PaisDAO{
	
	private static PaisDAOImpSQLServer instance;

	@Override
	public List<String> getAll() {
		return Arrays.asList("Argentina","Brasil","Otro");
	}
	
	public static PaisDAOImpSQLServer getInstance() {
		if(instance == null)
			instance = new PaisDAOImpSQLServer();
		return instance;
	}
	
}

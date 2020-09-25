package mvc.modelo.dao.daoimplementations.sqlserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import mvc.modelo.dao.idaos.ProvinciasDAO;
import mvc.modelo.dominio.Provincia;

//Singleton para facilitar uso continuo

public class ProvinciasDAOImpSQLServer implements ProvinciasDAO{
	
	private static ProvinciasDAOImpSQLServer instance;
		
	public ProvinciasDAOImpSQLServer() {
		
	}

	@Override
	public List<String> getAllasString() {
		return null;//Arrays.asList("Neuquen","BA","Jujuy");
	}
	
	public static ProvinciasDAOImpSQLServer getInstance() {
		if(instance == null)
			instance = new ProvinciasDAOImpSQLServer();
		return instance;
	}

	@Override
	public Provincia getProvincia(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
}

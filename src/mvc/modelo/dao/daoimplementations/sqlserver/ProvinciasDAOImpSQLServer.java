package mvc.modelo.dao.daoimplementations.sqlserver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import mvc.modelo.dao.idaos.ProvinciasDAO;
import mvc.modelo.dominio.Pais;
import mvc.modelo.dominio.Provincia;
import util.Connect;

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
	public Provincia getProvincia(String id) {
		Connection con = null;
		PreparedStatement psProv;
		
		con = Connect.getConnection();
		Provincia pr = new Provincia();
		try {
			psProv = con.prepareStatement("SELECT nombre_provincia FROM dbo.provincia WHERE id=?");
			psProv.setString(1, id);
			
			
			ResultSet rs=psProv.executeQuery();
			
			while (rs.next()) {
				pr.setNombre(rs.getString("nombre_provincia"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return pr;
	}
}

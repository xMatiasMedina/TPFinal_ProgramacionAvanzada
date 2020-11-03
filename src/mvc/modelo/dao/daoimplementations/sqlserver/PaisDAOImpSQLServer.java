package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import mvc.modelo.dao.idaos.PaisDAO;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Pais;
import util.Connect;

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
	public Pais getPais(String id) {
		
		Connection con = null;
		PreparedStatement psPais;
		
		con = Connect.getConnection();
		Pais p = new Pais();
		try {
			psPais = con.prepareStatement("SELECT nombre_pais FROM dbo.pais WHERE id=?");
			psPais.setString(1, id);
			
			
			ResultSet rs=psPais.executeQuery();
			
			while (rs.next()) {
			p.setNombre(rs.getString("nombre_pais"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return p;
	}
	
}

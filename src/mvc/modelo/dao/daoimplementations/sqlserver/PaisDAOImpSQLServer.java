package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		List<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement psPais;
		
		con = Connect.getConnection();
		Pais p = new Pais();
		try {
			psPais = con.prepareStatement("SELECT * FROM dbo.pais");
			
			ResultSet rs=psPais.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString("nombre_pais"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
	
	public static PaisDAOImpSQLServer getInstance() {
		if(instance == null)
			instance = new PaisDAOImpSQLServer();
		return instance;
	}

	@Override
	public Pais getPais(int idpais) {
		String id = String.valueOf(idpais);
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
	
	@Override
	public Pais getPais(String nombre) {
		
		Connection con = null;
		PreparedStatement psPais;
		
		con = Connect.getConnection();
		Pais p = new Pais();
		try {
			psPais = con.prepareStatement("SELECT * FROM dbo.pais WHERE nombre_pais=?");
			psPais.setString(1, nombre);
			
			
			ResultSet rs=psPais.executeQuery();
			
			while (rs.next()) {
			p.setIdPais(Integer.parseInt(rs.getString("id")));
			p.setNombre(rs.getString("nombre_pais"));
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return p;
	}

	@Override
	public void addPais(Pais pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePais(Pais pais) {
		// TODO Auto-generated method stub
		
	}
}

package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.PasaporteDAO;
import mvc.modelo.dominio.Pasaporte;

import util.Connect;

public class PasaporteDAOImpSQLServer implements PasaporteDAO {

	@Override
	public Pasaporte obtenerPasaporte(String id) {

		Connection con = null;
		PreparedStatement psPas;
		
		con = Connect.getConnection();
		Pasaporte p = new Pasaporte();
		try {
			psPas = con.prepareStatement("SELECT * FROM dbo.pasaporte WHERE id=?");
			psPas.setString(1, id);
					
			ResultSet rs=psPas.executeQuery();
		
			while (rs.next()) {
				//setear valores
				p.setNumero(rs.getString("nro_pasaporte"));
				p.setAutoridadDeEmision(rs.getString("autoridad_emision"));
				p.setFechaDeEmision(rs.getDate("fecha_emision"));
				p.setFechaDeVencimiento(rs.getDate("fecha_vencimiento"));
				
				String idPais = rs.getString("id_pais");
				PaisDAOImpSQLServer PaisDAO = new PaisDAOImpSQLServer();
				p.setPaisEmision(PaisDAO.getPais(idPais));
				
				
			}	
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return p;
	}

}

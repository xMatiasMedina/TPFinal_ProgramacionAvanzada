package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.AeropuertoDAO;
import mvc.modelo.dominio.Aeropuerto;
import util.Connect;

public class AeropuertoDAOImplSQLServer implements AeropuertoDAO {

	@Override
	public Aeropuerto obtenerAeropuerto(String id) {
		
		Connection con = null;
		PreparedStatement psEropuerto;
		
		con = Connect.getConnection();
		Aeropuerto ae = new Aeropuerto();
		try {
			psEropuerto = con.prepareStatement("SELECT * FROM dbo.aeropuerto WHERE id=?");
			psEropuerto.setString(1, id);
					
			ResultSet rs=psEropuerto.executeQuery();
		
			while (rs.next()) {
				//setear valores
				ae.setIdentificacion(id);
				ae.setCiudad(rs.getString("ciudad"));
								
				String idPais = rs.getString("id_pais");
				String idProvincia = rs.getString("id_provincia");
				
				//llamo a metodo obtener de cada clase
				PaisDAOImpSQLServer PaisDAO = new PaisDAOImpSQLServer();
				ae.setPais(PaisDAO.getPais(idPais));
				
				ProvinciasDAOImpSQLServer ProvinciaDAO = new ProvinciasDAOImpSQLServer();
				ae.setProvincia(ProvinciaDAO.getProvincia(idProvincia));
				
				
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return ae;
		
		
	}

}

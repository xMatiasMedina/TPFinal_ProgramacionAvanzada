package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.DireccionDAO;
import mvc.modelo.dominio.Direccion;
import util.Connect;

public class DireccionDAOImplSQLServer implements DireccionDAO {

	@Override
	public Direccion obtenerDireccion(String id) {

		Connection con = null;
		PreparedStatement psCliente;
		
		con = Connect.getConnection();
		Direccion d = new Direccion();
		try {
			psCliente = con.prepareStatement("SELECT * FROM dbo.direccion WHERE id=?");
			psCliente.setString(1, id);
					
			ResultSet rs=psCliente.executeQuery();
		
			while (rs.next()) {
				//setear valores
				d.setIdDireccion(id);
				d.setCalle(rs.getString("calle"));
				d.setAltura(rs.getString("altura"));
				d.setCiudad(rs.getString("ciudad"));
				d.setCodigoPostal(rs.getString("codigo_postal"));
				
				String idPais = rs.getString("id_pais");
				String idProvincia = rs.getString("id_provincia");
				
				//llamo a metodo obtener de cada clase
				PaisDAOImpSQLServer PaisDAO = new PaisDAOImpSQLServer();
				d.setPais(PaisDAO.getPais(idPais));
				
				ProvinciasDAOImpSQLServer ProvinciaDAO = new ProvinciasDAOImpSQLServer();
				d.setProvincia(ProvinciaDAO.getProvincia(idProvincia));
				
				
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return d;

}
	
	
}

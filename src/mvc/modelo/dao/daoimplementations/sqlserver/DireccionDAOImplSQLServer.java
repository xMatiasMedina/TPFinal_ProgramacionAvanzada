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
			psCliente = con.prepareStatement("SELECT * FROM dbo.cliente WHERE id=?");
			psCliente.setString(1, id);
					
			ResultSet rs=psCliente.executeQuery();
		
			while (rs.next()) {
				//falta setear valores
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return d;

}
	
	
}

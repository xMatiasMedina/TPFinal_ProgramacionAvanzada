package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.TelefonoDAO;
import mvc.modelo.dominio.Telefono;
import util.Connect;

public class TelefonoDAOImpSQLServer implements TelefonoDAO{

	@Override
	public Telefono obtenerTelefono(String id) {
		
		Connection con = null;
		PreparedStatement psTel;
		
		con = Connect.getConnection();
		Telefono t = new Telefono(null, null, null);
		try {
			psTel = con.prepareStatement("SELECT * FROM dbo.telefono WHERE id=?");
			psTel.setString(1, id);
					
			ResultSet rs=psTel.executeQuery();
		
			while (rs.next()) {
				//setear valores
				t.setPersonal(rs.getString("personal"));
				t.setCelular(rs.getString("celular"));
				t.setLaboral(rs.getString("laboral"));
			}	
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return t;
		
	}

}

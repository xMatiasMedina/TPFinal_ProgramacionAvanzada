package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.PasajeroFrecuenteDAO;
import mvc.modelo.dominio.Alianza;
import mvc.modelo.dominio.PasajeroFrecuente;
import mvc.modelo.dominio.Pasaporte;
import util.Connect;

public class PasajeroFrecuenteDAOImpSQLServer implements PasajeroFrecuenteDAO{

	@Override
	public PasajeroFrecuente obtenerPasajeroFrecuente(String id) {


		Connection con = null;
		PreparedStatement psPasFrec;
		
		con = Connect.getConnection();
		PasajeroFrecuente pf = new PasajeroFrecuente();
		try {
			psPasFrec = con.prepareStatement("SELECT * FROM dbo.pasajero_frecuente WHERE id=?");
			psPasFrec.setString(1, id);
					
			ResultSet rs=psPasFrec.executeQuery();
		
			while (rs.next()) {
				//setear valores
				pf.setIdPasajeroFrecuente(id);
				
				pf.setAlianza(Alianza.valueOf(rs.getString("alianza")));
				
				pf.setNumero(rs.getString("numero"));
				pf.setCategoria(rs.getString("categoria"));
						
			}	
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return pf;
		
	}

}

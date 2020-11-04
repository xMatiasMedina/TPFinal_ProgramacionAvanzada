package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.LineaAereaDAO;
import mvc.modelo.dominio.Alianza;
import mvc.modelo.dominio.LineaAerea;
import mvc.modelo.dominio.Telefono;
import util.Connect;

public class LineaAereaDAOImpSQLServer implements LineaAereaDAO {

	@Override
	public boolean registrarLAerea(LineaAerea la) {
boolean exito = false;
		
		//query
		String insertCliente = "INSERT INTO dbo.aerolinea (id_aerolinea, nombre_aerolinea, alianza)";
		
		try (Connection connection = Connect.getConnection();
			PreparedStatement psUpdateLineaAerea = 
					connection.prepareStatement(insertCliente)){
			//valores para insertar
			psUpdateLineaAerea.setInt(1, la.getId());
			psUpdateLineaAerea.setString(2, la.getAerolinea());
			psUpdateLineaAerea.setString(3, la.getAlianza().value.toString());
						
			psUpdateLineaAerea.execute();
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return exito;
	}

	@Override
	public void modificarLAerea(LineaAerea la) {
	
		//query
		String insertCliente = "UPDATE dbo.aerolinea SET id_aerolinea=?, nombre_aerolinea=?, alianza=?)" +
		" VALUES (?,?,?)"		;
		
		try (Connection connection = Connect.getConnection();
			PreparedStatement psInsertLineaAerea = 
					connection.prepareStatement(insertCliente)){
			//valores para insertar
			psInsertLineaAerea.setInt(1, la.getId());
			psInsertLineaAerea.setString(2, la.getAerolinea());
			psInsertLineaAerea.setString(3, la.getAlianza().value.toString());
						
			psInsertLineaAerea.execute();
					
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    
	   		
	}

	@Override
	public LineaAerea obtenerLAerea(String nombre) {
		Connection con = null;
		PreparedStatement psLAerea;
		
		con = Connect.getConnection();
		LineaAerea la = new LineaAerea();
		try {
			psLAerea = con.prepareStatement("SELECT * FROM dbo.telefono WHERE nombre_aerolinea=?");
			psLAerea.setString(1, nombre);
					
			ResultSet rs=psLAerea.executeQuery();
		
			while (rs.next()) {
				//setear valores
				la.setAerolinea(rs.getString("nombre_aerolinea"));
				la.setAlianza(Alianza.valueOf(rs.getString("alianza")));
				la.setId(rs.getInt("id_aerolinea"));
			}	
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return la;
	}
	
	
	@Override
	public LineaAerea obtenerLAerea(int id) {
		Connection con = null;
		PreparedStatement psLAerea;
		
		con = Connect.getConnection();
		LineaAerea la = new LineaAerea();
		try {
			psLAerea = con.prepareStatement("SELECT * FROM dbo.telefono WHERE id_aerolinea=?");
			psLAerea.setInt(1, id);
					
			ResultSet rs=psLAerea.executeQuery();
		
			while (rs.next()) {
				//setear valores
				la.setAerolinea(rs.getString("nombre_aerolinea"));
				la.setAlianza(Alianza.valueOf(rs.getString("alianza")));
				la.setId(rs.getInt("id_aerolinea"));
			}	
			
		}catch (SQLException e) {
			System.out.println(e);
		}
			return la;
	}


	@Override
	public boolean eliminarLAerea(LineaAerea la) {
boolean exito = false;
		
		Connection con = null;
		PreparedStatement ps;
                
			con = Connect.getConnection();
        			
			try {
				ps = con.prepareStatement("DELETE FROM dbo.aerolinea WHERE id=?");
				ps.setString(1, la.getAerolinea());
		
		 if(ps.executeUpdate()>0)
	            {
			 exito=true;
	            }
					
	} catch (SQLException e) {
			System.out.println(e);
		}
			return exito;
	}
}

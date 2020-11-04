package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.modelo.dao.idaos.VentaDAO;
import mvc.modelo.dominio.Venta;
import util.Connect;

public class VentaDAOImpSQLServer implements VentaDAO {

	@Override
	public boolean registrarVenta(Venta v) {
boolean exito = false;
		
		//query
		String insertVenta = "INSERT INTO dbo.ventas (id_venta, fec_hs_venta, forma_pago, id_cliente, id_vuelo, id_aerolinea"+
		" VALUES (?,?,?,?,?,?)"		;
		
		try (Connection connection = Connect.getConnection();
			PreparedStatement psInsertVenta = 
					connection.prepareStatement(insertVenta)){
			//valores para insertar
			psInsertVenta.setString(1, v.getIdVenta());
			psInsertVenta.setDate(2,(Date)v.getDateVenta());
			psInsertVenta.setString(3, v.getFormaDePago().getValue());
			psInsertVenta.setString(4, v.getCliente().getIdCliente());
			psInsertVenta.setString(5, v.getVuelo().getIdVuelo());
			psInsertVenta.setString(6, v.getAerolinea().getAerolinea()); 
								
			psInsertVenta.execute();
			exito=true;
			
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
	public void modificarVenta(Venta v) {
		
		//query
		String insertVenta = "UPDATE dbo.ventas SET id_venta=?, fec_hs_venta=?, forma_pago=?";
		
		try (Connection connection = Connect.getConnection();
			PreparedStatement psUpdateVenta = 
					connection.prepareStatement(insertVenta)){
			//valores para insertar
			psUpdateVenta.setString(1, v.getIdVenta());
			psUpdateVenta.setDate(2,(Date)v.getDateVenta());
			psUpdateVenta.setString(3, v.getFormaDePago().getValue());
											
			psUpdateVenta.execute();
						
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    
		
	}

	@Override
	public Venta obtenerVenta(String id) {

		Connection con = null;
		PreparedStatement psVentas;
		
		con = Connect.getConnection();
		Venta v = new Venta(null, null, null, null, null, null);
		try {
			psVentas = con.prepareStatement("SELECT * FROM dbo.ventas WHERE id=?");
			psVentas.setString(1, id);
			
			
			ResultSet rs=psVentas.executeQuery();
			
			while (rs.next()) {
				v.setIdVenta(id); 
				v.setDateVenta(rs.getDate("fec_hs_venta"));
				v.setFormaDePago(rs.getString("forma_pago"));
	            
	            String idCliente = rs.getString("id_cliente");
	            String idVuelo = rs.getString("id_vuelo");
	            String idAerolinea = rs.getString("id_aerolinea");
	          	            
	            //llamo a metodo obtener de cada clase
	            ClienteDAOImpSQLServer CliDAO = new ClienteDAOImpSQLServer();
	            v.setCliente(CliDAO.obtenerCliente(idCliente));
	            	            
	            // pasaporte y pasajero frecuente
	            VueloDAOImpSQLServer VuelDAO = new VueloDAOImpSQLServer();
				v.setVuelo(VuelDAO.obtenerVuelo(idVuelo));
	            
	            LineaAereaDAOImpSQLServer LaerDAO = new LineaAereaDAOImpSQLServer();
				v.setAerolinea(LaerDAO.obtenerLAerea(idAerolinea));
												
			}
				
} catch (SQLException e) {
		System.out.println(e);
	}
		return v;
		
	}

	
	@Override
	public boolean eliminarVenta(Venta v) {
boolean exito = false;
		
		Connection con = null;
		PreparedStatement ps;
                
			con = Connect.getConnection();
        			
			try {
				ps = con.prepareStatement("DELETE FROM dbo.ventas WHERE id=?");
				ps.setString(1, v.getIdVenta());
		
		 if(ps.executeUpdate()>0)
	            {
			 exito=true;
	            }
					
	} catch (SQLException e) {
			System.out.println(e);
		}
			return exito;
	}

	@Override
	public List<Venta> obtenerVentas() {
		Connection con = null;
		Statement stVentas = null;
		
		List<Venta> ListadoVentas = new ArrayList<Venta>();
		
		con = Connect.getConnection();
		
		try {
			String query = "SELECT * FROM dbo.ventas";
						
			ResultSet rs=stVentas.executeQuery(query);
			
			while (rs.next()) {
				
				Venta v = new Venta(null, null, null, null, null, null);
				
				v.setIdVenta(rs.getString("id_venta")); 
				v.setDateVenta(rs.getDate("fec_hs_venta"));
				v.setFormaDePago(rs.getString("forma_pago"));
	            
	            String idCliente = rs.getString("id_cliente");
	            String idVuelo = rs.getString("id_vuelo");
	            String idAerolinea = rs.getString("id_aerolinea");
	          	            
	            //llamo a metodo obtener de cada clase
	            ClienteDAOImpSQLServer CliDAO = new ClienteDAOImpSQLServer();
	            v.setCliente(CliDAO.obtenerCliente(idCliente));
	            	            
	            // pasaporte y pasajero frecuente
	            VueloDAOImpSQLServer VuelDAO = new VueloDAOImpSQLServer();
				v.setVuelo(VuelDAO.obtenerVuelo(idVuelo));
	            
	            LineaAereaDAOImpSQLServer LaerDAO = new LineaAereaDAOImpSQLServer();
				v.setAerolinea(LaerDAO.obtenerLAerea(idAerolinea));
				
				ListadoVentas.add(v);
												
			}
				
} catch (SQLException e) {
		System.out.println(e);
	}
		return ListadoVentas;
	}

}

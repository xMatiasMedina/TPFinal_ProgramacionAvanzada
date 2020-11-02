package mvc.modelo.dao.daoimplementations.sqlserver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Direccion;
import util.Connect;

public class ClienteDAOImpSQLServer implements ClienteDAO {
	
	
	@Override
	public boolean registrarCliente(Cliente c) {
		boolean exito = false;
		
		//query
		String insertCliente = "INSERT INTO dbo.cliente (id_cliente, nombre, apellido, dni, cuit_cuil,"+
		"fecha_nacimiento, email, id_dirección, id_telefono, id_pasaporte, id_pasajero_frecuente)" +
		" VALUES (?,?,?,?,?,?,?,?,?,?,?)"		;
		
		try (Connection connection = Connect.getConnection();
			PreparedStatement psInsertCliente = 
					connection.prepareStatement(insertCliente)){
			//valores para insertar
			psInsertCliente.setString(1, c.getIdCliente());
			psInsertCliente.setString(2, c.getNombre());
			psInsertCliente.setString(3, c.getApellido());
			psInsertCliente.setString(4, c.getDni());
			psInsertCliente.setString(5, c.getCuit());
			psInsertCliente.setDate(6, (Date) c.getFechaDeNacimiento()); 
			psInsertCliente.setString(7, c.getEmail());
			psInsertCliente.setLong(8, c.getDireccion().getIdDireccion());
			psInsertCliente.setLong(9, c.getTelefono().getIdTelefono());
			psInsertCliente.setLong(10, c.getPasaporte().getIdPasaporte());
			psInsertCliente.setString(11, c.getPasajerofrecuente().getIdPasajeroFrecuente());
			
			
			psInsertCliente.execute();
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
	public boolean modificarCliente(Cliente c) {
boolean exito = false;
		
		//query
		String insertCliente = "UPDATE dbo.cliente SET id_cliente=?, nombre=?, apellido=?, dni=?, cuit_cuil=?,"+
		"fecha_nacimiento=?, email=?)";
		
		try (Connection connection = Connect.getConnection();
			PreparedStatement psInsertCliente = 
					connection.prepareStatement(insertCliente)){
			//valores para modificar
			psInsertCliente.setString(1, c.getIdCliente());
			psInsertCliente.setString(2, c.getNombre());
			psInsertCliente.setString(3, c.getApellido());
			psInsertCliente.setString(4, c.getDni());
			psInsertCliente.setString(5, c.getCuit());
			psInsertCliente.setDate(6, (Date) c.getFechaDeNacimiento()); 
			psInsertCliente.setString(7, c.getEmail());
					
			psInsertCliente.execute();
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
	public Cliente obtenerCliente(String id) {
		
		Connection con = null;
		PreparedStatement psCliente;
		
		con = Connect.getConnection();
		Cliente c = new Cliente();
		try {
			psCliente = con.prepareStatement("SELECT * FROM dbo.cliente WHERE id=?");
			psCliente.setString(1, id);
			
			
			ResultSet rs=psCliente.executeQuery();
			
			while (rs.next()) {
				c.setIdCliente(id); 
				c.setNombre(rs.getString("nombre"));
	            c.setApellido(rs.getString("apellido")); 
	            c.setDni(rs.getNString("dni"));
	            c.setCuit(rs.getString("cuit_cuil"));
	            c.setFechaDeNacimiento(rs.getDate("fecha_nacimiento"));
	            c.setEmail("email");
	            
	            String idDirección = rs.getString("id_direccion");
	            String idTelefono = rs.getString("id_telefono");
	            String idPasaporte = rs.getString("id_pasaporte");
	            String idPasajeroFrecuente = rs.getString("id_pasajero_frecuente");
	            
	            //llamo a metodo obtener de cada clase
	            DireccionDAOImplSQLServer DirDAO = new DireccionDAOImplSQLServer();
	            c.setDireccion(DirDAO.obtenerDireccion(idDirección));
	            
	            
			}
				
} catch (SQLException e) {
		System.out.println(e);
	}
		return c;
}
	

	@Override
	public boolean eliminarCliente(Cliente c) {
		boolean exito = false;
		
		Connection con = null;
		PreparedStatement ps;
                
			con = Connect.getConnection();
        			
			try {
				ps = con.prepareStatement("DELETE FROM dbo.cliente WHERE id=?");
				ps.setString(1, c.getIdCliente());
		
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

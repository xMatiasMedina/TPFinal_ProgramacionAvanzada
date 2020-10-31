package mvc.modelo.dao.daoimplementations.sqlserver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import mvc.modelo.dao.idaos.VueloDAO;
import mvc.modelo.dominio.Aeropuerto;
import mvc.modelo.dominio.Vuelo;
import mvc.modelo.dominio.Pais;
import mvc.modelo.dominio.Provincia;

import util.Connect;

public class VueloDAOImpSQLServer implements VueloDAO {

  @Override
    public Vuelo obtenerVuelo(String idVuelo) {
	  	Vuelo vu = null;
        Connection con = null;
        Statement st = null;
        try{
            con = Connect.getConnection();
            st = con.createStatement();

            String sqlVuelo = 
            "SELECT * from vuelo WHERE idVuelo = '" + idVuelo + "'";


            ResultSet rs = st.executeQuery(sqlVuelo);

           vu = new Vuelo();

           if (rs.next()) {
        	  vu.setIdVuelo(idVuelo);
        	  vu.setNroVuelo(rs.getString("nro_vuelo"));
        	  vu.setCantidadDeAsientos(rs.getInt ("ant_asientos"));
        	  vu.setDateSalida(rs.getDate ("fec_hs_salida"));
			  vu.setDateLlegada(rs.getDate ("fec_hs_llegada"));
			  vu.setTiempo(rs.getString ("tiempo_vuelo"));

			  String idPartida = rs.getString ("id_aeropuerto_salida");
			  String idLlegada = rs.getString ("id_aeropuerto_llegada");
			  
			  Statement stPartida = con.createStatement();
			  String sqlPartida = 
					"select a.*, pa.nombre_pais, pr.nombre_provincia" +
					" from (aeropuerto a inner join pais pa on pa.id_pais = a.id_pais)" +
					" inner join provincia pr on a.id_provincia = pr.id_provincia" +
					" where id_aeropuerto = " + idPartida;

			  ResultSet rsPartida = st.executeQuery(sqlPartida);
	          Aeropuerto partida = new Aeropuerto();
	          if(rsPartida.next()) {
	        	  partida.setIdentificacion(idPartida);
	        	  partida.setCiudad(rsPartida.getString("ciudad"));
	        	  partida.setPais(
	        			 new Pais(rsPartida.getInt("id_pais"), rsPartida.getString("nombre_pais")));
	        	  partida.setProvincia(
	        			 new Provincia(rsPartida.getInt("id_provincia"), rsPartida.getString("nombre_provincia")));
	          }
	            
			  Statement stLlegada = con.createStatement();
			  String sqlLlegada = 
					"select a.*, pa.nombre_pais, pr.nombre_provincia" +
					" from (aeropuerto a inner join pais pa on pa.id_pais = a.id_pais)" +
					" inner join provincia pr on a.id_provincia = pr.id_provincia" +
					" where id_aeropuerto = " + idLlegada;

			  ResultSet rsLlegada = st.executeQuery(sqlPartida);
	          Aeropuerto llegada = new Aeropuerto();
	          if(rsLlegada.next()) {
	        	  llegada.setIdentificacion(idPartida);
	        	  llegada.setCiudad(rsPartida.getString("ciudad"));
	        	  llegada.setPais(
	        			 new Pais(rsPartida.getInt("id_pais"), rsPartida.getString("nombre_pais")));
	        	  llegada.setProvincia(
	        			 new Provincia(rsPartida.getInt("id_provincia"), rsPartida.getString("nombre_provincia")));
	          }
	          
	          vu.setAeropuertoDeLlegada(llegada);
	          vu.setAeropuertoDeSalida(partida);
           }            
           
       } catch (SQLException e) {
           e.printStackTrace();        
       } finally {
           try { 
               st.close();
               con.close();  
               System.out.println("La conexión a la DB ha sido cerrada.");              
           } catch (SQLException e) {
               e.printStackTrace();
           }            
       }        

        return vu;
    }


@Override
	public boolean registrarVuelo(Vuelo v) {
		boolean exito = false;
		
		String insertSqlVuelo = 
			"INSERT INTO dbo.vuelos (id_vuelo, cant_asientos, fec_hs_salida, fec_hs_llegada," +
			" tiempo_vuelo, id_aerolinea, id_aeropuerto_salida, aeropuerto_llegada)" +
			" values (?,?,?,?,?,?,?,?)";
			
			try (Connection connection = Connect.getConnection();
				PreparedStatement psInsertaVuelo = 
					connection.prepareStatement(insertSqlVuelo)) {
					psInsertaVuelo.setString(1, v.getIdVuelo());
					psInsertaVuelo.setInt(2, v. getCantidadDeAsientos());
					java.sql.Date fechaSalida = new  java.sql.Date(v. getDateSalida().getTime());
					psInsertaVuelo.setDate(3, fechaSalida);	
					java.sql.Date fechaLlegada = new  java.sql.Date(v. getDateLlegada().getTime());
					psInsertaVuelo.setDate(4, fechaLlegada);	
					psInsertaVuelo.setString(5, v.getTiempo()); 
					psInsertaVuelo.setInt(6, v.getLineaAerea().getId());
					psInsertaVuelo.setString(7, v.getAeropuertoDeSalida().getIdentificacion());
					psInsertaVuelo.setString(8, v.getAeropuertoDeLlegada().getIdentificacion());
				
				psInsertaVuelo.execute();
	         	exito = true;
			}catch (SQLException e) {
		    	e.printStackTrace();
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		    
		    return exito;
		}


    @Override
    public void modificarVuelo(Vuelo v) {
		boolean exito = false;
		
        Connection con = null;
        Statement st = null;
        try{
            con = Connect.getConnection();
            st = con.createStatement();
            int registrosActualizados = st.executeUpdate("UPDATE Vuelo\n" +
            "SET cantidadDeAsientos = " + v. getCantidadDeAsientos() +             
            " WHERE idVuelo = '" + v.getIdVuelo() + "'"); 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }   
    }


@Override
    public boolean eliminarVuelo(Vuelo v) {
		boolean exito = false;
	
        Connection con = null;
        Statement st = null;
        try {
            con = Connect.getConnection();
            st = con.createStatement();
            
            st.execute("DELETE FROM Vuelo WHERE idVuelo = '" + v.getIdVuelo() + "'");
            exito = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return exito;
    }

//TODO implementar
@Override
public List<Vuelo> getAll() {
	// TODO Auto-generated method stub
	return null;
}
}




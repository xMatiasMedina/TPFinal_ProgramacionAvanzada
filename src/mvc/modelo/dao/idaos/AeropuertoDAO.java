package mvc.modelo.dao.idaos;

import java.util.List;

import mvc.modelo.dominio.Aeropuerto;

public interface AeropuertoDAO {

		public Aeropuerto obtenerAeropuerto(String id);
		public void agregarAeropuerto(Aeropuerto aeropuerto);
		public void removeAeropuerto(Aeropuerto aeropuerto);

		public List<Aeropuerto> getAll();
}

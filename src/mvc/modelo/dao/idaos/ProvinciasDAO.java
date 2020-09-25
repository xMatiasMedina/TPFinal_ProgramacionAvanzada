package mvc.modelo.dao.idaos;

import java.util.List;

import mvc.modelo.dominio.Provincia;

public interface ProvinciasDAO {
	
	public Provincia getProvincia(String nombre);
	
	public List<String> getAllasString();
}

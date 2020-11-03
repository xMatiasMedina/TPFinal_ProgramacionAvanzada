package mvc.modelo.dao.idaos;

import java.util.List;

import mvc.modelo.dominio.Pais;

public interface PaisDAO {
	
	public Pais getPais(String id);
	
	public List<String> getAllasString();
}

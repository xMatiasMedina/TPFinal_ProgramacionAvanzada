package mvc.modelo.dao.idaos;

import java.util.List;

import mvc.modelo.dominio.Pais;

public interface PaisDAO {
	
	public Pais getPais(String nombre);
	
	public List<String> getAllasString();

	public Pais getPais(int idpais);
	
	public void addPais(Pais pais);
	
	public void removePais(Pais pais);
}

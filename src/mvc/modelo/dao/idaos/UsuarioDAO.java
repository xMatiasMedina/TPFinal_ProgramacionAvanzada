package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Usuario;

public interface UsuarioDAO {
	public Usuario getUsuario(String userNombre);
	public boolean addUser(Usuario usuario);
	
}

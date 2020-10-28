package mvc.modelo.dao.idaos;

import java.util.List;

import mvc.modelo.dominio.Usuario;

/**
 * 
 * Los usuarios entran con un tipo Cliente-id para poder identificarlos
 *
 */

public interface UsuarioDAO {
	public Usuario getUsuario(String userNombre);
	public Usuario getUsuario(int idUser);
	public void addUser(Usuario usuario);
	public void deleteUser(Usuario usuario);
	public List<Usuario> getAll();
}

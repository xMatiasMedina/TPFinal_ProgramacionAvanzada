package mvc.modelo.bll;

import java.util.List;
import java.util.stream.Collectors;

import com.sun.istack.internal.NotNull;

import mvc.modelo.dominio.Usuario;

//Business Logic Layer for user

public class UsuarioBLL {
	
	public boolean validateUser(Usuario usuario1, Usuario usuario2) {
		return usuario1.getPassword().equals(usuario2.getPassword());
	}
	
	public int getUserID(@NotNull Usuario usuario) {
		return Integer.parseInt(usuario.getType().split("-")[1]);
	}
	
	public String getUserType(@NotNull Usuario usuario) {
		return usuario.getType().split("-")[0];
	}
	
	public int getTypeAmount(List<Usuario> usuarios, String type) {
		return  usuarios.stream().filter
				(a -> getUserType(a).equals(type)).collect(Collectors.toList()).size();
	}
}

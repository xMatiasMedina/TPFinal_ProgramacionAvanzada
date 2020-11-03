package mvc.modelo.dominio;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	String idusuario, username, password, type;

	public Usuario(String idusuario, String username, String password, String type) {
		this.idusuario = idusuario;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}

	public String getIdusuario() {
		return idusuario;
	}
	
	
}

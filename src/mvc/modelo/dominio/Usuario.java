package mvc.modelo.dominio;

public class Usuario {
	
	String username, password, type;

	public Usuario(String username, String password, String type) {
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
}

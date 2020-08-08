package mvc.modelo.dominio;

public enum Alianza {
	ONEWORLD (1,"Oneworld"),
	SKYTEAM(2,"SkyTeam"),
	STARALLIANCE(3,"Star Alliance");
	
	public final int key;
	public final String value;
	
	private Alianza(int key,String value) {
		this.key = key;
		this.value = value;
	}
}

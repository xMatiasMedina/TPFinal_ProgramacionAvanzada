package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Vuelo;

public interface VueloDAO {
    public boolean registrarVuelo(Vuelo vuelo);
    public void modificarVuelo(Vuelo vuelo);
    public Vuelo obtenerVuelo(String vuelo);//TODO a asignar
    public boolean eliminarVuelo(Vuelo vuelo);
}

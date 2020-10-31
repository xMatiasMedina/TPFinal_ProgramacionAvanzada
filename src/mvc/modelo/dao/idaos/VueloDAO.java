package mvc.modelo.dao.idaos;

import java.util.List;

import mvc.modelo.dominio.Vuelo;

public interface VueloDAO {
    public boolean registrarVuelo(Vuelo vuelo);
    public void modificarVuelo(Vuelo vuelo);
    public Vuelo obtenerVuelo(String vuelo);//TODO a asignar
    public boolean eliminarVuelo(Vuelo vuelo);
    public List<Vuelo> getAll();
    //TODO necesito un getAll para minimizar evitar mucho codigo en el front
}

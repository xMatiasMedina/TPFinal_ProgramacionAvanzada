package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.LineaAerea;

public interface LineaAereaDAO {
    public boolean registrarLAerea(LineaAerea lineaAerea);
    public void modificarLAerea(LineaAerea lineaAerea);
    public LineaAerea obtenerLAerea(String nombre);
    public boolean eliminarLAerea(LineaAerea lineaAerea);
}

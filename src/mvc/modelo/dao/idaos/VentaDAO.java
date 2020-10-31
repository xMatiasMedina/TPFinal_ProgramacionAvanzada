package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Venta;

import java.util.List;

public interface VentaDAO {
    public boolean registrarVenta(Venta venta);
    public void modificarVenta(Venta venta);
    public Venta obtenerVenta(String idVenta);
    public boolean eliminarVenta(Venta venta);
    public List<Venta> obtenerVentas();
}

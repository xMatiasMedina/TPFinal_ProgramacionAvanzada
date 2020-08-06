package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Venta;

public interface VentaDAO {
    public boolean registrarVenta(Venta venta);
    public boolean modificarVenta(Venta venta);
    public Venta obtenerVentas(Cliente cliente);
    public boolean eliminarVenta(Venta venta);
}

package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Cliente;

public interface ClienteDAO {
    public boolean registrarCliente(Cliente cliente);
    public boolean modificarCliente(Cliente cliente);
    public Cliente obtenerCliente(String id);
    public boolean eliminarCliente(Cliente cliente);
}

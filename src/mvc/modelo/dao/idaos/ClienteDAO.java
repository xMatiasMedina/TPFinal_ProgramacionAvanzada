package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Cliente;

public interface ClienteDAO {
    public boolean registrarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public Cliente obtenerCliente(int id);
    public boolean eliminarCliente(Cliente cliente);
}

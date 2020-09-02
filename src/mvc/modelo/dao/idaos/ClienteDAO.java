package mvc.modelo.dao.idaos;

import mvc.modelo.dominio.Cliente;

public interface ClienteDAO {
    public boolean registrarCliente(Cliente cliente);
    public void modificarCliente(Cliente cliente);
    public Cliente obtenerCliente(String dni);
    public boolean eliminarCliente(Cliente cliente);
}

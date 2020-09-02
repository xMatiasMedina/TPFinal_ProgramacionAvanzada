package mvc.modelo.dao.daoimplementations;

import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dominio.Cliente;

import java.io.*;
import java.util.List;

public class ClienteDAOImpObjectStream implements ClienteDAO, AutoCloseable {

    private File file;
    private List<Cliente> clientes;

    /*
    Si llegara a dar error en el jar me hice una libreria para solucionar este tipo de problemas.
    Como crea un archivo nuevo si no existe en principio no deberia haber problema, aun asi como no es
    un path absoluto no estoy seguro. (Con esto me refiero al JAR no a una compilacion de repositorio)
     */
    public ClienteDAOImpObjectStream() {
        file = new File("resource/objectfiles/clientes.dat");
        readFile();
    }

    @Override
    public boolean registrarCliente(Cliente cliente) {
        boolean result = clientes.add(cliente);
        updateFile();
        return result;
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        clientes.forEach(a -> {
            for (int i = 0; i < clientes.size(); i++)
                if(clientes.get(i).getIdCliente()==cliente.getIdCliente())
                    clientes.add(i,cliente);
        });
        updateFile();
    }

    private void updateFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
            writer.writeObject(clientes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            clientes = (List<Cliente>) reader.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente obtenerCliente(String dni) {
        for (int i = 0; i < clientes.size(); i++)
            if(clientes.get(i).getDni().equals(dni))
                return clientes.get(i);
        return null;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++)
            if(clientes.get(i).getIdCliente()==cliente.getIdCliente()) {
                clientes.remove(cliente);
                updateFile();
                return true;
            }
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}

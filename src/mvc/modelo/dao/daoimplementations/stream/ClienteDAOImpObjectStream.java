package mvc.modelo.dao.daoimplementations.stream;

import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dominio.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpObjectStream implements ClienteDAO, AutoCloseable {

    private String file;
    private List<Cliente> clientes;
     
    public ClienteDAOImpObjectStream() {
        file = "resources/objectfiles/clientes.dat";
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
            clientes = new ArrayList<Cliente>();
        }
    }

    @Override
    public Cliente obtenerCliente(int id) {
    	for (Cliente cliente : clientes) 
			if(cliente.getIdCliente().equals(""+id))
				return cliente;
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


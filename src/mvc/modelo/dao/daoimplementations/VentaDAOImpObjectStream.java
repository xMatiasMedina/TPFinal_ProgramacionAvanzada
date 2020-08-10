package mvc.modelo.dao.daoimplementations;

import mvc.modelo.dao.idaos.VentaDAO;
import mvc.modelo.dominio.Cliente;

import mvc.modelo.dominio.Venta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOImpObjectStream implements VentaDAO, AutoCloseable {

    private File file;
    private List<Venta> ventas;

    /*
    Si llegara a dar error en el jar me hice una libreria para solucionar este tipo de problemas.
    Como crea un archivo nuevo si no existe en principio no deberia haber problema, aun asi como no es
    un path absoluto no estoy seguro. (Con esto me refiero al JAR no a una compilacion de repositorio)
     */
    public VentaDAOImpObjectStream() {
        file = new File("resource/objectfiles/ventas.dat");
        readFile();
    }

    @Override
    public boolean registrarVenta(Venta venta) {
        boolean result = ventas.add(venta);
        updateFile();
        return result;
    }

    @Override
    public void modificarVenta(Venta venta) {
        ventas.forEach(a -> {
            for (int i = 0; i < ventas.size(); i++)
                if(ventas.get(i).getIdVenta()==venta.getIdVenta())
                    ventas.add(i,venta);
        });
        updateFile();
    }

    @Override
    public List<Venta> obtenerVentas(Cliente cliente) {
        List<Venta> result = new ArrayList<>();
        for (int i = 0; i < ventas.size(); i++)
            if(ventas.get(i).getCliente().getDni().equals(cliente.getDni()))
                result.add(ventas.get(i));
        return result;
    }

    @Override
    public boolean eliminarVenta(Venta venta) {
        for (int i = 0; i < ventas.size(); i++)
            if(ventas.get(i).getIdVenta()==venta.getIdVenta()) {
                ventas.remove(venta);
                updateFile();
                return true;
            }
        return false;
    }

    private void updateFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
            writer.writeObject(ventas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            ventas = (List<Venta>) reader.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {

    }
}

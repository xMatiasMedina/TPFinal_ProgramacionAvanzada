package mvc.modelo.dao.daoimplementations;

import mvc.modelo.dao.idaos.VueloDAO;
import mvc.modelo.dominio.Vuelo;

import java.io.*;
import java.util.List;

public class VueloDAOImpObjectStream implements VueloDAO, AutoCloseable {

    private File file;
    private List<Vuelo> vuelos;

    /*
    Si llegara a dar error en el jar me hice una libreria para solucionar este tipo de problemas.
    Como crea un archivo nuevo si no existe en principio no deberia haber problema, aun asi como no es
    un path absoluto no estoy seguro. (Con esto me refiero al JAR no a una compilacion de repositorio)
     */
    public VueloDAOImpObjectStream() {
        file = new File("resource/objectfiles/vuelos.dat");
        readFile();
    }

    @Override
    public boolean registrarVuelo(Vuelo vuelo) {
        boolean result = vuelos.add(vuelo);
        updateFile();
        return result;
    }

    @Override
    public void modificarVuelo(Vuelo vuelo) {
        vuelos.forEach(a -> {
            for (int i = 0; i < vuelos.size(); i++)
                if(vuelos.get(i).getIdVuelo().equals(vuelo.getIdVuelo()))
                    vuelos.add(i,vuelo);
        });
        updateFile();
    }

    @Override
    public Vuelo obtenerVuelo(String numeroVuelo) {
        for (int i = 0; i < vuelos.size(); i++)
            if(vuelos.get(i).getIdVuelo().equals(numeroVuelo))
                return vuelos.get(i);
        return null;
    }

    @Override
    public boolean eliminarVuelo(Vuelo vuelo) {
        for (int i = 0; i < vuelos.size(); i++)
            if(vuelos.get(i).getIdVuelo().equals(vuelo.getIdVuelo())) {
                vuelos.remove(vuelo);
                updateFile();
                return true;
            }
        return false;
    }

    private void updateFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
            writer.writeObject(vuelos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            vuelos = (List<Vuelo>) reader.readObject();
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

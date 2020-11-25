package mvc.modelo.dao.daoimplementations.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mvc.modelo.dao.idaos.AeropuertoDAO;
import mvc.modelo.dominio.Aeropuerto;
import mvc.modelo.dominio.Vuelo;

public class AeropuertoDAOImpStream implements AeropuertoDAO{

	private File file;
	private List<Aeropuerto> aeropuertos;
	
	public AeropuertoDAOImpStream() {
		file = new File("resources/objectfiles/aeropuertos.dat");
        aeropuertos = new ArrayList<Aeropuerto>();
        readFile();
	}
	
	@Override
	public Aeropuerto obtenerAeropuerto(String id) {
		return aeropuertos.stream().filter(a -> a.getIdentificacion().equals(id)).findFirst().get();
	}

	@Override
	public void agregarAeropuerto(Aeropuerto aeropuerto) {
		aeropuertos.add(aeropuerto);
		updateFile();
	}

	@Override
	public void removeAeropuerto(Aeropuerto aeropuerto) {
		for (int i = 0; i < aeropuertos.size(); i++) 
			if(aeropuertos.get(i).getIdentificacion().equals(aeropuerto.getIdentificacion()))
				aeropuertos.remove(i);
		updateFile();
	}

	@Override
	public List<Aeropuerto> getAll() {
		return aeropuertos;
	}

	  private void updateFile() {
	        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
	            writer.writeObject(aeropuertos);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void readFile(){
	        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
	            aeropuertos = (List<Aeropuerto>) reader.readObject();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}

package mvc.modelo.dao.daoimplementations.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mvc.modelo.dao.idaos.PaisDAO;
import mvc.modelo.dominio.Pais;

public class PaisDAOImpFileStream implements PaisDAO, AutoCloseable {
	
	private static PaisDAOImpFileStream instance;
	private List<Pais> paises;
	private String file;
	
	public PaisDAOImpFileStream() {
		paises = new ArrayList<Pais>();
		this.file = "resources/objectfiles/paises.txt";
		readFile();
	}
	
	@Override
	public Pais getPais(String nombre) {
		for (Pais pais : paises) 
			if(pais.getNombre().equals(nombre))
				return pais;
		return null;
	}

	@Override
	public List<String> getAllasString() {
		List<String> nombres = new ArrayList<String>();
		for (Pais pais : paises) 
			nombres.add(pais.getNombre());
		return nombres;
	}
	
	public static PaisDAOImpFileStream getInstance() {
		if(instance == null)
			instance = new PaisDAOImpFileStream();
		return instance;
	}
	
	//Todos los paises tienen id 0 en implementacion por files
	public void readFile() {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line;
			while((line = reader.readLine())!= null)
				paises.add(new Pais(0, line));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updateFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
            writer.writeObject(paises);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	 }

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pais getPais(int idpais) {
		return paises.stream().filter(a -> a.getIdPais() == idpais).findFirst().get();
	}

	@Override
	public void addPais(Pais pais) {
		paises.add(pais);
		updateFile();
	}

	@Override
	public void removePais(Pais pais) {
		for (int i = 0; i < paises.size(); i++) 
			if(paises.get(i).getNombre().equals(pais.getNombre()))
				paises.remove(i);
	}
}

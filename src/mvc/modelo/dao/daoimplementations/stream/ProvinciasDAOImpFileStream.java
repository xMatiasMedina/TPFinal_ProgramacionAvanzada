package mvc.modelo.dao.daoimplementations.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mvc.modelo.dao.idaos.ProvinciasDAO;
import mvc.modelo.dominio.Pais;
import mvc.modelo.dominio.Provincia;

public class ProvinciasDAOImpFileStream implements ProvinciasDAO, AutoCloseable {
	private static ProvinciasDAOImpFileStream instance;
	private List<Provincia> provincias;
	private String file;
	
	public ProvinciasDAOImpFileStream() {
		provincias = new ArrayList<Provincia>();
		this.file = "resources/objectfiles/provincias.txt";
		readFile();
	}
	
	@Override
	public Provincia getProvincia(String nombre) {
		for (Provincia prov : provincias) 
			if(prov.getNombre().equals(nombre))
				return prov;
		return null;
	}

	@Override
	public List<String> getAllasString() {
		List<String> nombres = new ArrayList<String>();
		for (Provincia prov : provincias) 
			nombres.add(prov.getNombre());
		return nombres;
	}
	
	public static ProvinciasDAOImpFileStream getInstance() {
		if(instance == null)
			instance = new ProvinciasDAOImpFileStream();
		return instance;
	}
	
	//Todos las provincias tienen id 0 en implementacion por files
	public void readFile() {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line;
			while((line = reader.readLine())!= null)
				provincias.add(new Provincia(0, line));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}

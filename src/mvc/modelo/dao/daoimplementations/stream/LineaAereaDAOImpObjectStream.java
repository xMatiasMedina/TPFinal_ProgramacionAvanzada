package mvc.modelo.dao.daoimplementations.stream;

import mvc.modelo.dao.idaos.LineaAereaDAO;
import mvc.modelo.dominio.LineaAerea;

import java.io.*;
import java.util.List;

public class LineaAereaDAOImpObjectStream implements LineaAereaDAO,AutoCloseable {

    private File file;
    private List<LineaAerea> lineaAereas;

    /*
    Si llegara a dar error en el jar me hice una libreria para solucionar este tipo de problemas.
    Como crea un archivo nuevo si no existe en principio no deberia haber problema, aun asi como no es
    un path absoluto no estoy seguro. (Con esto me refiero al JAR no a una compilacion de repositorio)
     */
    public LineaAereaDAOImpObjectStream() {
        file = new File("resource/objectfiles/lineasaereas.dat");
        readFile();
    }

    @Override
    public boolean registrarLAerea(LineaAerea lineaAerea) {
        boolean result = lineaAereas.add(lineaAerea);
        updateFile();
        return result;
    }

    @Override
    public void modificarLAerea(LineaAerea lineaAerea) {
        lineaAereas.forEach(a -> {
            for (int i = 0; i < lineaAereas.size(); i++)
                if(lineaAereas.get(i).getId()==lineaAerea.getId())
                    lineaAereas.add(i,lineaAerea);
        });
        updateFile();
    }

    @Override
    public LineaAerea obtenerLAerea(String nombre) {
        for (int i = 0; i < lineaAereas.size(); i++)
            if(lineaAereas.get(i).getAerolinea().equals(nombre))
                return lineaAereas.get(i);
        return null;
    }

    @Override
    public boolean eliminarLAerea(LineaAerea lineaAerea) {
        for (int i = 0; i < lineaAereas.size(); i++)
            if(lineaAereas.get(i).getId()==lineaAerea.getId()) {
                lineaAereas.remove(lineaAerea);
                updateFile();
                return true;
            }
        return false;
    }

    private void updateFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
            writer.writeObject(lineaAereas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            lineaAereas = (List<LineaAerea>) reader.readObject();
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

	@Override
	public LineaAerea obtenerLAerea(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

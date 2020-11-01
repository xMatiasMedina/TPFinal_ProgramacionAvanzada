package mvc.modelo.dao.daoimplementations.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mvc.modelo.dao.idaos.UsuarioDAO;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Usuario;

public class UsuarioDAOImpObjectStream implements UsuarioDAO, AutoCloseable{
	
	private String file;
	private List<Usuario> usuarios;
	
	public UsuarioDAOImpObjectStream() {
		file = "resources/objectfiles/usuarios.dat";
		readFile();
	}

	@Override
	public Usuario getUsuario(String userNombre) {
		for (Usuario usuario : usuarios) 
			if(usuario.getUsername().equals(userNombre))
				return usuario;
		return null;
	}
	

	@Override
	public void addUser(Usuario usuario) {
		usuarios.add(usuario);
		updateFile();
	}
	
	

	@Override
	public List<Usuario> getAll() {
		return usuarios;
	}
	
	private void updateFile() {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))){
            writer.writeObject(usuarios);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void readFile(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(file))) {
            usuarios = (List<Usuario>) reader.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
            usuarios = new ArrayList<Usuario>();
        }

}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Usuario usuario) {
		for (int i = 0; i < usuarios.size(); i++) 
			if(usuario.getUsername().equals(usuarios.get(i).getUsername()))
				usuarios.remove(i);
		updateFile();
	}

	@Override
	public Usuario getUsuario(int idUser) {
		for (Usuario usuario : usuarios) 
			if(usuario.getType().split("-")[1].equals(idUser+""))
				return usuario;
		return null;
	}
}

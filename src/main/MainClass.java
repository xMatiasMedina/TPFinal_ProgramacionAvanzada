package main;

import mvc.controllers.ClienteController;
import mvc.controllers.UsuarioController;
import mvc.modelo.dao.factories.UsuarioDAOFactory;
import util.AeropuertoHelper;
import util.UsuarioHelper;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		preset();
		UsuarioController controller = new UsuarioController();
		controller.startLogin();
	}
	
	public static void preset() {
		UsuarioHelper.addAdmin();
		AeropuertoHelper.addAeropuertos();
	}
}

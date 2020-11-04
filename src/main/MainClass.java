package main;

import mvc.controllers.ClienteController;
import mvc.controllers.UsuarioController;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioController controller = new UsuarioController();
		controller.startLogin();
	}
}

package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import mvc.modelo.dao.idaos.UsuarioDAO;
import mvc.views.clientscreens.ClientRegisterFrame;
import mvc.views.loginscreens.UserLoginFrame;

public class UsuarioController implements ActionListener {
	
	private JFrame view;
	private UsuarioDAO dao;
	
	public void startLogin() {
		view = new UserLoginFrame(this);
		view.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "Login_bt": 
			view.setVisible(false);
			view = new ClientRegisterFrame(this);
			view.setVisible(true);
		}
	}
	

}

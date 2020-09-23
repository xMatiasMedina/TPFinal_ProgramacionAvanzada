package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import mvc.modelo.bll.UsuarioBLL;
import mvc.modelo.dao.idaos.UsuarioDAO;
import mvc.modelo.dominio.Usuario;
import mvc.views.clientscreens.ClientRegisterFrame;
import mvc.views.loginscreens.UserLoginFrame;
import mvc.views.loginscreens.UserRegisterPanel;

public class UsuarioController implements ActionListener {
	
	private UserLoginFrame view;
	private UsuarioDAO dao;
	
	public void startLogin() {
		view = new UserLoginFrame(this);
		view.setVisible(true);
		dao = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioBLL bll = new UsuarioBLL();
		switch(e.getActionCommand()) {
		case "Register_bt1": 
			view.switchPanel();
			break;
		case "Register_bt2": 
			UserRegisterPanel rpanel = view.getRegister_panel();
			String username = rpanel.getUsername_tf().getText();
			if(dao.getUsuario(username) == null) {
				String password =  rpanel.getPassword_pf().getText();
				String type = (String) rpanel.getType_cb().getSelectedItem();
				int id = bll.getTypeAmount(dao.getAll(), type)+1;
				dao.addUser(new Usuario(username, password, type+"-"+id));
			}else
				view.printPaneError("Ese usuario ya existe");
			break;
		case "Login_bt":
			UserRegisterPanel lpanel = view.getRegister_panel();
			String user = lpanel.getUsername_tf().getText();
			String pass =  lpanel.getPassword_pf().getText();
			Usuario dbuser = dao.getUsuario(user);
			if(dbuser == null)
				view.printPaneError("User does not exist");
			else if(bll.validateUser(new Usuario(user, pass, null), dbuser))
				view.printPaneError("Incorrect password");
			else {
				//TODO pasar a ventana correspondiente
				String itype = bll.getUserType(dbuser);
				if("Cliente".equals(itype)) {
					
				}else if("Proveedor".equals(itype)){
					
				}else {
					//TODO esto seria para el admin
				}
			}
			break;
		}
	}
	

}

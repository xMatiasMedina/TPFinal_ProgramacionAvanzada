package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;

import javax.swing.JFrame;

import com.sun.istack.internal.Nullable;

import mvc.modelo.bll.UsuarioBLL;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.factories.UsuarioDAOFactory;
import mvc.modelo.dao.idaos.UsuarioDAO;
import mvc.modelo.dominio.Usuario;
import mvc.views.clientscreens.ClientFrame;
import mvc.views.loginscreens.UserLoginFrame;
import mvc.views.loginscreens.UserLoginPanel;
import mvc.views.loginscreens.UserRegisterPanel;

public class UsuarioController implements ActionListener {
	
	private UserLoginFrame view;
	private UsuarioDAO dao;
	
	public void startLogin() {
		view = new UserLoginFrame(this);
		view.setVisible(true);
		dao = UsuarioDAOFactory.getUsuarioDAOImp(ImpType.STREAM);
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
					dao.addUser(new Usuario(String.valueOf(dao.getAll().size()+1),username, password, type+"-"+id));
					this.redirect(type, id);
				}else
					view.printPaneError("Username has already been taken");
				break;
			case "Login_bt":
				UserLoginPanel lpanel = view.getLogin_panel();
				String user = lpanel.getUser_tf().getText();
				String pass =  String.copyValueOf(lpanel.getPasswordField().getPassword());
				Usuario dbuser = dao.getUsuario(user);
				if(dbuser == null)
					view.printPaneError("User does not exist");
				else if(!bll.validateUser(new Usuario(null,user, pass, null), dbuser))
					view.printPaneError("Incorrect password");
				else {
					//TODO pasar a ventana correspondiente
					String itype = bll.getUserType(dbuser);
					this.redirect(itype, itype == "admin"?null:bll.getUserID(dbuser));
				}
				break;
		}
	}
	
	public void deleteUser(int idUser, String tipo) {
		Usuario usuario = dao.getAll().stream().filter(a -> {
			if(!a.getType().equals("admin")) {
			String[] info = a.getType().split("-");
				if(info[0].equals(tipo) && info[1].equals(String.valueOf(idUser)))
					return true;
			}
			return false;
		}).collect(Collectors.toList()).get(0);
		dao = UsuarioDAOFactory.getUsuarioDAOImp(ImpType.STREAM);
		dao.deleteUser(dao.getUsuario(usuario.getUsername()));
	}
	
	private void redirect(String itype, @Nullable int id) {
		this.view.setVisible(false);
		if("Cliente".equals(itype)) {
			new ClienteController(id);
		}else if("Proveedor".equals(itype)){
			new LineaAereaController(id);
		}else {
			new AdminController();
		}
	}
	

}

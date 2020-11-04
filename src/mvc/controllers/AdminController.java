package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.modelo.dao.daoimplementations.sqlserver.PaisDAOImpSQLServer;
import mvc.modelo.dominio.Pais;
import mvc.views.adminscreens.AdminFrame;

public class AdminController implements ActionListener {
	
	private AdminFrame adminframe;

	public AdminController() {
		adminframe = new AdminFrame(this, new AeropuertoController(adminframe));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch(e.getActionCommand()) {
			case "pDelete_bt":
				PaisDAOImpSQLServer.getInstance().
				removePais(new Pais(Integer.valueOf(adminframe.getAdminPanel().getIdpais_tf().getText()), null));
				break;
			case "arAgregar_bt":
				PaisDAOImpSQLServer.getInstance().addPais(new Pais(-1, adminframe.askInput("Nombre de Pais")));
				break;
			}
			}catch(NullPointerException | NumberFormatException e1) {
				e1.printStackTrace();
				adminframe.printPaneError("Something went wrong");
		}
	}
}

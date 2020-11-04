package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mvc.modelo.dao.daoimplementations.sqlserver.LineaAereaDAOImpSQLServer;
import mvc.modelo.dao.idaos.LineaAereaDAO;
import mvc.modelo.dominio.Alianza;
import mvc.modelo.dominio.LineaAerea;
import mvc.views.proveedorscreens.LineaAereaFrame;
import mvc.views.proveedorscreens.RegistrarAerolineaPanel;

public class LineaAereaController implements ActionListener {

	private LineaAereaDAO dao;
	private LineaAereaFrame view;
	private int idLineaAerea;
	
	public LineaAereaController(int idLineaAerea) {
		this.dao = new LineaAereaDAOImpSQLServer();
		this.view = new LineaAereaFrame(this, Alianza.values());
		this.view.setVisible(true);
		this.idLineaAerea = idLineaAerea;
		validarLineaAerea();
		new VueloController(idLineaAerea,view.getAddVuelosPanel(), view.getManageVuelosPanel());
	}
	
	private void validarLineaAerea() {
		if((dao.obtenerLAerea(idLineaAerea)) == null) {
			view.printPaneWarning("You haven't registered yet");
			view.switchPanel(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "RDone_bt":
			if(dao.obtenerLAerea(idLineaAerea) == null) 
				dao.registrarLAerea(getLineaAerea());
			else 
				dao.modificarLAerea(getLineaAerea());
			view.switchPanel(1);
			break;
		case "Modify_bt":
			view.switchPanel(0);
			break;
		case "Delete_bt":
			dao.eliminarLAerea(dao.obtenerLAerea(idLineaAerea));
			UsuarioController scontroller = new UsuarioController();
			scontroller.deleteUser(idLineaAerea, "Proveedor");
			view.setVisible(false);
			scontroller.startLogin();
			break;
	}		
	}
	
	private LineaAerea getLineaAerea() {
		RegistrarAerolineaPanel registro = view.getRegisterPanel();
		LineaAerea result =  new LineaAerea
				(registro.getArNombre_tf().getText(),
						(Alianza)registro.getAlianza_cbox().getSelectedItem());
		result.setId(idLineaAerea);
		return result;
	}

}

package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.WrongInputException;
import mvc.modelo.dao.daoimplementations.sqlserver.AeropuertoDAOImplSQLServer;
import mvc.modelo.dao.daoimplementations.sqlserver.PaisDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.ProvinciasDAOImpFileStream;
import mvc.modelo.dao.idaos.AeropuertoDAO;
import mvc.modelo.dominio.Aeropuerto;
import mvc.modelo.dominio.Provincia;
import mvc.views.adminscreens.AddAeropuertoPanel;
import mvc.views.adminscreens.AdminFrame;

public class AeropuertoController implements ActionListener{
	
	private AdminFrame adminframe;
	private AeropuertoDAO dao;

	public AeropuertoController(AdminFrame adminframe) {
		this.adminframe = adminframe;
		this.dao = new AeropuertoDAOImplSQLServer();
		adminframe.getAddAeropuertoPanel().loadCBoxes
		(PaisDAOImpSQLServer.getInstance().getAllasString(),
				ProvinciasDAOImpFileStream.getInstance().getAllasString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		switch(e.getActionCommand()) {
		case "Done_bt":
			if(dao.obtenerAeropuerto(loadAeropuerto().getIdentificacion()) != null)
				dao.agregarAeropuerto(loadAeropuerto());
			adminframe.switchPanel(0);
			break;
		case "arAgregar_bt":
			adminframe.switchPanel(1);
			break;
		case "arDelete_bt":
			dao.removeAeropuerto(dao.obtenerAeropuerto(adminframe.getAdminPanel().getAeropuerto_tf().getText()));
			break;
		}
		}catch(NullPointerException | WrongInputException e1) {
			e1.printStackTrace();
			adminframe.printPaneError("Something went wrong");
		}
	}
	
	private Aeropuerto loadAeropuerto() {
		AddAeropuertoPanel registro = adminframe.getAddAeropuertoPanel();
		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto.setIdentificacion(registro.getIdent_tf().getText());
		aeropuerto.setCiudad(registro.getCiudad_tf().getText());
		aeropuerto.setPais(PaisDAOImpSQLServer.getInstance().getPais((String)registro.getPais_cbox().getSelectedItem()));
		aeropuerto.setProvincia(ProvinciasDAOImpFileStream.getInstance().getProvincia((String) registro.getProv_cbox().getSelectedItem()));
		return aeropuerto;
	}

}

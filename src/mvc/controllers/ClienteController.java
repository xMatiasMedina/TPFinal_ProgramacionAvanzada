package mvc.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List.*;

import javax.swing.JComponent;
import javax.swing.JTextField;

import mvc.modelo.dao.daoimplementations.sqlserver.PaisDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.sqlserver.ProvinciasDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.ClienteDAOImpObjectStream;
import mvc.modelo.dao.daoimplementations.stream.PaisDAOImpFileStream;
import mvc.modelo.dao.daoimplementations.stream.ProvinciasDAOImpFileStream;
import mvc.modelo.dao.factories.ClienteDAOFactory;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dominio.Cliente;
import mvc.views.clientscreens.ClientFrame;

public class ClienteController implements ActionListener{
	
	private ClientFrame view;
	private ClienteDAO dao;
	private int idclient;
	
	public ClienteController(int id) {
		this.idclient = id;
		view = new ClientFrame(this,
				PaisDAOImpFileStream.getInstance().getAllasString().toArray(new String[5]),
				ProvinciasDAOImpFileStream.getInstance().getAllasString().toArray(new String[23]));
		view.setVisible(true);
		dao = ClienteDAOFactory.getClienteDAOImp(ImpType.STREAM);
		validateClient();
	}

	public void validateClient() {
		if(dao.obtenerCliente(this.idclient) == null) {
			view.printPaneWarning("You haven't registered yet");
			view.switchPanel(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "RDone_bt":
				registerClient();
				view.switchPanel(1);
				break;
		}
	}

	private void registerClient() {
		Cliente cliente = new Cliente();
	}

}

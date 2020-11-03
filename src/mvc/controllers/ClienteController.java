package mvc.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List.*;

import javax.swing.JComponent;
import javax.swing.JTextField;

import mvc.modelo.dao.daoimplementations.sqlserver.PaisDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.sqlserver.ProvinciasDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.PaisDAOImpFileStream;
import mvc.modelo.dao.daoimplementations.stream.ProvinciasDAOImpFileStream;
import mvc.modelo.dao.factories.ClienteDAOFactory;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Direccion;
import mvc.modelo.dominio.Pais;
import mvc.modelo.dominio.Pasaporte;
import mvc.modelo.dominio.Provincia;
import mvc.modelo.dominio.Telefono;
import mvc.views.clientscreens.ClientFrame;
import mvc.views.clientscreens.ClientRegisterPanel;

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
		dao = ClienteDAOFactory.getClienteDAOImp(ImpType.SQLSERVER);
		validateClient();
		new VentaController(id+"",view.getVuelosPanel(), view.getAdquiridosPanel());
		new VueloController(view.getVuelosPanel().getTable());
	}

	public void validateClient() {
		if(dao.obtenerCliente(String.valueOf(this.idclient)) == null) {
			view.printPaneWarning("You haven't registered yet");
			view.switchPanel(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "RDone_bt":
				if(dao.obtenerCliente(String.valueOf(this.idclient)) == null) 
					dao.registrarCliente(getClient());
				else 
					dao.modificarCliente(getClient());
				view.switchPanel(1);
				break;
			case "Modify_bt":
				view.switchPanel(0);
				break;
			case "Delete_bt":
				dao.eliminarCliente(dao.obtenerCliente(String.valueOf(idclient)));
				UsuarioController scontroller = new UsuarioController();
				scontroller.deleteUser(idclient);
				view.setVisible(false);
				scontroller.startLogin();
				break;
		}
	}
	
	//TODO Telefono no tenia seters, si lo quieren cambiar o 
	//mejorar en cuestiones de diseno tengan en cuenta que hay que cambiar todo esto.
	//Este metodo fue eterno /\ En stream como se puede ver no tienen id los objetos
	private Cliente getClient() {
		ClientRegisterPanel register = view.getRegisterPanel();
		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero(register.getNumeroPasaporte_tf().getText());
		pasaporte.setAutoridadDeEmision(register.getAutoridad_tf().getText());
		String paisID = String.valueOf(register.getPais_cbox().getSelectedIndex()+1);
		pasaporte.setPaisEmision
		("Otro".equals(PaisDAOImpSQLServer.getInstance().getPais(paisID).getNombre())?
				new Pais(-1, register.getOtro_tf().getText()):
			PaisDAOImpSQLServer.getInstance().getPais(paisID));//Validacion otro 1
		pasaporte.setFechaDeEmision(register.getEmision_tf().getDate());
		pasaporte.setFechaDeVencimiento(register.getVencimiento_tf().getDate());
		Direccion direccion = new Direccion();
		direccion.setCalle(register.getCalle_tf().getText());
		direccion.setAltura(register.getAltura_tf().getText());
		direccion.setCiudad(register.getCiudad_tf().getText());
		direccion.setCodigoPostal(register.getCodigo_tf().getText());
		String paisID2 = String.valueOf(register.getPais_cbox().getSelectedIndex()+1);
		direccion.setPais(PaisDAOImpSQLServer.getInstance().getPais(paisID2).getNombre().equals("Otro")?
				new Pais(-1, register.getOtro_tf2().getText())://TODO necesita un get por nombre
					PaisDAOImpSQLServer.getInstance().getPais(paisID2));//Validacion de otro 2
		if(!"Otro".equals(PaisDAOImpSQLServer.getInstance().getPais(paisID2).getNombre()))
			if("Argentina".equals(PaisDAOImpSQLServer.getInstance().getPais(paisID2).getNombre()))
				direccion.setProvincia
				(ProvinciasDAOImpFileStream.getInstance().getProvincia
						((String) register.getProvincia_cbox().getSelectedItem()));
			else
				direccion.setProvincia(new Provincia(-1, register.getOtro_tf2().getText()));//Esto es Estados de paises extranjeros
		Telefono telefono = new Telefono(
				register.getPersonal_tf().getText(),
				register.getCelular_tf().getText(),
				register.getLaboral_tf().getText()
				);
		Cliente cliente = new Cliente();
		cliente.setIdCliente(String.valueOf(idclient));//No pasen el id a la db, ahi deberia mantenerse sola
		cliente.setNombre(register.getNombre_tf().getText());
		cliente.setApellido(register.getApellido_tf().getText());
		cliente.setDni(register.getDni_tf().getText());
		cliente.setEmail(register.getDni_tf().getText());
		cliente.setCuit(register.getCuit_tf().getText());
		cliente.setPasaporte(pasaporte);
		cliente.setFechaDeNacimiento(register.getNacimiento_tf().getDate());
		cliente.setTelefono(telefono);
		cliente.setDireccion(direccion);
		return cliente;
	}
}
